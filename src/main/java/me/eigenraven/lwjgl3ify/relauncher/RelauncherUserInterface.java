package me.eigenraven.lwjgl3ify.relauncher;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.DefaultEditorKit;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Throwables;

/** Implements the UI components of the relauncher */
/*
 * Dev note on recompiling forms:
 * 1. Import into IntelliJ as a gradle project
 * 2. In gradle settings, change Build with: from Gradle to IntelliJ
 * 3. Open the .form file in the form editor and use the main menu Build->Recompile 'currentfile.form' function
 * 4. You might have to remove the build/libs and build/distributions files afterwards, IntelliJ messes with Gradle's
 * caching
 */
public class RelauncherUserInterface {

    private final Relauncher relauncher;
    private boolean swingInitialized = false;
    public boolean runClicked = false;

    public RelauncherUserInterface(Relauncher relauncher) {
        this.relauncher = relauncher;
    }

    // Only call from the Swing thread
    private void initSwingIfNeeded() {
        if (swingInitialized) {
            return;
        }
        swingInitialized = true;
        final ClassLoader original = Thread.currentThread()
            .getContextClassLoader();
        final ClassLoader mcLoader = RelauncherUserInterface.class.getClassLoader();
        Thread.currentThread()
            .setContextClassLoader(mcLoader);
        try {
            System.setProperty("awt.useSystemAAFontSettings", "on");
            if (System.getProperty("os.name")
                .toLowerCase(Locale.ROOT)
                .contains("linux")) {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (Exception e) {
            Relauncher.logger.warn("Could not initialize GUI theme", e);
        }
        Thread.currentThread()
            .setContextClassLoader(original);
    }

    private void invokeOnSwingThread(boolean wait, Runnable runnable) {
        try {
            if (wait) {
                SwingUtilities.invokeAndWait(runnable);
            } else {
                SwingUtilities.invokeLater(runnable);
            }
        } catch (InterruptedException e) {
            // cancelled
        } catch (InvocationTargetException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    public void downloadWithGui(Downloader dler) {
        invokeOnSwingThread(true, () -> {
            initSwingIfNeeded();

            final int totalTasks = dler.remainingTasks();
            final JDialog progressDialog = new JDialog(
                null,
                "Lwjgl3ify Library Downloader",
                Dialog.ModalityType.APPLICATION_MODAL);
            progressDialog.setMinimumSize(new Dimension(400, 128));
            progressDialog.setSize(new Dimension(400, 128));
            progressDialog.setLocationRelativeTo(null);
            progressDialog.setResizable(false);
            progressDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            final ProgressDialog dialogContent = new ProgressDialog();
            dialogContent.loadTranslations();
            progressDialog.add(dialogContent.panel);

            dialogContent.progressBar.setMinimum(0);
            dialogContent.progressBar.setMaximum(totalTasks);
            dialogContent.progressBar.setValue(0);
            dialogContent.cancelButton.addActionListener(al -> { relauncher.runtimeExit(1); });

            final Thread dlThread = new Thread(dler::runDownloads, "Download thread");
            dlThread.setContextClassLoader(RelauncherUserInterface.class.getClassLoader());
            dlThread.setDaemon(true);

            final AtomicBoolean normallyTerminated = new AtomicBoolean(false);
            final AtomicReference<Throwable> dlException = new AtomicReference<>(null);
            dlThread.setUncaughtExceptionHandler((_thread, exception) -> dlException.set(exception));

            final Timer updater = new Timer(1000 / 120, al -> {
                final int remaining = dler.remainingTasks();
                dialogContent.progressBar.setValue(totalTasks - remaining);
                final String files = StringUtils.join(dler.busyDownloads, ", ");
                dialogContent.filesLabel.setText(files);
                if (remaining <= 0) {
                    try {
                        dlThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    final Throwable exception = dlException.get();
                    if (exception != null) {
                        dialogContent.filesLabel.setText(
                            "Exception happened when downloading required files, check the log for details.\n"
                                + exception);
                        throw Throwables.propagate(exception);
                    }
                    normallyTerminated.set(true);
                    progressDialog.dispose();
                }
            });
            updater.start();

            progressDialog.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosed(WindowEvent e) {
                    if (!normallyTerminated.get()) {
                        relauncher.runtimeExit(1);
                    }
                }

                @Override
                public void windowOpened(WindowEvent e) {
                    dlThread.start();
                }
            });

            progressDialog.setVisible(true);
        });
    }

    private static long getTotalMemoryBytes() {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            Object attribute = mBeanServer
                .getAttribute(new ObjectName("java.lang", "type", "OperatingSystem"), "TotalPhysicalMemorySize");
            return Long.parseLong(attribute.toString());
        } catch (Exception e) {
            return 8192;
        }
    }

    public void startSettingsIfNeeded() {
        if (RelauncherConfig.config.hideSettingsOnLaunch) {
            // TODO: Show a countdown and add a way to show settings again
            return;
        }
        invokeOnSwingThread(true, () -> {
            initSwingIfNeeded();
            final JDialog settingsDialog = new JDialog(
                null,
                "Lwjgl3ify settings",
                Dialog.ModalityType.APPLICATION_MODAL);
            settingsDialog.setMinimumSize(new Dimension(800, 600));
            settingsDialog.setSize(new Dimension(800, 600));
            settingsDialog.setLocationRelativeTo(null);
            settingsDialog.setResizable(true);
            settingsDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            final SettingsDialog contents = new SettingsDialog();
            contents.loadTranslations();
            settingsDialog.add(contents.rootPanel);

            // Configure memory sliders
            final long totalSystemMemory = getTotalMemoryBytes();
            final int totalSystemMemoryMB = (int) ((totalSystemMemory + (1024 * 1024) - 1) / (1024 * 1024));
            contents.optMinMemory.setMaximum(totalSystemMemoryMB);
            contents.optMaxMemory.setMaximum(totalSystemMemoryMB);
            int memTickSpacing = 1024;
            while ((totalSystemMemoryMB / memTickSpacing) > 9) {
                memTickSpacing *= 2;
            }
            contents.optMinMemory.setLabelTable(null);
            contents.optMaxMemory.setLabelTable(null);
            contents.optMinMemory.setMajorTickSpacing(memTickSpacing);
            contents.optMaxMemory.setMajorTickSpacing(memTickSpacing);

            // Update labels
            contents.labelMinJavaVer
                .setText(String.format(contents.translations.getString(TranslationsBundle.KEY_MIN_MOD_JAVA), 17));

            // Set settings values
            final RelauncherConfig.ConfigObject initCfg = RelauncherConfig.config;
            final DefaultComboBoxModel<String> modelJavaPaths = new DefaultComboBoxModel<>(
                initCfg.javaInstallationsCache.clone());
            contents.comboJavaExecutable.setModel(modelJavaPaths);
            if (modelJavaPaths.getSize() > 0) {
                contents.comboJavaExecutable.setSelectedIndex(initCfg.javaInstallation);
            }
            contents.optMinMemory.setValue(initCfg.minMemoryMB);
            contents.optMaxMemory.setValue(initCfg.maxMemoryMB);
            contents.optGC.setModel(new GCComboModel());
            contents.optGC.setSelectedItem(initCfg.garbageCollector);
            contents.optCustom.getDocument()
                .putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
            contents.optCustom.setText(initCfg.customOptionsToQuotedString());
            contents.optForwardLogs.setSelected(initCfg.forwardLogs);
            contents.optDebugAgent.setSelected(initCfg.allowDebugger);
            contents.optDebugSuspend.setSelected(initCfg.waitForDebugger);
            contents.optMixinDebug.setSelected(initCfg.mixinDebug);
            contents.optMixinExport.setSelected(initCfg.mixinDebugExport);
            contents.optMixinCount.setSelected(initCfg.mixinDebugCount);
            contents.optFmlDebugAts.setSelected(initCfg.fmlDebugAts);
            contents.optRfbDumpClasses.setSelected(initCfg.rfbDumpClasses);
            contents.optRfbDumpTransformers.setSelected(initCfg.rfbDumpPerTransformer);
            contents.optHideOnFutureLaunches.setSelected(initCfg.hideSettingsOnLaunch);
            // do not show for now
            contents.optHideOnFutureLaunches.setEnabled(false);
            contents.optHideOnFutureLaunches.setVisible(false);

            refreshJavaInstalls(contents);
            saveConfig(contents);

            settingsDialog.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    saveConfig(contents);
                }
            });

            contents.buttonAddJava.addActionListener(al -> {
                final JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                jfc.setDialogTitle("Pick java executable");
                final FileFilter fileFilter = new FileFilter() {

                    @Override
                    public boolean accept(File f) {
                        if (f == null) {
                            return false;
                        }
                        final String name = f.getName();
                        return !f.isFile() || name.equalsIgnoreCase("java")
                            || name.equalsIgnoreCase("javaw")
                            || name.equalsIgnoreCase("java.exe")
                            || name.equalsIgnoreCase("javaw.exe");
                    }

                    @Override
                    public String getDescription() {
                        return "Java binaries";
                    }
                };
                jfc.addChoosableFileFilter(fileFilter);
                jfc.setFileFilter(fileFilter);
                final int result = jfc.showOpenDialog(settingsDialog);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final String path = jfc.getSelectedFile()
                        .getAbsolutePath();
                    final DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) contents.comboJavaExecutable
                        .getModel();
                    model.addElement(path);
                    model.setSelectedItem(path);
                    refreshJavaInstalls(contents);
                }
            });

