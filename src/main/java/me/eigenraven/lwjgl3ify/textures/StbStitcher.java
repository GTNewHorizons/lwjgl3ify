package me.eigenraven.lwjgl3ify.textures;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;

import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.util.MathHelper;

import org.lwjgl.stb.STBRPContext;
import org.lwjgl.stb.STBRPNode;
import org.lwjgl.stb.STBRPRect;
import org.lwjgl.stb.STBRectPack;

import cpw.mods.fml.common.ProgressManager;

@Lwjgl3Aware
@SuppressWarnings("deprecation")
public class StbStitcher {

    // Returns size
    public static int packRects(Stitcher.Holder[] holders) {
        ProgressManager.ProgressBar bar = ProgressManager.push("Stitch setup", (holders.length + 99) / 100);
        int holderSize = holders.length;

        // Allocate memory for the rectangles and the context
        try (STBRPRect.Buffer rectBuf = STBRPRect.malloc(holderSize); STBRPContext ctx = STBRPContext.malloc();) {

            // Initialize the rectangles that we'll be using in the calculation
            // While that's happening, sum up the area needed to fit all of the images
            int sqSize = 0;
            for (int j = 0; j < holderSize; ++j) {
                Stitcher.Holder holder = holders[j];
                if ((j % 100) == 0 && bar.getStep() < bar.getSteps()) {
                    bar.step(holder.getAtlasSprite().getIconName());
                }

                int width = holder.getWidth();
                int height = holder.getHeight();

                // The ID here is just the array index, for easy lookup later
                rectBuf.get(j).set(j, width, height, 0, 0, false);

                sqSize += (width * height);
            }

            int size = MathHelper.roundUpToPowerOfTwo((int) Math.sqrt(sqSize));

            // TODO: if sqSize < (size * size) / 2, then we can use size / 2 for the height to save VRAM

            // Internal node structure needed for STB
            try (STBRPNode.Buffer nodes = STBRPNode.malloc(size + 1)) {
                // Initialize the rect packer
                STBRectPack.stbrp_init_target(ctx, size, size, nodes);

                // Perform rectangle packing
                STBRectPack.stbrp_pack_rects(ctx, rectBuf);

                for (STBRPRect rect : rectBuf) {
                    Stitcher.Holder holder = holders[rect.id()];

                    // Ensure that everything is properly packed!
                    if (!rect.was_packed()) {
                        throw new StitcherException(
                                holder,
                                "Could not fit " + holder.getAtlasSprite()
                                        .getIconName() + " into " + size + "x" + size + " atlas!");
                    }

                    // Initialize the sprite now with the position and size that we've calculated so far

                    // texture should not be rotated, so use false
                    holder.getAtlasSprite().initSprite(size, size, rect.x(), rect.y(), false);
                }

                // Safeguard in case our calculation was off
                while (bar.getStep() < bar.getSteps()) {
                    Lwjgl3ify.LOG.warn("Progressbar calculation was off");
                    bar.step("noop");
                }

                ProgressManager.pop(bar);

                return size;
            }
        }
    }
}
