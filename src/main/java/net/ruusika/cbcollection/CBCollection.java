package net.ruusika.cbcollection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.ruusika.cbcollection.item.CBCollectionItems;
import net.ruusika.cbcollection.util.LoggerUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CBCollection implements ModInitializer {
    public static String MODID = "cbcollection";
    public static String MODID_FARMERSDELIGHT = "farmersdelight";
    public static String MODID_EXPANDEDDELIGHT = "expandeddelight";

    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        CBCollectionItems.register();

        LoggerUtilities.devLogger(MODID + " has been launched in a developer environment");
        LOGGER.info("DINONUGGETS!");
    }

    public static Identifier getID(String path){
        return Identifier.of(MODID, path);
    }

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}