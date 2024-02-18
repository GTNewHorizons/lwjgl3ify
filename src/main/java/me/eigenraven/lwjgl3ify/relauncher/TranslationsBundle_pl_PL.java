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
            { KEY_TAB_BASIC, "Podstawowe" },
            { KEY_TAB_ADVANCED, "Zaawansowane" },
            { KEY_JAVA_OPTIONS, "Opcje Javy: " },
            { KEY_MIN_MEMORY_MB, "Minimalna pamięć [MB]" },
            { KEY_MAX_MEMORY_MB, "Maksymalna pamięć [MB]" },
            { KEY_GARBAGE_COLLECTOR, "Odśmiecacz pamięci" },
            { KEY_CUSTOM_OPTIONS, "Własne opcje" },
            { KEY_SKIP_IN_FUTURE, "Pomiń to okno ustawień w przyszłości" },

            { KEY_FORWARD_LOGS, "Przekaż konsolę gry do programu uruchamiającego (zużywa więcej pamięci)" },
            { KEY_FORWARD_LOGS_TIP, "Wymaga podtrzymania istniejącej instancji Javy równolegle z nową instancją Javy. Bez zmniejszenia alokacji pamięci w programie uruchamiającym może zużyć podwojoną ilość pamięci, lub więcej." },
            { KEY_ALLOW_DEBUGGER, "Pozwól na dołączanie debugera" },
            { KEY_WAIT_FOR_DEBUGGER, "Poczekaj na debugera" },
            { KEY_MIXIN_DEBUG, "Mixin: Debugowanie" },
            { KEY_MIXIN_EXPORT_CLASSES, "Mixin: Eksportuj klasy" },
            { KEY_MIXIN_COUNT_INJECTIONS, "Mixin: Policz modyfikacje" },
            { KEY_FML_DEBUG_AT, "FML: Debuguj transformatory dostępu (AT)" },
            { KEY_RFB_DUMP_CLASSES, "RFB: Zapisz wczytywane klasy" },
            { KEY_RFB_DUMP_CLASSES_PER_TRANSFORMER, "RFB: Zapisz wczytywane klasy dla każdego transformatora" },
            { KEY_PREVIEW_JAVA_OPTS, "Podgląd opcji Javy" },
            // spotless:on
        };
    }
}
