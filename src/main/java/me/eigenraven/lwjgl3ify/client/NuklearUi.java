package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.opengl.GL21C.*;
import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkColor;
import org.lwjgl.nuklear.NkColorf;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkConvertConfig;
import org.lwjgl.nuklear.NkDrawCommand;
import org.lwjgl.nuklear.NkDrawNullTexture;
import org.lwjgl.nuklear.NkDrawVertexLayoutElement;
import org.lwjgl.nuklear.NkMouse;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.NkUserFontGlyph;
import org.lwjgl.nuklear.NkVec2;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.Platform;
import org.lwjglx.opengl.Display;
import org.lwjglx.opengl.GL11;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;

/**
 * Based on <a href=
 * "https://github.com/LWJGL/lwjgl3/blob/c60d8afaf56b216d8c214ac013e5cdac175df131/modules/samples/src/test/java/org/lwjgl/demo/nuklear/GLFWDemo.java">this
 * LWJGL3 demo</a>
 */
@Lwjgl3Aware
public final class NuklearUi {

    private static final int BUFFER_INITIAL_SIZE = 4 * 1024;

    private static final int MAX_VERTEX_BUFFER = 512 * 1024;
    private static final int MAX_ELEMENT_BUFFER = 128 * 1024;

    private static final NkAllocator ALLOCATOR;

    private static final NkDrawVertexLayoutElement.Buffer VERTEX_LAYOUT;

    static {
        ALLOCATOR = NkAllocator.create()
            .alloc((handle, old, size) -> nmemAllocChecked(size))
            .mfree((handle, ptr) -> nmemFree(ptr));

        VERTEX_LAYOUT = NkDrawVertexLayoutElement.create(4)
            .position(0)
            .attribute(NK_VERTEX_POSITION)
            .format(NK_FORMAT_FLOAT)
            .offset(0)
            .position(1)
            .attribute(NK_VERTEX_TEXCOORD)
            .format(NK_FORMAT_FLOAT)
            .offset(8)
            .position(2)
            .attribute(NK_VERTEX_COLOR)
            .format(NK_FORMAT_R8G8B8A8)
            .offset(16)
            .position(3)
            .attribute(NK_VERTEX_ATTRIBUTE_COUNT)
            .format(NK_FORMAT_COUNT)
            .offset(0)
            .flip();
    }

    private final ByteBuffer ttf;

    public NkContext ctx = NkContext.create();
    private NkUserFont default_font = NkUserFont.create();

    private NkBuffer cmds = NkBuffer.create();
    private NkDrawNullTexture null_texture = NkDrawNullTexture.create();

    private int vbo, ebo;
    private int prog;
    private int vert_shdr;
    private int frag_shdr;
    private int uniform_tex;
    private int uniform_proj;