            contents.buttonPreviewJavaOpts.addActionListener(al -> {
                saveConfig(contents);
                JOptionPane.showMessageDialog(
                    settingsDialog,
                    String.join(System.lineSeparator(), RelauncherConfig.config.toJvmArgs()),
                    "Java",
                    JOptionPane.INFORMATION_MESSAGE);
            });

            contents.buttonRun.addActionListener(al -> {
                runClicked = true;
                saveConfig(contents);
                settingsDialog.dispose();
            });

            settingsDialog.setVisible(true);
        });
    }

    private static void refreshJavaInstalls(SettingsDialog contents) {
        final DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) contents.comboJavaExecutable
            .getModel();
        final String oldSelection = Objects.toString(model.getSelectedItem());
        final List<Path> validInstalls = JvmLocator.detectJavaInstalls(comboToList(model));
        model.removeAllElements();
        for (final Path p : validInstalls) {
            final String pString = p.toString();
            model.addElement(pString);
            if (pString.equals(oldSelection)) {
                model.setSelectedItem(pString);
            }
        }
    }

    private static <T> List<T> comboToList(ComboBoxModel<T> model) {
        final List<T> out = new ArrayList<>(model.getSize());
        for (int i = 0; i < model.getSize(); i++) {
            out.add(model.getElementAt(i));
        }
        return out;
    }

    private static void saveConfig(SettingsDialog contents) {
        final RelauncherConfig.ConfigObject initCfg = RelauncherConfig.config;
        initCfg.javaInstallationsCache = comboToList(contents.comboJavaExecutable.getModel()).toArray(new String[0]);
        initCfg.javaInstallation = contents.comboJavaExecutable.getSelectedIndex();
        initCfg.minMemoryMB = contents.optMinMemory.getValue();
        initCfg.maxMemoryMB = contents.optMaxMemory.getValue();
        initCfg.garbageCollector = (RelauncherConfig.GCOption) contents.optGC.getSelectedItem();
        initCfg.setCustomOptionsFromQuotedString(
            contents.optCustom.getText()
                .replace("\r\n", "\n"));
        initCfg.forwardLogs = contents.optForwardLogs.isSelected();
        initCfg.allowDebugger = contents.optDebugAgent.isSelected();
        initCfg.waitForDebugger = contents.optDebugSuspend.isSelected();
        initCfg.mixinDebug = contents.optMixinDebug.isSelected();
        initCfg.mixinDebugExport = contents.optMixinExport.isSelected();
        initCfg.mixinDebugCount = contents.optMixinCount.isSelected();
        initCfg.fmlDebugAts = contents.optFmlDebugAts.isSelected();
        initCfg.rfbDumpClasses = contents.optRfbDumpClasses.isSelected();
        initCfg.rfbDumpPerTransformer = contents.optRfbDumpTransformers.isSelected();
        initCfg.hideSettingsOnLaunch = contents.optHideOnFutureLaunches.isSelected();
        RelauncherConfig.save();
    }

    public static class GCComboModel extends DefaultComboBoxModel<RelauncherConfig.GCOption> {

        public GCComboModel() {
            super(RelauncherConfig.GCOption.values());
        }
    }
}
