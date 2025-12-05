package me.eigenraven.lwjgl3ify;

import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.gtnewhorizon.gtnhmixins.builders.IMixins;

import me.eigenraven.lwjgl3ify.mixins.Mixins;

@LateMixin
public class Lwjgl3ifyLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.lwjgl3ify.late.json";
    }

    @Nonnull
    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return IMixins.getLateMixins(Mixins.class, loadedMods);
    }
}