    public NuklearUi() {
        try {
            byte[] fontData = IOUtils.toByteArray(
                Objects.requireNonNull(NuklearUi.class.getResource("/assets/lwjgl3ify/font/FiraSans-Book.ttf")));
            this.ttf = memAlloc(fontData.length);
            ttf.put(fontData, 0, fontData.length);
            ttf.flip();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setup() {
        final NkContext ctx = setupWindow();

        final int BITMAP_W = 1024;
        final int BITMAP_H = 1024;

        final int FONT_HEIGHT = 18;
        final int fontTexID = glGenTextures();

        final STBTTFontinfo fontInfo = STBTTFontinfo.create();
        final STBTTPackedchar.Buffer cdata = STBTTPackedchar.create(95);

        float scale;
        float descent;

        try (MemoryStack stack = stackPush()) {
            stbtt_InitFont(fontInfo, ttf);
            scale = stbtt_ScaleForPixelHeight(fontInfo, FONT_HEIGHT);

            final IntBuffer d = stack.mallocInt(1);
            stbtt_GetFontVMetrics(fontInfo, null, d, null);
            descent = d.get(0) * scale;

            final ByteBuffer bitmap = memAlloc(BITMAP_W * BITMAP_H);

            final STBTTPackContext pc = STBTTPackContext.malloc(stack);
            stbtt_PackBegin(pc, bitmap, BITMAP_W, BITMAP_H, 0, 1, NULL);
            stbtt_PackSetOversampling(pc, 4, 4);
            stbtt_PackFontRange(pc, ttf, 0, FONT_HEIGHT, 32, cdata);
            stbtt_PackEnd(pc);

            // Convert R8 to RGBA8
            final ByteBuffer texture = memAlloc(BITMAP_W * BITMAP_H * 4);
            for (int i = 0; i < bitmap.capacity(); i++) {
                texture.putInt((bitmap.get(i) << 24) | 0x00FFFFFF);
            }
            texture.flip();

            glBindTexture(GL_TEXTURE_2D, fontTexID);
            glTexImage2D(
                GL_TEXTURE_2D,
                0,
                GL_RGBA8,
                BITMAP_W,
                BITMAP_H,
                0,
                GL_RGBA,
                GL_UNSIGNED_INT_8_8_8_8_REV,
                texture);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

            memFree(texture);
            memFree(bitmap);
        }

        default_font.width((handle, h, text, len) -> {
            float text_width = 0;
            try (final MemoryStack stack = stackPush()) {
                final IntBuffer unicode = stack.mallocInt(1);

                int glyph_len = nnk_utf_decode(text, memAddress(unicode), len);
                int text_len = glyph_len;

                if (glyph_len == 0) {
                    return 0;
                }

                final IntBuffer advance = stack.mallocInt(1);
                while (text_len <= len && glyph_len != 0) {
                    if (unicode.get(0) == NK_UTF_INVALID) {
                        break;
                    }

                    /* query currently drawn glyph information */
                    stbtt_GetCodepointHMetrics(fontInfo, unicode.get(0), advance, null);
                    text_width += advance.get(0) * scale;

                    /* offset next glyph */
                    glyph_len = nnk_utf_decode(text + text_len, memAddress(unicode), len - text_len);
                    text_len += glyph_len;
                }
            }
            return text_width;
        })
            .height(FONT_HEIGHT)
            .query((handle, font_height, glyph, codepoint, next_codepoint) -> {
                try (final MemoryStack stack = stackPush()) {
                    final FloatBuffer x = stack.floats(0.0f);
                    final FloatBuffer y = stack.floats(0.0f);

                    STBTTAlignedQuad q = STBTTAlignedQuad.malloc(stack);
                    IntBuffer advance = stack.mallocInt(1);

                    stbtt_GetPackedQuad(cdata, BITMAP_W, BITMAP_H, codepoint - 32, x, y, q, false);
                    stbtt_GetCodepointHMetrics(fontInfo, codepoint, advance, null);

                    final NkUserFontGlyph ufg = NkUserFontGlyph.create(glyph);

                    ufg.width(q.x1() - q.x0());
                    ufg.height(q.y1() - q.y0());
                    ufg.offset()
                        .set(q.x0(), q.y0() + (FONT_HEIGHT + descent));
                    ufg.xadvance(advance.get(0) * scale);
                    ufg.uv(0)
                        .set(q.s0(), q.t0());
                    ufg.uv(1)
                        .set(q.s1(), q.t1());
                }
            })
            .texture(it -> it.id(fontTexID));

        nk_style_set_font(ctx, default_font);
    }

    int attrib_pos, attrib_uv, attrib_col;

    private void setupContext() {
        final String NK_SHADER_VERSION = Platform.get() == Platform.MACOSX ? "#version 150\n" : "#version 300 es\n";
        final String vertex_shader = NK_SHADER_VERSION + """
            uniform mat4 ProjMtx;
            in vec2 Position;
            in vec2 TexCoord;
            in vec4 Color;
            out vec2 Frag_UV;
            out vec4 Frag_Color;
            void main() {
               Frag_UV = TexCoord;
               Frag_Color = Color;
               gl_Position = ProjMtx * vec4(Position.xy, 0, 1);
            }

            """;
        final String fragment_shader = NK_SHADER_VERSION + """
            precision mediump float;
            uniform sampler2D Texture;
            in vec2 Frag_UV;
            in vec4 Frag_Color;
            out vec4 Out_Color;
            void main(){
               Out_Color = Frag_Color * texture(Texture, Frag_UV.st);
            }

            """;

        nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);
        prog = glCreateProgram();
        vert_shdr = glCreateShader(GL_VERTEX_SHADER);
        frag_shdr = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(vert_shdr, vertex_shader);
        glShaderSource(frag_shdr, fragment_shader);
        glCompileShader(vert_shdr);
        glCompileShader(frag_shdr);
        if (glGetShaderi(vert_shdr, GL_COMPILE_STATUS) != GL_TRUE) {
            throw new IllegalStateException();
        }
        if (glGetShaderi(frag_shdr, GL_COMPILE_STATUS) != GL_TRUE) {
            throw new IllegalStateException();
        }
        glAttachShader(prog, vert_shdr);
        glAttachShader(prog, frag_shdr);
        glLinkProgram(prog);
        if (glGetProgrami(prog, GL_LINK_STATUS) != GL_TRUE) {
            throw new IllegalStateException();
        }

        uniform_tex = glGetUniformLocation(prog, "Texture");
        uniform_proj = glGetUniformLocation(prog, "ProjMtx");
        attrib_pos = glGetAttribLocation(prog, "Position");
        attrib_uv = glGetAttribLocation(prog, "TexCoord");
        attrib_col = glGetAttribLocation(prog, "Color");

        vbo = glGenBuffers();
        ebo = glGenBuffers();

        {
            // null texture setup
            int nullTexID = glGenTextures();

            null_texture.texture()
                .id(nullTexID);
            null_texture.uv()
                .set(0.5f, 0.5f);

            glBindTexture(GL_TEXTURE_2D, nullTexID);
            try (MemoryStack stack = stackPush()) {
                glTexImage2D(
                    GL_TEXTURE_2D,
                    0,
                    GL_RGBA8,
                    1,
                    1,
                    0,
                    GL_RGBA,
                    GL_UNSIGNED_INT_8_8_8_8_REV,
                    stack.ints(0xFFFFFFFF));
            }
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        }

        bindDrawState();
        unbindDrawState();
    }

    private void bindDrawState() {
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);

        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        glEnableVertexAttribArray(attrib_pos);
        glEnableVertexAttribArray(attrib_uv);
        glEnableVertexAttribArray(attrib_col);

        glVertexAttribPointer(attrib_pos, 2, GL_FLOAT, false, 20, 0);
        GL11.glVertexPointer(2, GL_FLOAT, 20, 0);
        glVertexAttribPointer(attrib_uv, 2, GL_FLOAT, false, 20, 8);
        glVertexAttribPointer(attrib_col, 4, GL_UNSIGNED_BYTE, true, 20, 16);
    }

