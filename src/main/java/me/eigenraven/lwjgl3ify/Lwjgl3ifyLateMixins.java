package me.eigenraven.lwjgl3ify;

import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import me.eigenraven.lwjgl3ify.mixins.Mixins;

@LateMixin
public class Lwjgl3ifyLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.lwjgl3ify.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return Mixins.getLateMixins(loadedMods);
    }
}
