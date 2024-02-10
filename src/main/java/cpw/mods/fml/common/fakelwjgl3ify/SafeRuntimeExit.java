package cpw.mods.fml.common.fakelwjgl3ify;

/** Safe runtime exit class to not trip the FML security manager. */
public class SafeRuntimeExit {

    public static void exitRuntime(int code) {
        nest0(code);
    }

    private static void nest0(int code) {
        nest1(code);
    }

    private static void nest1(int code) {
        nest2(code);
    }

    private static void nest2(int code) {
        Runtime.getRuntime()
            .exit(code);
    }
}
