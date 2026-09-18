package me.eigenraven.lwjgl3ify.redirects;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngineFactory;

public class ScriptEngineManager extends javax.script.ScriptEngineManager {

    private static final String NASHORN_FACTORY_CLASS = "org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory";

    public ScriptEngineManager() {
        super(resolveClassLoader(null));
        registerEmbeddedEngines();
    }

    public ScriptEngineManager(ClassLoader loader) {
        super(resolveClassLoader(loader));
        registerEmbeddedEngines();
    }

    private static ClassLoader resolveClassLoader(ClassLoader loader) {
        if (loader != null) {
            return loader;
        }

        ClassLoader contextLoader = Thread.currentThread()
            .getContextClassLoader();
        if (contextLoader != null) {
            return contextLoader;
        }

        ClassLoader ownLoader = ScriptEngineManager.class.getClassLoader();
        if (ownLoader != null) {
            return ownLoader;
        }

        return ClassLoader.getSystemClassLoader();
    }

    private void registerEmbeddedEngines() {
        if (hasJavaScriptEngineFactory()) {
            return;
        }

        ScriptEngineFactory factory = createFactory(NASHORN_FACTORY_CLASS);
        if (factory == null) {
            return;
        }

        for (String name : factory.getNames()) {
            registerEngineName(name, factory);
        }
        registerEngineName("JavaScript", factory);
        registerEngineName("javascript", factory);
        registerEngineName("js", factory);

        for (String extension : factory.getExtensions()) {
            registerEngineExtension(extension, factory);
        }

        for (String mimeType : factory.getMimeTypes()) {
            registerEngineMimeType(mimeType, factory);
        }
    }

    private boolean hasJavaScriptEngineFactory() {
        for (ScriptEngineFactory factory : getEngineFactories()) {
            for (String name : factory.getNames()) {
                if ("JavaScript".equalsIgnoreCase(name) || "js".equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ScriptEngineFactory createFactory(String factoryClassName) {
        for (ClassLoader loader : candidateClassLoaders()) {
            try {
                Class<?> factoryClass = Class.forName(factoryClassName, true, loader);
                return ScriptEngineFactory.class.cast(
                    factoryClass.getDeclaredConstructor()
                        .newInstance());
            } catch (ClassNotFoundException ignored) {
                // Try the next class loader.
            } catch (ReflectiveOperationException | LinkageError | ClassCastException ignored) {
                // ServiceLoader would ignore broken providers, so match that behavior here.
            }
        }

        return null;
    }

    private static List<ClassLoader> candidateClassLoaders() {
        List<ClassLoader> classLoaders = new ArrayList<>();
        addClassLoader(
            classLoaders,
            Thread.currentThread()
                .getContextClassLoader());
        addClassLoader(classLoaders, ScriptEngineManager.class.getClassLoader());
        addClassLoader(classLoaders, ClassLoader.getSystemClassLoader());
        return classLoaders;
    }

    private static void addClassLoader(List<ClassLoader> classLoaders, ClassLoader classLoader) {
        if (classLoader == null || classLoaders.contains(classLoader)) {
            return;
        }
        classLoaders.add(classLoader);
    }
}
