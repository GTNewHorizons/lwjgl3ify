package me.eigenraven.lwjgl3ify.relauncher;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.apache.commons.lang3.StringUtils;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.spec.ColorToneRule;
import com.github.weisj.darklaf.theme.spec.ContrastRule;
import com.github.weisj.darklaf.theme.spec.PreferredThemeStyle;
import com.google.common.base.Throwables;

/** Implements the UI components of the relauncher */
/*
 * Dev note on recompiling forms:
 * 1. Import into IntelliJ as a gradle project
 * 2. In gradle settings, change Build with: from Gradle to IntelliJ
 * 3. Open the .form file in the form editor and use the main menu Build->Recompile 'currentfile.form' function
 */
public class RelauncherGui {

    private final Relauncher relauncher;
    private boolean swingInitialized = false;

    public RelauncherGui(Relauncher relauncher) {
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
        final ClassLoader mcLoader = RelauncherGui.class.getClassLoader();
        Thread.currentThread()
            .setContextClassLoader(mcLoader);
        try {
            System.setProperty("awt.useSystemAAFontSettings", "true");
            LafManager.installTheme(new PreferredThemeStyle(ContrastRule.STANDARD, ColorToneRule.DARK));
        } catch (Exception e) {
            Relauncher.logger.warn("Could not initialize DarkLaf GUI theme", e);
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
            progressDialog.add(dialogContent.panel);

            dialogContent.progressBar.setMinimum(0);
            dialogContent.progressBar.setMaximum(totalTasks);
            dialogContent.progressBar.setValue(0);
            dialogContent.cancelButton.addActionListener(al -> { relauncher.runtimeExit(1); });

            final Thread dlThread = new Thread(dler::runDownloads, "Download thread");
            dlThread.setContextClassLoader(RelauncherGui.class.getClassLoader());
            dlThread.setDaemon(true);

            final AtomicBoolean normallyTerminated = new AtomicBoolean(false);

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

}