    private void unbindDrawState() {
        glBindTexture(GL_TEXTURE_2D, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
        glDisableVertexAttribArray(attrib_pos);
        glDisableVertexAttribArray(attrib_uv);
        glDisableVertexAttribArray(attrib_col);
        glUseProgram(0);
    }

    private NkContext setupWindow() {
        /*
         * glfwSetScrollCallback(win, (window, xoffset, yoffset) -> {
         * try (MemoryStack stack = stackPush()) {
         * NkVec2 scroll = NkVec2.malloc(stack)
         * .x((float)xoffset)
         * .y((float)yoffset);
         * nk_input_scroll(ctx, scroll);
         * }
         * });
         * glfwSetCharCallback(win, (window, codepoint) -> nk_input_unicode(ctx, codepoint));
         * glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
         * boolean press = action == GLFW_PRESS;
         * switch (key) {
         * case GLFW_KEY_ESCAPE:
         * glfwSetWindowShouldClose(window, true);
         * break;
         * case GLFW_KEY_DELETE:
         * nk_input_key(ctx, NK_KEY_DEL, press);
         * break;
         * case GLFW_KEY_ENTER:
         * nk_input_key(ctx, NK_KEY_ENTER, press);
         * break;
         * case GLFW_KEY_TAB:
         * nk_input_key(ctx, NK_KEY_TAB, press);
         * break;
         * case GLFW_KEY_BACKSPACE:
         * nk_input_key(ctx, NK_KEY_BACKSPACE, press);
         * break;
         * case GLFW_KEY_UP:
         * nk_input_key(ctx, NK_KEY_UP, press);
         * break;
         * case GLFW_KEY_DOWN:
         * nk_input_key(ctx, NK_KEY_DOWN, press);
         * break;
         * case GLFW_KEY_HOME:
         * nk_input_key(ctx, NK_KEY_TEXT_START, press);
         * nk_input_key(ctx, NK_KEY_SCROLL_START, press);
         * break;
         * case GLFW_KEY_END:
         * nk_input_key(ctx, NK_KEY_TEXT_END, press);
         * nk_input_key(ctx, NK_KEY_SCROLL_END, press);
         * break;
         * case GLFW_KEY_PAGE_DOWN:
         * nk_input_key(ctx, NK_KEY_SCROLL_DOWN, press);
         * break;
         * case GLFW_KEY_PAGE_UP:
         * nk_input_key(ctx, NK_KEY_SCROLL_UP, press);
         * break;
         * case GLFW_KEY_LEFT_SHIFT:
         * case GLFW_KEY_RIGHT_SHIFT:
         * nk_input_key(ctx, NK_KEY_SHIFT, press);
         * break;
         * case GLFW_KEY_LEFT_CONTROL:
         * case GLFW_KEY_RIGHT_CONTROL:
         * if (press) {
         * nk_input_key(ctx, NK_KEY_COPY, glfwGetKey(window, GLFW_KEY_C) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_PASTE, glfwGetKey(window, GLFW_KEY_P) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_CUT, glfwGetKey(window, GLFW_KEY_X) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_UNDO, glfwGetKey(window, GLFW_KEY_Z) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_REDO, glfwGetKey(window, GLFW_KEY_R) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_WORD_LEFT, glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_WORD_RIGHT, glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_LINE_START, glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_TEXT_LINE_END, glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS);
         * } else {
         * nk_input_key(ctx, NK_KEY_LEFT, glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_RIGHT, glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS);
         * nk_input_key(ctx, NK_KEY_COPY, false);
         * nk_input_key(ctx, NK_KEY_PASTE, false);
         * nk_input_key(ctx, NK_KEY_CUT, false);
         * nk_input_key(ctx, NK_KEY_SHIFT, false);
         * }
         * break;
         * }
         * });
         * glfwSetCursorPosCallback(win, (window, xpos, ypos) -> nk_input_motion(ctx, (int)xpos, (int)ypos));
         * glfwSetMouseButtonCallback(win, (window, button, action, mods) -> {
         * try (MemoryStack stack = stackPush()) {
         * DoubleBuffer cx = stack.mallocDouble(1);
         * DoubleBuffer cy = stack.mallocDouble(1);
         * glfwGetCursorPos(window, cx, cy);
         * int x = (int)cx.get(0);
         * int y = (int)cy.get(0);
         * int nkButton;
         * switch (button) {
         * case GLFW_MOUSE_BUTTON_RIGHT:
         * nkButton = NK_BUTTON_RIGHT;
         * break;
         * case GLFW_MOUSE_BUTTON_MIDDLE:
         * nkButton = NK_BUTTON_MIDDLE;
         * break;
         * default:
         * nkButton = NK_BUTTON_LEFT;
         * }
         * nk_input_button(ctx, nkButton, x, y, action == GLFW_PRESS);
         * }
         * });
         */

        nk_init(ctx, ALLOCATOR, null);
        ctx.clip()
            .copy((handle, text, len) -> {
                if (len == 0) {
                    return;
                }

                try (MemoryStack stack = stackPush()) {
                    ByteBuffer str = stack.malloc(len + 1);
                    memCopy(text, memAddress(str), len);
                    str.put(len, (byte) 0);

                    GLFW.glfwSetClipboardString(Display.getWindow(), str);
                }
            })
            .paste((handle, edit) -> {
                long text = GLFW.nglfwGetClipboardString(Display.getWindow());
                if (text != NULL) {
                    nnk_textedit_paste(edit, text, nnk_strlen(text));
                }
            });

        setupContext();
        return ctx;
    }

    public void newFrame() {
        nk_input_begin(ctx);
        // glfwPollEvents();

        NkMouse mouse = ctx.input()
            .mouse();
        if (mouse.grab()) {
            // glfwSetInputMode(win, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
        } else if (mouse.grabbed()) {
            float prevX = mouse.prev()
                .x();
            float prevY = mouse.prev()
                .y();
            // glfwSetCursorPos(win, prevX, prevY);
            mouse.pos()
                .x(prevX);
            mouse.pos()
                .y(prevY);
        } else if (mouse.ungrab()) {
            // glfwSetInputMode(win, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
        }

        nk_input_end(ctx);
    }

    public void render(int AA) {
        final int width = Display.getWidth();
        final int height = Display.getHeight();

        final int display_width = Display.getFramebufferWidth();
        final int display_height = Display.getFramebufferHeight();

        try (MemoryStack stack = stackPush()) {
            // setup global state
            glEnable(GL_BLEND);
            glBlendEquation(GL_FUNC_ADD);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            glDisable(GL_CULL_FACE);
            glDisable(GL_DEPTH_TEST);
            glEnable(GL_SCISSOR_TEST);
            glActiveTexture(GL_TEXTURE0);

            // setup program
            glUseProgram(prog);
            glUniform1i(uniform_tex, 0);
            glUniformMatrix4fv(
                uniform_proj,
                false,
                stack.floats(
                    2.0f / width,
                    0.0f,
                    0.0f,
                    0.0f,
                    0.0f,
                    -2.0f / height,
                    0.0f,
                    0.0f,
                    0.0f,
                    0.0f,
                    -1.0f,
                    0.0f,
                    -1.0f,
                    1.0f,
                    0.0f,
                    1.0f));
        }

        {
            // convert from command queue into draw list and draw to screen

            // allocate vertex and element buffer
            bindDrawState();

            glBufferData(GL_ARRAY_BUFFER, MAX_VERTEX_BUFFER, GL_STREAM_DRAW);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, MAX_ELEMENT_BUFFER, GL_STREAM_DRAW);

            // load draw vertices & elements directly into vertex + element buffer
            final ByteBuffer vertices = Objects
                .requireNonNull(glMapBuffer(GL_ARRAY_BUFFER, GL_WRITE_ONLY, MAX_VERTEX_BUFFER, null));
            final ByteBuffer elements = Objects
                .requireNonNull(glMapBuffer(GL_ELEMENT_ARRAY_BUFFER, GL_WRITE_ONLY, MAX_ELEMENT_BUFFER, null));
            try (final MemoryStack stack = stackPush()) {
                // fill convert configuration
                final NkConvertConfig config = NkConvertConfig.calloc(stack)
                    .vertex_layout(VERTEX_LAYOUT)
                    .vertex_size(20)
                    .vertex_alignment(4)
                    .tex_null(null_texture)
                    .circle_segment_count(22)
                    .curve_segment_count(22)
                    .arc_segment_count(22)
                    .global_alpha(1.0f)
                    .shape_AA(AA)
                    .line_AA(AA);

                // setup buffers to load vertices and elements
                final NkBuffer vbuf = NkBuffer.malloc(stack);
                final NkBuffer ebuf = NkBuffer.malloc(stack);

                nk_buffer_init_fixed(vbuf, vertices/* , MAX_VERTEX_BUFFER */);
                nk_buffer_init_fixed(ebuf, elements/* , MAX_ELEMENT_BUFFER */);
                nk_convert(ctx, cmds, vbuf, ebuf, config);
            }
            glUnmapBuffer(GL_ELEMENT_ARRAY_BUFFER);
            glUnmapBuffer(GL_ARRAY_BUFFER);

            // iterate over and execute each draw command
            final float fb_scale_x = (float) display_width / (float) width;
            final float fb_scale_y = (float) display_height / (float) height;

            long offset = NULL;
            for (NkDrawCommand cmd = nk__draw_begin(ctx, cmds); cmd != null; cmd = nk__draw_next(cmd, cmds, ctx)) {
                if (cmd.elem_count() == 0) {
                    continue;
                }
                glBindTexture(
                    GL_TEXTURE_2D,
                    cmd.texture()
                        .id());
                glScissor(
                    (int) (cmd.clip_rect()
                        .x() * fb_scale_x),
                    (int) ((height - (int) (cmd.clip_rect()
                        .y()
                        + cmd.clip_rect()
                            .h()))
                        * fb_scale_y),
                    (int) (cmd.clip_rect()
                        .w() * fb_scale_x),
                    (int) (cmd.clip_rect()
                        .h() * fb_scale_y));
                glDrawElements(GL_TRIANGLES, cmd.elem_count(), GL_UNSIGNED_SHORT, offset);
                offset += cmd.elem_count() * 2L;
            }
            nk_clear(ctx);
            nk_buffer_clear(cmds);
        }

        // default OpenGL state
        unbindDrawState();
        glDisable(GL_BLEND);
        glDisable(GL_SCISSOR_TEST);
    }

