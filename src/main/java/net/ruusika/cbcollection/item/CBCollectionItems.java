package net.ruusika.cbcollection.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ruusika.cbcollection.CBCollection;
import net.ruusika.cbcollection.util.LoggerUtilities;

@SuppressWarnings({"unused", "SameParameterValue"})
public class CBCollectionItems {
    private static final Item DELIGHT_COOKBOOK = registerItem("delight_cookbook",
            new BookItem(new FabricItemSettings().maxCount(1).group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CBCollection.MODID, name), item);
    }

    public static void register(){
        LoggerUtilities.devLogger("Initialized " + CBCollection.MODID + " items");
    }
}