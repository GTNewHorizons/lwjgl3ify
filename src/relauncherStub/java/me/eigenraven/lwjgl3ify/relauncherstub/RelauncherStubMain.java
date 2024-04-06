package me.eigenraven.lwjgl3ify.relauncherstub;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Run with arguments of [parentPid, show console [true/false], java binary, java arguments].
 * Needs modern Java to access the ProcessHandle API.
 */
public class RelauncherStubMain {

    public RelauncherStubMain() {}

    public void run(String[] args) throws Throwable {
        if (args.length < 4) {
            System.err.println("Missing arguments");
            return;
        }
        final long parentPid = Long.parseLong(args[0]);
        final boolean showConsole = Boolean.parseBoolean(args[1]);
        final String javaBinary = args[2];
        final String javaArgFile = args[3];
        final String[] javaCmdline = new String[] { javaBinary, "@" + javaArgFile };
        final ProcessHandle myProcess = ProcessHandle.current();
        final ProcessHandle parentProcess = ProcessHandle.of(parentPid)
            .orElse(
                myProcess.parent()
                    .orElse(null));

        System.out.println("quit"); // notify the parent that we're ok to wait on them
        if (parentProcess != null) {
            // Wait for parent to fully exit
            parentProcess.onExit()
                .get();
        } else {
            // Wait a little bit, hopefully the parent exits in this time (not finding the parent shouldn't happen)
            Thread.sleep(1000);
        }

        final ProcessBuilder childBuilder = new ProcessBuilder(javaCmdline);

        if (showConsole) {
            childBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            childBuilder.redirectError(ProcessBuilder.Redirect.PIPE);
            final Process child = childBuilder.start();
            new GraphicalConsole(child.getInputStream(), child.getErrorStream(), child);
        } else {
            childBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
            childBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);
            childBuilder.start();
        }

    }

    public static void main(String[] args) throws Throwable {
        try {
            new RelauncherStubMain().run(args);
        } catch (Throwable e) {
            final StringWriter traceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(traceWriter));
            SwingUtilities.invokeAndWait(() -> {
                JOptionPane.showMessageDialog(
                    null,
                    e.toString() + "\n" + traceWriter.toString(),
                    "Relauncher crash",
                    JOptionPane.ERROR_MESSAGE);
            });
        }
    }
}
