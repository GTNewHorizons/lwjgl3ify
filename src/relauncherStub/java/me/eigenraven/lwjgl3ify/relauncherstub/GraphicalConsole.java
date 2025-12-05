package me.eigenraven.lwjgl3ify.relauncherstub;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;

public class GraphicalConsole {

    // Give up after 32MB of logs
    static final long MAX_LOG_SIZE = 32 * 1024 * 1024;
    final ConcurrentLinkedQueue<String> consoleBuffer = new ConcurrentLinkedQueue<>();
    final AtomicLong logSize = new AtomicLong(0);
    final AtomicBoolean logSizeExceededMax = new AtomicBoolean(false);
    final InputStream stdout, stderr;
    Thread stdoutAdapter;
    Thread stderrAdapter;
    final Process process;

    class StreamToQueueAdapter implements Runnable {

        final BufferedReader reader;
        final JTextArea guiLog;
        final static String LINE_SEPARATOR = System.lineSeparator();

        StreamToQueueAdapter(InputStream stream, JTextArea guiLog) {
            reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            this.guiLog = guiLog;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    final String line = reader.readLine();
                    if (line == null) {
                        // EOF
                        break;
                    }
                    invokeOnSwingThread(false, () -> {
                        while (!consoleBuffer.isEmpty()) {
                            final String bufferedLine = consoleBuffer.remove();
                            try {
                                guiLog.getDocument()
                                    .insertString(
                                        guiLog.getDocument()
                                            .getLength(),
                                        bufferedLine + LINE_SEPARATOR,
                                        null);
                            } catch (BadLocationException e) {
                                // ignored
                            }
                        }
                    });
                    final long currLogSize = logSize.addAndGet(line.length() + 1);
                    if (currLogSize > MAX_LOG_SIZE) {
                        final boolean prevExceeded = logSizeExceededMax.getAndSet(true);
                        if (!prevExceeded) {
                            consoleBuffer.add("Max console size exceeded, > " + MAX_LOG_SIZE + " bytes!");
                        }
                        return;
                    }
                    consoleBuffer.add(line);
                } catch (IOException e) {
                    break;
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                // ignored
            }
        }
    }

    public GraphicalConsole(final InputStream stdout, final InputStream stderr, final Process process) {
        this.stdout = stdout;
        this.stderr = stderr;
        this.process = process;
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
            consoleBuffer.add("Could not initialize DarkLaf GUI theme");
        }

        invokeOnSwingThread(true, () -> {
            final JFrame consoleWindow = new JFrame("Lwjgl3ify relaunch console");
            consoleWindow.setMinimumSize(new Dimension(640, 500));
            consoleWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            final JTextArea logArea = new JTextArea();
            logArea.setEditable(false);
            logArea.setFont(
                Font.decode(Font.MONOSPACED)
                    .deriveFont(14.0f));
            try {
                logArea.getDocument()
                    .insertString(
                        logArea.getDocument()
                            .getLength(),
                        "Relaunching the process with new Java..." + System.lineSeparator(),
                        null);
            } catch (BadLocationException e) {
                throw new RuntimeException(e);
            }
            final JScrollPane logScroll = new JScrollPane(logArea);
            consoleWindow.getContentPane()
                .add(logScroll, BorderLayout.CENTER);

            this.stdoutAdapter = new Thread(new StreamToQueueAdapter(stdout, logArea), "stdout adapter");
            this.stdoutAdapter.setDaemon(true);
            this.stdoutAdapter.start();
            this.stderrAdapter = new Thread(new StreamToQueueAdapter(stderr, logArea), "stderr adapter");
            this.stderrAdapter.setDaemon(true);
            this.stderrAdapter.start();

            final JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            final JButton closeMeButton = new JButton("Close console");
            closeMeButton.addActionListener(al -> consoleWindow.dispose());
            final JButton killButton = new JButton("Kill process");
            killButton.addActionListener(al -> process.destroyForcibly());

            buttonPanel.add(closeMeButton);
            buttonPanel.add(killButton);

            consoleWindow.getContentPane()
                .add(buttonPanel, BorderLayout.SOUTH);

            final Thread processDeathAwaiter = new Thread(() -> {
                try {
                    final Process terminated = process.onExit()
                        .get();
                    final int exitCode = terminated.exitValue();
                    invokeOnSwingThread(false, () -> {
                        killButton.setEnabled(false);
                        try {
                            logArea.getDocument()
                                .insertString(
                                    logArea.getDocument()
                                        .getLength(),
                                    "Process exited with code " + exitCode,
                                    null);
                        } catch (BadLocationException e) {
                            // ignored
                        }
                    });

                } catch (InterruptedException | ExecutionException e) {
                    // ignored
                }
            }, "death awaiter");
            processDeathAwaiter.start();

            consoleWindow.setVisible(true);
        });
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
            if (e.getCause() instanceof RuntimeException re) {
                throw re;
            } else {
                throw new RuntimeException(e);
            }
        }
    }
}
