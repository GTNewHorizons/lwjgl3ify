package me.eigenraven.lwjgl3ify.mixins.early.fml;

import java.util.zip.ZipEntry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = { cpw.mods.fml.common.discovery.JarDiscoverer.class }, remap = false)
public class JarDiscoverer {

    @Redirect(
        method = {
            "Lcpw/mods/fml/common/discovery/JarDiscoverer;discover(Lcpw/mods/fml/common/discovery/ModCandidate;Lcpw/mods/fml/common/discovery/ASMDataTable;)Ljava/util/List;" },
        at = @At(ordinal = 1, value = "INVOKE", target = "Ljava/util/zip/ZipEntry;getName()Ljava/lang/String;"),
        remap = false,
        require = 1)
    public String getZipEntryName(ZipEntry ze) {
        String name = ze.getName();
        if (name == null) {
            return null;
        }
        if (name.contains("module-info.class") || name.startsWith("META-INF/versions/")
            || name.contains("org/openjdk/nashorn")
            || name.contains("jakarta/servlet/")) {
            // Triggers the continue in the loop
            return "__MACOSX_ignoreme";
        }
        return name;
    }
}
