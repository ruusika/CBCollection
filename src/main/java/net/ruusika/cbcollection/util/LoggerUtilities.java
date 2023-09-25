package net.ruusika.cbcollection.util;

import net.fabricmc.loader.api.FabricLoader;
import net.ruusika.cbcollection.CBCollection;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

/**
 * Helper class to clean up and make working with the console easier
 */
public class LoggerUtilities {
    private LoggerUtilities() {
        // empty private constructor for this "Helper Class" to avoid instantiating it.
        // no new objects for you, haha!
    }

    /**
     * This will print basic information in the console, if the Minecraft instance is run in a developer environment.<br>
     * This is an Overload of the {@link #devLogger(String, boolean, Exception) devLogger} method.<br><br>
     *
     * @param input input String to display in the console
     */
    public static void devLogger(String input) {
        devLogger(input, false, null);
    }

    /**
     * This LOGGER helper method will only print the LOGGER information to the console,
     * if the Minecraft instance is run in a developer environment.<br><br>
     * <p>
     * Using this method, instead of the {@linkplain Logger} directly,
     * can keep the console clean for the end-user or external Mod-pack developers.<br><br>
     *
     * @param input     Input String text to display in the console
     * @param isError   highlights the text differently in the console
     * @param exception Will print the error exception after the input text. <b><i>If not available, pass in null</i></b>
     */
    public static void devLogger(String input, boolean isError, @Nullable Exception exception) {
        if (!FabricLoader.getInstance().isDevelopmentEnvironment()) return;

        String printText = "DEV - [ " + input + " ] ";

        if (!isError) {
            CBCollection.LOGGER.info(printText);
            return;
        }
        if (exception == null) {
            CBCollection.LOGGER.error(printText);
            return;
        }

        CBCollection.LOGGER.error(printText, exception);
    }
}
