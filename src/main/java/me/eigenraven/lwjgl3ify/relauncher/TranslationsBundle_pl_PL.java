package me.eigenraven.lwjgl3ify.relauncher;

public class TranslationsBundle_pl_PL extends TranslationsBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            // spotless:off
            { KEY_CANCEL, "Anuluj" },
            { KEY_PROGRESS_DOWNLOADING_HEADER, "Ściąganie bibliotek lwjgl3ify..." },

            { KEY_SETTINGS_HEADER, "Ustawienia ponownego uruchamiania Javy przez lwjgl3ify" },
            { KEY_REFRESH, "Odśwież" },
            { KEY_ADD_JAVA, "Dodaj" },
            { KEY_RUN_GAME, "Uruchom" },
            { KEY_JAVA_EXECUTABLE, "Plik wykonywalny Javy: " },
            { KEY_MIN_MOD_JAVA, "Minimalna wersja Javy wymagana przez twoje mody: %s" },
            // spotless:on
        };
    }
}
