package me.eigenraven.lwjgl3ify.rfb.entry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The replacement for ServerLaunchWrapper as the main class when starting the server.
 */
public class ServerMain {

    public static void main(String[] args) {
        new ServerMain().run(args);
    }

    private ServerMain() {}

    private void run(String[] args) {
        Class<?> launchwrapper = null;
        try {
            launchwrapper = Class
                .forName("com.gtnewhorizons.retrofuturabootstrap.Main", true, getClass().getClassLoader());
            Class.forName("org.objectweb.asm.Type", true, getClass().getClassLoader());
        } catch (Exception e) {
            System.err.print(
                "We appear to be missing one or more essential library files.\n"
                    + "You will need to add them to your server before FML and Forge will run successfully.");
            e.printStackTrace(System.err);
            System.exit(1);
        }

        try {
            Method main = launchwrapper.getMethod("main", String[].class);
            String[] allArgs = new String[args.length + 2];
            allArgs[0] = "--tweakClass";
            allArgs[1] = "cpw.mods.fml.common.launcher.FMLServerTweaker";
            System.arraycopy(args, 0, allArgs, 2, args.length);
            main.invoke(null, (Object) allArgs);
        } catch (Exception e) {
            Throwable cause = e;
            if (e instanceof InvocationTargetException) {
                cause = e.getCause();
            }
            System.err.print("A problem occurred running the Server launcher.");
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
