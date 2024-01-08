package net.ruusika.cbcollection.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ruusika.cbcollection.CBCollection;
import net.ruusika.cbcollection.item.custom.CustomBookItem;
import net.ruusika.cbcollection.util.LoggerUtilities;

@SuppressWarnings({"unused", "SameParameterValue"})
public class CBCollectionItems {
    private static final Item DELIGHT_COOKBOOK = registerItem("delight_cookbook",
            new CustomBookItem(CBCollectionItemGroups.COOKBOOKS));
    private static final Item CROPTOPIA_2_COOKBOOK = registerItem("croptopia_2",
            new CustomBookItem(CBCollectionItemGroups.COOKBOOKS));
    private static final Item EX_DELIGHT_COOKBOOK = registerItem("ex_delight",
            new CustomBookItem(CBCollectionItemGroups.COOKBOOKS));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CBCollection.MODID, name), item);
    }

    public static void register() {
        LoggerUtilities.devLogger("Initialized " + CBCollection.MODID + " items");
    }
}