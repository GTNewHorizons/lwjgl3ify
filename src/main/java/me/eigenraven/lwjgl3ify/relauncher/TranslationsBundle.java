package me.eigenraven.lwjgl3ify.relauncher;

import java.util.ListResourceBundle;

/**
 * The default English translations, and translation key constants.
 * We're using Java bundles instead of Property bundles to allow UTF-8 encoding in the sources.
 */
public class TranslationsBundle extends ListResourceBundle {

    public static final String KEY_CANCEL = "cancel";

    public static final String KEY_PROGRESS_DOWNLOADING_HEADER = "progressDownloading";

    public static final String KEY_SETTINGS_HEADER = "settingsHeader";
    public static final String KEY_ADD_JAVA = "addJava";
    public static final String KEY_REFRESH = "refresh";
    public static final String KEY_RUN_GAME = "runGame";
    public static final String KEY_JAVA_EXECUTABLE = "javaExecutable";
    public static final String KEY_MIN_MOD_JAVA = "minModJava";
    public static final String KEY_TAB_BASIC = "tabBasic";
    public static final String KEY_TAB_ADVANCED = "tabAdvanced";
    public static final String KEY_JAVA_OPTIONS = "javaOptions";
    public static final String KEY_MIN_MEMORY_MB = "minMemoryMB";
    public static final String KEY_MAX_MEMORY_MB = "maxMemoryMB";
    public static final String KEY_GARBAGE_COLLECTOR = "garbageCollector";
    public static final String KEY_CUSTOM_OPTIONS = "customOptions";
    public static final String KEY_SKIP_IN_FUTURE = "skipInFuture";
    public static final String KEY_FORWARD_LOGS = "forwardLogs";
    public static final String KEY_ALLOW_DEBUGGER = "allowDebugger";
    public static final String KEY_WAIT_FOR_DEBUGGER = "waitForDebugger";
    public static final String KEY_MIXIN_DEBUG = "mixinDebug";
    public static final String KEY_MIXIN_EXPORT_CLASSES = "mixinExportClasses";
    public static final String KEY_MIXIN_COUNT_INJECTIONS = "mixinCountInjections";
    public static final String KEY_FML_DEBUG_AT = "fmlDebugAT";
    public static final String KEY_RFB_DUMP_CLASSES = "rfbDumpClasses";
    public static final String KEY_RFB_DUMP_CLASSES_PER_TRANSFORMER = "rfbDumpClassesPerTransformer";
    public static final String KEY_FORWARD_LOGS_TIP = "forwardLogsTip";
    public static final String KEY_PREVIEW_JAVA_OPTS = "previewJavaOpts";

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            // spotless:off
            { KEY_CANCEL, "Cancel" },
            { KEY_PROGRESS_DOWNLOADING_HEADER, "Downloading lwjgl3ify libraries..." },

            { KEY_SETTINGS_HEADER, "Lwjgl3ify Modern Java Relaunch Settings" },
            { KEY_REFRESH, "Refresh" },
            { KEY_ADD_JAVA, "Add" },
            { KEY_RUN_GAME, "Run" },
            { KEY_JAVA_EXECUTABLE, "Java executable: " },
            { KEY_MIN_MOD_JAVA, "Minimum Java version required by your mods: %s" },
            { KEY_TAB_BASIC, "Basic" },
            { KEY_TAB_ADVANCED, "Advanced" },
            { KEY_JAVA_OPTIONS, "Java options: " },
            { KEY_MIN_MEMORY_MB, "Min memory [MB]" },
            { KEY_MAX_MEMORY_MB, "Max memory [MB]" },
            { KEY_GARBAGE_COLLECTOR, "Garbage collector" },
            { KEY_CUSTOM_OPTIONS, "Custom options" },
            { KEY_SKIP_IN_FUTURE, "Skip the settings window in the future" },

            { KEY_FORWARD_LOGS, "Forward logs to the parent launcher (uses more memory)" },
            { KEY_FORWARD_LOGS_TIP, "Requires you to keep running this old java instance in parallel with the new java instance, so if you didn't configure your launcher to use less memory, the game might use double the memory or more." },
            { KEY_ALLOW_DEBUGGER, "Allow attaching a debugger" },
            { KEY_WAIT_FOR_DEBUGGER, "Wait for debugger" },
            { KEY_MIXIN_DEBUG, "Mixin: Debug" },
            { KEY_MIXIN_EXPORT_CLASSES, "Mixin: Export classes" },
            { KEY_MIXIN_COUNT_INJECTIONS, "Mixin: Count injections" },
            { KEY_FML_DEBUG_AT, "FML: Debug Access Transformers" },
            { KEY_RFB_DUMP_CLASSES, "RFB: Dump loaded classes" },
            { KEY_RFB_DUMP_CLASSES_PER_TRANSFORMER, "RFB: Dump classes per transformer" },
            { KEY_PREVIEW_JAVA_OPTS, "Preview Java options" },
            // spotless:on
        };
    }
}
