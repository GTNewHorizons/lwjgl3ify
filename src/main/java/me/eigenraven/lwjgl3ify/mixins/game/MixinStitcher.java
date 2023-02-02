package me.eigenraven.lwjgl3ify.mixins.game;

import java.util.*;
import me.eigenraven.lwjgl3ify.textures.StbStitcher;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Stitcher.class)
@SuppressWarnings("unchecked")
public abstract class MixinStitcher {
    @Shadow
    @Final
    private Set setStitchHolders = new HashSet(256);

    @Shadow
    private int currentWidth;

    @Shadow
    private int currentHeight;

    /**
     * @author SuperCoder79
     * @reason Use improved STB stitcher instead of the vanilla implementation, for performance
     */
    @Overwrite
    public void doStitch() {
        Stitcher.Holder[] aholder =
                (Stitcher.Holder[]) this.setStitchHolders.toArray(new Stitcher.Holder[this.setStitchHolders.size()]);
        Arrays.sort(aholder);

        int size = StbStitcher.packRects(aholder);
        this.currentWidth = size;
        this.currentHeight = size;
    }

    /**
     * @author SuperCoder79
     * @reason We setup the image ourselves in the StbStitcher, so we only need to return the the atlas sprites now
     * @return A list of all the atlas sprites
     */
    @Overwrite
    public List getStichSlots() {
        ArrayList<TextureAtlasSprite> arraylist = new ArrayList<>();

        for (Stitcher.Holder holder : (Set<Stitcher.Holder>) this.setStitchHolders) {
            arraylist.add(holder.getAtlasSprite());
        }

        return arraylist;
    }
}
