package me.eigenraven.lwjgl3ify;

import java.util.Arrays;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

public class LwjglRedirectTransformer extends Remapper implements IClassTransformer {
    int remaps = 0, calls = 0;

    public static final String[] MAPPED_CLASSES = new String[] {
        "org/lwjgl/BufferChecks",
        "org/lwjgl/BufferUtils",
        "org/lwjgl/LWJGLException",
        "org/lwjgl/LWJGLUtil",
        "org/lwjgl/MemoryUtil",
        "org/lwjgl/PointerBuffer",
        "org/lwjgl/PointerWrapper",
        "org/lwjgl/PointerWrapperAbstract",
        "org/lwjgl/Sys",
        "org/lwjgl/input/Cursor",
        "org/lwjgl/input/EventQueue",
        "org/lwjgl/input/KeyCodes",
        "org/lwjgl/input/Keyboard",
        "org/lwjgl/input/Mouse",
        "org/lwjgl/openal/AL",
        "org/lwjgl/openal/AL10",
        "org/lwjgl/openal/ALC10",
        "org/lwjgl/openal/ALCcontext",
        "org/lwjgl/openal/ALCdevice",
        "org/lwjgl/openal/EFX10",
        "org/lwjgl/openal/EFXUtil",
        "org/lwjgl/openal/OpenALException",
        "org/lwjgl/openal/Util",
        "org/lwjgl/opengl/AWTGLCanvas",
        "org/lwjgl/opengl/Context",
        "org/lwjgl/opengl/ContextAttribs",
        "org/lwjgl/opengl/ContextCapabilities",
        "org/lwjgl/opengl/ContextGL",
        "org/lwjgl/opengl/Display",
        "org/lwjgl/opengl/DisplayImplementation",
        "org/lwjgl/opengl/DisplayMode",
        "org/lwjgl/opengl/Drawable",
        "org/lwjgl/opengl/DrawableGL",
        "org/lwjgl/opengl/DrawableLWJGL",
        "org/lwjgl/opengl/GL15x",
        "org/lwjgl/opengl/GL20x",
        "org/lwjgl/opengl/GLContext",
        "org/lwjgl/opengl/GLSync",
        "org/lwjgl/opengl/GlobalLock",
        "org/lwjgl/opengl/InputImplementation",
        "org/lwjgl/opengl/OpenGLException",
        "org/lwjgl/opengl/Pbuffer",
        "org/lwjgl/opengl/PeerInfo",
        "org/lwjgl/opengl/PixelFormat",
        "org/lwjgl/opengl/PixelFormatLWJGL",
        "org/lwjgl/opengl/RenderTexture",
        "org/lwjgl/opengl/Sync",
        "org/lwjgl/opengl/Util",
        "org/lwjgl/test/opengl/Gears",
        "org/lwjgl/test/spaceinvaders/AlienEntity",
        "org/lwjgl/test/spaceinvaders/Entity",
        "org/lwjgl/test/spaceinvaders/Game",
        "org/lwjgl/test/spaceinvaders/ShipEntity",
        "org/lwjgl/test/spaceinvaders/ShotEntity",
        "org/lwjgl/test/spaceinvaders/SoundManager",
        "org/lwjgl/test/spaceinvaders/Sprite",
        "org/lwjgl/test/spaceinvaders/Texture",
        "org/lwjgl/test/spaceinvaders/TextureLoader",
        "org/lwjgl/util/Display",
        "org/lwjgl/util/WaveData",
        "org/lwjgl/util/glu/Cylinder",
        "org/lwjgl/util/glu/Disk",
        "org/lwjgl/util/glu/GLU",
        "org/lwjgl/util/glu/GLUtessellator",
        "org/lwjgl/util/glu/GLUtessellatorCallback",
        "org/lwjgl/util/glu/GLUtessellatorCallbackAdapter",
        "org/lwjgl/util/glu/MipMap",
        "org/lwjgl/util/glu/PartialDisk",
        "org/lwjgl/util/glu/PixelStoreState",
        "org/lwjgl/util/glu/Project",
        "org/lwjgl/util/glu/Quadric",
        "org/lwjgl/util/glu/Registry",
        "org/lwjgl/util/glu/Sphere",
        "org/lwjgl/util/glu/Util",
        "org/lwjgl/util/glu/tessellation/ActiveRegion",
        "org/lwjgl/util/glu/tessellation/CachedVertex",
        "org/lwjgl/util/glu/tessellation/Dict",
        "org/lwjgl/util/glu/tessellation/DictNode",
        "org/lwjgl/util/glu/tessellation/GLUface",
        "org/lwjgl/util/glu/tessellation/GLUhalfEdge",
        "org/lwjgl/util/glu/tessellation/GLUmesh",
        "org/lwjgl/util/glu/tessellation/GLUtessellatorImpl",
        "org/lwjgl/util/glu/tessellation/GLUvertex",
        "org/lwjgl/util/glu/tessellation/Geom",
        "org/lwjgl/util/glu/tessellation/Mesh",
        "org/lwjgl/util/glu/tessellation/Normal",
        "org/lwjgl/util/glu/tessellation/PriorityQ",
        "org/lwjgl/util/glu/tessellation/PriorityQHeap",
        "org/lwjgl/util/glu/tessellation/PriorityQSort",
        "org/lwjgl/util/glu/tessellation/Render",
        "org/lwjgl/util/glu/tessellation/Sweep",
        "org/lwjgl/util/glu/tessellation/TessMono",
        "org/lwjgl/util/glu/tessellation/TessState",
        "org/lwjgl/util/vector/Matrix",
        "org/lwjgl/util/vector/Matrix2f",
        "org/lwjgl/util/vector/Matrix3f",
        "org/lwjgl/util/vector/Matrix4f",
        "org/lwjgl/util/vector/Quaternion",
        "org/lwjgl/util/vector/ReadableVector",
        "org/lwjgl/util/vector/ReadableVector2f",
        "org/lwjgl/util/vector/ReadableVector3f",
        "org/lwjgl/util/vector/ReadableVector4f",
        "org/lwjgl/util/vector/Vector",
        "org/lwjgl/util/vector/Vector2f",
        "org/lwjgl/util/vector/Vector3f",
        "org/lwjgl/util/vector/Vector4f",
        "org/lwjgl/util/vector/WritableVector2f",
        "org/lwjgl/util/vector/WritableVector3f",
        "org/lwjgl/util/vector/WritableVector4f"
    };

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        ClassReader reader = new ClassReader(basicClass);
        ClassWriter writer = new ClassWriter(0);
        ClassVisitor visitor = new RemappingClassAdapter(writer, this);

        try {
            reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.warn("Couldn't remap class {}", transformedName, e);
            return basicClass;
        }

        return writer.toByteArray();
    }

    @Override
    public String map(String typeName) {
        calls++;
        final String OLD_PREFIX = "org/lwjgl/";
        final String NEW_PREFIX = "org/lwjglx/";
        if (typeName.startsWith(OLD_PREFIX) && Arrays.stream(MAPPED_CLASSES).anyMatch(typeName::contains)) {
            remaps++;
            final String newName = NEW_PREFIX + typeName.substring(OLD_PREFIX.length());
            return newName;
        } else {
            return typeName;
        }
    }
}
