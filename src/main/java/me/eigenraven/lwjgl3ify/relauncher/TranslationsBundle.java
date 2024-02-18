package me.eigenraven.lwjgl3ify.relauncher;

import java.util.ListResourceBundle;

// The default English translations
public class TranslationsBundle extends ListResourceBundle {

    public static final String KEY_CANCEL = "cancel";

    public static final String KEY_PROGRESS_DOWNLOADING_HEADER = "progressDownloading";

    public static final String KEY_SETTINGS_HEADER = "settingsHeader";
    public static final String KEY_ADD_JAVA = "addJava";
    public static final String KEY_REFRESH = "refresh";
    public static final String KEY_RUN_GAME = "runGame";
    public static final String KEY_JAVA_EXECUTABLE = "javaExecutable";
    public static final String KEY_MIN_MOD_JAVA = "minModJava";

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
            // spotless:on
        };
    }
}
