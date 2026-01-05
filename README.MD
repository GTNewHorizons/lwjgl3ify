# LWJGL3ify

Brings LWJGL3 and modern Java versions to Minecraft 1.7.10.
Bundles [RetroFuturaBootstrap](https://github.com/GTNewHorizons/RetroFuturaBootstrap) as a flexible early load plugin system.

# Usage

Lwjgl3ify depends on:
 - Unimixins (<https://github.com/LegacyModdingMC/UniMixins/>), use at least version 0.1.23 with the GTNHMixins module.

Hodgepodge (<https://github.com/GTNewHorizons/Hodgepodge>) is strongly recommended, it has many Java 17+ compatibility patches for ARR mods (Biomes'o'Plenty, Witchery, JourneyMap, and more) which we could not directly fix in the GTNH forks.

## Client

### Non-GTNH 1.7.10 instance setup

**If you are using a GregTech New Horizons pre-packaged Java 17+ instance, skip to the next section!**

To install in PrismLauncher or MultiMC:

Copy the contents of `lwjgl3ify-VERSION-multimc.zip` to `instances/My Modpack/`. `mmc-pack.json` needs to be overwritten.
Reload the launcher, and it should show up modified versions of Forge, Minecraft and LWJGL3 in the instance window.
Put the mod jar (`lwjgl3ify-VERSION.jar`) in `mods/` in your instance's minecraft folder, it will get loaded as a coremod.
The forgePatches jar will get automatically downloaded by the launcher.

Make sure you have installed the UniMixins GTNHMixins and Mixin modules, or the all modules combined jar.

Change the instance java version to 17.0.6, 19.0.2, 20 or 21 (or newer), these are the currently supported versions.

### MultiMC setup (GTNH and non-GTNH)

> [!IMPORTANT]
> If you're using GTNH 2.8.1 or older, use the lwjgl3ify 2.x arguments from <https://github.com/GTNewHorizons/lwjgl3ify/blob/19bdc08297eca6975beaf0886ceca3bbc83cf368/README.MD#multimc-setup-gtnh-and-non-gtnh>.
> If you're using GTNH 2.5.1 or older, use the lwjgl3ify 1.x arguments from <https://github.com/GTNewHorizons/lwjgl3ify/blob/2229295b9fe5ed3304f62288f76f84bdb79ff5bb/README.MD#multimc-setup-gtnh-and-non-gtnh>.
> The following arguments are relevant to the 3.x version.

For MultiMC, you need to manually put in extra java arguments, Prism Launcher can load them from the patches json files automatically:
```
-Dfile.encoding=UTF-8 -Djava.system.class.loader=com.gtnewhorizons.retrofuturabootstrap.RfbSystemClassLoader --enable-native-access ALL-UNNAMED --add-opens java.base/java.io=ALL-UNNAMED --add-opens java.base/java.lang.invoke=ALL-UNNAMED --add-opens java.base/java.lang.ref=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.net.spi=ALL-UNNAMED --add-opens java.base/java.net=ALL-UNNAMED --add-opens java.base/java.nio.channels=ALL-UNNAMED --add-opens java.base/java.nio.charset=ALL-UNNAMED --add-opens java.base/java.nio.file=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.base/java.time.chrono=ALL-UNNAMED --add-opens java.base/java.time.format=ALL-UNNAMED --add-opens java.base/java.time.temporal=ALL-UNNAMED --add-opens java.base/java.time.zone=ALL-UNNAMED --add-opens java.base/java.time=ALL-UNNAMED --add-opens java.base/java.util.concurrent.atomic=ALL-UNNAMED --add-opens java.base/java.util.concurrent.locks=ALL-UNNAMED --add-opens java.base/java.util.jar=ALL-UNNAMED --add-opens java.base/java.util.zip=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/jdk.internal.loader=ALL-UNNAMED --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/jdk.internal.reflect=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.desktop/com.sun.imageio.plugins.png=ALL-UNNAMED --add-opens java.desktop/sun.awt.image=ALL-UNNAMED --add-opens java.desktop/sun.awt=ALL-UNNAMED --add-opens java.desktop/sun.lwawt.macosx=ALL-UNNAMED --add-opens java.sql.rowset/javax.sql.rowset.serial=ALL-UNNAMED --add-opens jdk.dynalink/jdk.dynalink.beans=ALL-UNNAMED --add-opens jdk.naming.dns/com.sun.jndi.dns=ALL-UNNAMED,java.naming
```

### (Experimental) Relauncher installation

To install in any client launcher, just drop the `lwjgl3ify-VERSION.jar` mod jar in the `mods/` directory and configure to launch with Java 8 as usual.
On startup, a window should appear prompting you to select a modern Java version to relaunch with, and the JVM settings for that Java installation.

### Tweaking configs
If you want to tweak your default window size, OpenGL context properties or other more advanced settings, check out the config file in `config/lwjgl3ify.cfg` after the first startup.

## Server
First, install a working 1.7.10 Forge server, from a modpack zip or using forge's installer.
Then, install the mod jar (and unimixins, hodgepodge as needed) in `mods/`, and download the `forgePatches` jar. Put the forgePatches jar in the same folder as your forge-universal and minecraft server jars.
**Thermos/Crucible/Hybrid servers are not supported!**.
Lwjgl3ify also depends on Unimixins (<https://github.com/LegacyModdingMC/UniMixins/>), use at least version 0.1.7.
Rename the forgePatches jar to just `lwjgl3ify-forgePatches.jar`. Create a file named `java9args.txt` with the contents of [the file in this repository](java9args.txt).
You can now launch the server with a command like the following, assuming the first java executable on your PATH is java 11/17/newer:
```
java -Xmx6G -Xms6G @java9args.txt -jar lwjgl3ify-forgePatches.jar nogui
```

# LiteLoader compatibility
To use LiteLoader with lwjgl3ify/RetroFuturaBootstrap the LiteloaderLoader by Midnight is required.

The install instructions can be found at [Midnight145/LiteloaderLoader/INSTALLATION.md](https://github.com/Midnight145/LiteloaderLoader/blob/master/INSTALLATION.md).

# How does it work?

There are a few components to enabling modern java and lwjgl usage on old minecraft versions, lwjgl3ify implements these for 1.7.10 specifically:

 - A modified launcher profile (templates are in `prism-libraries`) to modify the library list loaded into the java classpath - to install LWJGL3, and our forgePatches jar that includes libraries such as ASM 9 or new Apache Commons.
 - A custom server launcher jar with the modified `Class-Path` META-INF manifest entry (integrated into our forgePatches jar)
 - A FOSS replacement for launchwrapper with a java 9+-compatible classpath discovery mechanism and wider-reaching transformer capabilities at <https://github.com/GTNewHorizons/RetroFuturaBootstrap>.
 - A lot of add-opens flags for the JVM to allow reflection into JVM internals. Unfortunately a lot of libraries and mods depend on this to work, even weird ones like `java.text` or `nio` internals in case of Netty.
 - A partially auto-generated compatibility shim redirecting lwjgl2 api calls into the matching lwjgl3 calls (in `src/main/java/org/lwjglx`, `src/generated/java/org/lwjglx`), the generator is in `src/util/java`
 - Dummy `org/lwjgl/*` classes matching the classes removed from lwjgl3 (e.g. Display) for mods that rely on finding them under that location in the classpath - e.g. for mixin metadata
 - Replacement GL vendor information provider for crash reports, the old one caused JVM crashes if it was used from a thread without a valid OpenGL context
 - Asm transformers:
   - Asm transformer renaming any access to org/lwjgl to org/lwjglx after all other transformations have been done to the class - in `LwjglRedirectTransformer.java`
   - `javax/xml/bind` -> `jakarta/xml/bind/` asm transformer and a shaded version of jakarta.xml.bind, because that API was removed from JRE 11
   - Extensible enum transformer (copied under the lgpl license from Forge for minecraft 1.19.3) to replace a lot of the EnumHelper usages
   - Object holders unfinalizer, to remove the need for overwriting `static final` fields in Forge.
   - `FixConstantPoolInterfaceMethodRefHelper` is a transformer to fix a javac 8/asm 5.0 reobfuscator bug which generated wrong entries in the constant pool if method handles to interface methods were used
 - Mixins:
   - Object holder modifications to no longer write to `static final` fields
   - JarDiscoverer change to ignore `module-info.class` and `META-INF/versions/*` classes because it's not Java 9-aware
   - PostMixinTransformInjector used to move our asm transformer to run after the mixin processing
 - `UnsafeHacks` class from modern forge, modified to work in more usecases, for replacing some `static final` writes where it was not feasible/easy to remove final.
 - Forge patches, which are modified classes from Forge that cannot be transformed because they are loaded too early - so we load a `forgePatches` jar before Forge in the classpath to replace them:
   - EventSubscriptionTransformer: the format of subclass annotation descriptors has slightly changed in Java 17, this makes the annotation discovery compatible with both
   - TerminalTransformer: modify to accept classfiles newer than what asm5 supported
   - ClassPatchManager: switches the Pack200 implementation to an Apache Commons Compress one because it was removed from newer JDKs
   - TracingPrintStream: commons-compress closes System.out, this blocks this from happening
   - CoreModManager: work around the fact that the system classloader is no longer a URLClassLoader
   - FMLSecurityManager: fix some array index out of bounds exceptions, it is also deprecated in java 17 and will need to be replaced once a new API is available
   - EnumHelper: replace all the enumhelper apis with new variants using the extensible enum transformer and unsafe hacks.
 - Additional performance-enhancing mixins making use of LWJGL3 features:
   - spng-based image loader, much faster than Image4J
   - STB_rectpack-based texture sticher, it's nearly instant with tens of thousands of textures, compared to the vanilla code which takes many seconds to stitch that many textures into an atlas

## Fixing mods

This mod is not enough to make modpacks work in Java 9+, mods had to be updated. Here's a potentially incomplete list of breaking changes that needed code changes in mods, or mixins to fix non-open-source mods:

#### (NOT IN lwjgl3ify) System class loader is no longer a URLClassLoader

Lwjgl3ify replaces the system classloader with its own URLClassLoader-derived class that supports addURL and getURLs via public method calls that are compatible with the old reflection access for them.

To get the classpath, simply split `System.getProperty("java.class.path")` by `File.pathSeparator`.

Do note that for most mods, their classloader is still a `LaunchClassLoader` which does extend `URLClassLoader`.

To modify the URLClassPath you can use the following code:
```java
public static void addUrlToClassloader(ClassLoader loader, URL coreModUrl) {
    try {
        if (loader instanceof URLClassLoader) {
            if (ADDURL == null) {
                ADDURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                ADDURL.setAccessible(true);
            }
            ADDURL.invoke(loader, coreModUrl);
        } else {
            Field ucpField;
            try {
                // Java 8-11
                ucpField = loader.getClass().getDeclaredField("ucp");
            } catch (NoSuchFieldException e) {
                // Java 17
                ucpField = loader.getClass().getSuperclass().getDeclaredField("ucp");
            }
            ucpField.setAccessible(true);
            // URLClassPath is in different packages in different Java versions, so we use Object.
            final Object ucp = ucpField.get(loader);
            final Method urlAdder = ucp.getClass().getDeclaredMethod("addURL", URL.class);
            urlAdder.invoke(ucp, coreModUrl);
        }
    } catch (ReflectiveOperationException e) {
        throw new RuntimeException("Couldn't add url to classpath in loader " + loader.getClass(), e);
    }
}
```

#### `java.base/java.lang.reflect` classes are protected from reflective access
E.g. `Field.class.getDeclaredFields()` returns an empty list. The most common use of this was to change the `modifiers` field to strip `final` from the Field accessor to trick it into letting you write into `static final` fields.
Instead of that, use an access transformer (`public-f class field_srg # field_mcp`) to remove the `final` attribute at class load time.
Alternatively, inject a different initializer via Mixins/asm by modifying the class static constructor special method `<clinit>`.

If that is not feasible (e.g. runtime reflection discovering fields), you can use `sun.misc.Unsafe` to directly write to the memory location of the final field like so:
```java
final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
theUnsafe.setAccessible(true);
final Unsafe UNSAFE = (Unsafe) theUnsafe.get(null); // Cache this

public static void setField(Field data, Object object, Object value) {
    if (object == null) {
        long offset = UNSAFE.staticFieldOffset(data);
        Object base = UNSAFE.staticFieldBase(data);
        UNSAFE.putObject(base, offset, value);
    } else {
        long offset = UNSAFE.objectFieldOffset(data);
        UNSAFE.putObject(object, offset, value);
    }
}
```

This is likely to be removed from a 2025 Java release though, I'll probably build a JNI-based alternative built into lwjgl3ify by then.

**Beware**, the Java JIT compiler will assume that final fields don't change value at runtime, so the value you write there using Unsafe might not actually be read back by some code.
This can lead to inconsistent states, where some methods might see the old value while other ones will see the new value, especially if you change the value down a callchain that already read the value earlier.

### Development

First, do `./gradlew build` and use the zip in `./build/distributions/lwjgl3ify-VERSION-multimc.zip` to install lwjgl3ify into a 1.7.10 forge instance in Prism.
Install the mod jar from `./build/libs/` as usual.

When testing in the deobfuscated environment, please use the `runClient`/`runServer` tasks that run with modern java by default. `runClient17` et al. are no-ops.
