package me.eigenraven.lwjgl3ify.rfb;

import java.awt.GraphicsEnvironment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import javax.swing.JOptionPane;

import net.minecraft.launchwrapper.Launch;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gtnewhorizons.retrofuturabootstrap.api.PluginContext;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbPlugin;

import me.eigenraven.lwjgl3ify.rfb.transformers.ExtensibleEnumTransformer;
import me.eigenraven.lwjgl3ify.rfb.transformers.ForgePatchTransformer;
import me.eigenraven.lwjgl3ify.rfb.transformers.LwjglRedirectTransformer;
import me.eigenraven.lwjgl3ify.rfb.transformers.UnfinalizeObjectHoldersTransformer;

public class Lwjgl3ifyRfbPlugin implements RfbPlugin {

    @Override
    public void onConstruction(@NotNull PluginContext ctx) {
        Launch.blackboard.put("lwjgl3ify:rfb-booted", Boolean.TRUE);
        EarlyConfig.load();
        verifyJavaVersion();
        Launch.classLoader.addClassLoaderExclusion("org.openjdk.nashorn");
    }

    @Override
    public @NotNull RfbClassTransformer @Nullable [] makeTransformers() {
        return new RfbClassTransformer[] { new LwjglRedirectTransformer(), new ExtensibleEnumTransformer(),
            new UnfinalizeObjectHoldersTransformer(), new ForgePatchTransformer() };
    }

    private void verifyJavaVersion() {
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
}
