package cpw.mods.fml.relauncher;

import java.awt.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.security.Permission;

import javax.swing.*;

/**
 * A custom security manager stopping certain events from happening unexpectedly.
 *
 * @author cpw
 *
 * @author eigenraven Patch ArrayIndexOutOfBoundsException - the length condition were 1-off
 *
 */
public class FMLSecurityManager extends SecurityManager {

    public FMLSecurityManager() {
        // This is the first class that gets loaded, do the 17 check first.
        if (!Boolean.getBoolean("lwjgl3ify.skipjavacheck")) {
            final String specVer = System.getProperty("java.specification.version");
            if (specVer.equals("17")) {
                try {
                    final Class<?> cRuntime = Class.forName("java.lang.Runtime");
                    final Class<?> cRuntimeVersion = Class.forName("java.lang.Runtime$Version");
                    final MethodHandles.Lookup lookup = MethodHandles.publicLookup();
                    final MethodHandle mRuntimeVersion = lookup
                            .findStatic(cRuntime, "version", MethodType.methodType(cRuntimeVersion));
                    final MethodHandle mVersionParse = lookup
                            .findStatic(cRuntimeVersion, "parse", MethodType.methodType(cRuntimeVersion, String.class));
                    final MethodHandle mVersionCompareTo = lookup.findVirtual(
                            cRuntimeVersion,
                            "compareToIgnoreOptional",
                            MethodType.methodType(int.class, cRuntimeVersion));
                    final Object runtimeVersion = mRuntimeVersion.invoke();
                    final Object ver17_0_6 = mVersionParse.invoke("17.0.6");
                    final int cmpResult = (int) mVersionCompareTo.invoke(runtimeVersion, ver17_0_6);
                    if (cmpResult < 0) {
                        if (GraphicsEnvironment.isHeadless()) {
                            System.err.println("=================================================================");
                            System.err.println("Upgrade your Java 17 install to Java 17.0.6 for lwjgl3ify to work");
                            System.err.println("Your Java version is: " + runtimeVersion);
                            System.err.println("=================================================================");
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Upgrade your Java 17 install to Java 17.0.6 for lwjgl3ify to work\nYour java version is: "
                                            + runtimeVersion,
                                    "Java version requirement not met",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        System.exit(1);
                    }
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void checkPermission(Permission perm) {
        String permName = perm.getName() != null ? perm.getName() : "missing";
        if (permName.startsWith("exitVM")) {
            Class<?>[] classContexts = getClassContext();
            String callingClass = classContexts.length > 4 ? classContexts[4].getName() : "none"; // PATCHED
            String callingParent = classContexts.length > 5 ? classContexts[5].getName() : "none"; // PATCHED
            // FML is allowed to call system exit and the Minecraft applet (from the quit button)
            if (!(callingClass.startsWith("cpw.mods.fml.")
                    || ("net.minecraft.client.Minecraft".equals(callingClass)
                            && "net.minecraft.client.Minecraft".equals(callingParent))
                    || ("net.minecraft.server.dedicated.DedicatedServer".equals(callingClass)
                            && "net.minecraft.server.MinecraftServer".equals(callingParent)))) {
                throw new ExitTrappedException();
            }
        } else if ("setSecurityManager".equals(permName)) {
            throw new SecurityException("Cannot replace the FML security manager");
        }
        return;
    }

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }
}
