package org.lwjglx.opengl;

public class ARBTextureView {
    public static void glTextureView(
            int texture,
            int target,
            int origtexture,
            int internalformat,
            int minlevel,
            int numlevels,
            int minlayer,
            int numlayers) {
        org.lwjgl.opengl.ARBTextureView.glTextureView(
                texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
    }
}
