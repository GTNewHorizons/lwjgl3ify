package me.eigenraven.lwjgl3ify.relauncherstub;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.io.FileInputStream;
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
        File file = new File(javaArgFile);
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int r = 0;
        while ((r = fis.read(b)) != -1) {
            sb.append(new String(Arrays.copyOf(b, r)));
        }
        String[] lines = sb.toString().split("\\r?\\n");
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(javaBinary);
        for (String line : lines) {
            String line2 = line.substring(1);
            line2 = line2.substring(0, line2.length() - 1);
            //if (line.contains("-Dfile.encoding=UTF-8")) continue;
            if (line.contains("--add-opens")) continue;
            if (line.contains("java.base/")) continue;
            if (line.contains("java.desktop/")) continue;
            if (line.contains("java.sql.rowset/")) continue;
            if (line.contains("jdk.dynalink/")) continue;
            if (line.contains("jdk.naming.dns/")) continue;
            if (line.contains("-Djava.security.manager=allow")) continue;
            //sb2.append(line2 + " ");
            System.out.println(line2);
            arr.add(line2);
        }
        //final String[] javaCmdline = new String[] { javaBinary, "@" + javaArgFile };
        final String[] javaCmdline = arr.toArray(new String[0]);
        /*final ProcessHandle myProcess = ProcessHandle.current();
        final ProcessHandle parentProcess = ProcessHandle.of(parentPid)
            .orElse(
                myProcess.parent()
                    .orElse(null));

        System.out.println("quit"); // notify the parent that we're ok to wait on them
        if (parentProcess != null) {
            // Wait for parent to fully exit
            parentProcess.onExit()
                .get();
        } else {*/
            // Wait a little bit, hopefully the parent exits in this time (not finding the parent shouldn't happen)
            Thread.sleep(1000);
        //}

        final ProcessBuilder childBuilder = new ProcessBuilder(javaCmdline);

        if (showConsole) {
            childBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            childBuilder.redirectError(ProcessBuilder.Redirect.PIPE);
            final Process child = childBuilder.start();
            new GraphicalConsole(child.getInputStream(), child.getErrorStream(), child);
        } else {
            //childBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
            //childBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);
            File NULL_FILE = new File(
                   (System.getProperty("os.name")
                              .startsWith("Windows") ? "NUL" : "/dev/null")
            );
            childBuilder.redirectOutput(NULL_FILE);
            childBuilder.redirectError(NULL_FILE);
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