    private void destroy() {
        glDetachShader(prog, vert_shdr);
        glDetachShader(prog, frag_shdr);
        glDeleteShader(vert_shdr);
        glDeleteShader(frag_shdr);
        glDeleteProgram(prog);
        glDeleteTextures(
            default_font.texture()
                .id());
        glDeleteTextures(
            null_texture.texture()
                .id());
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);
        nk_buffer_free(cmds);
    }

    public void shutdown() {
        Objects.requireNonNull(
            ctx.clip()
                .copy())
            .free();
        Objects.requireNonNull(
            ctx.clip()
                .paste())
            .free();
        nk_free(ctx);
        destroy();
        Objects.requireNonNull(default_font.query())
            .free();
        Objects.requireNonNull(default_font.width())
            .free();
        Objects.requireNonNull(ALLOCATOR.alloc())
            .free();
        Objects.requireNonNull(ALLOCATOR.mfree())
            .free();
    }

    // demo
    private static final int EASY = 0;
    private static final int HARD = 1;

    NkColorf background = NkColorf.create()
        .r(0.10f)
        .g(0.18f)
        .b(0.24f)
        .a(1.0f);

    private int op = EASY;

    private IntBuffer compression = BufferUtils.createIntBuffer(1)
        .put(0, 20);

    public void demo_layout(int x, int y) {
        try (MemoryStack stack = stackPush()) {
            NkRect rect = NkRect.malloc(stack);

            if (nk_begin(
                ctx,
                "Demo",
                nk_rect(x, y, 230, 250, rect),
                NK_WINDOW_BORDER | NK_WINDOW_MOVABLE | NK_WINDOW_SCALABLE | NK_WINDOW_MINIMIZABLE | NK_WINDOW_TITLE)) {
                nk_layout_row_static(ctx, 30, 80, 1);
                if (nk_button_label(ctx, "button")) {
                    System.out.println("button pressed");
                }

                nk_layout_row_dynamic(ctx, 30, 2);
                if (nk_option_label(ctx, "easy", op == EASY)) {
                    op = EASY;
                }
                if (nk_option_label(ctx, "hard", op == HARD)) {
                    op = HARD;
                }

                nk_layout_row_dynamic(ctx, 25, 1);
                nk_property_int(ctx, "Compression:", 0, compression, 100, 10, 1);

                nk_layout_row_dynamic(ctx, 20, 1);
                nk_label(ctx, "background:", NK_TEXT_LEFT);
                nk_layout_row_dynamic(ctx, 25, 1);
                if (nk_combo_begin_color(
                    ctx,
                    nk_rgb_cf(background, NkColor.malloc(stack)),
                    NkVec2.malloc(stack)
                        .set(nk_widget_width(ctx), 400))) {
                    nk_layout_row_dynamic(ctx, 120, 1);
                    nk_color_picker(ctx, background, NK_RGBA);
                    nk_layout_row_dynamic(ctx, 25, 1);
                    background.r(nk_propertyf(ctx, "#R:", 0, background.r(), 1.0f, 0.01f, 0.005f))
                        .g(nk_propertyf(ctx, "#G:", 0, background.g(), 1.0f, 0.01f, 0.005f))
                        .b(nk_propertyf(ctx, "#B:", 0, background.b(), 1.0f, 0.01f, 0.005f))
                        .a(nk_propertyf(ctx, "#A:", 0, background.a(), 1.0f, 0.01f, 0.005f));
                    nk_combo_end(ctx);
                }
            }
            nk_end(ctx);
        }
    }
}
