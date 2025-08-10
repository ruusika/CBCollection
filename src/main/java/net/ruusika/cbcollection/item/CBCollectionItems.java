package net.ruusika.cbcollection.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.ruusika.cbcollection.CBCollection;
import net.ruusika.cbcollection.item.custom.CustomBookItem;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "SameParameterValue"})
public class CBCollectionItems {
    public static final List<ItemStack> ALL_ITEMS = new ArrayList<>();

    public static final Item DELIGHT_COOKBOOK = registerItem("delight_cookbook",
            new CustomBookItem(new Item.Settings().maxCount(1)));
    public static final Item CROPTOPIA_2_COOKBOOK = registerItem("croptopia_2",
            new CustomBookItem(new Item.Settings().maxCount(1)));
    public static final Item EX_DELIGHT_COOKBOOK = registerItem("ex_delight",
            new CustomBookItem(new Item.Settings().maxCount(1)));
    public static final Item CULINAIRE_COOKBOOK = registerItem("culinaires_need",
            new CustomBookItem(new Item.Settings().maxCount(1)));

    public static final RegistryKey<ItemGroup> CBCOLLECTION_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            CBCollection.getID("cbcollection"));

    public static final ItemGroup CBCOLLECTION_ITEM_GROUP = registerItemGroup("cbcollection",FabricItemGroup.builder()
            .icon(() -> new ItemStack(DELIGHT_COOKBOOK))
            .displayName(Text.translatable("itemGroup.cbcollection.cookbooks"))
            .noScrollbar()
            .entries((displayContext, entries) -> entries.addAll(ALL_ITEMS))
            .build());

    private static ItemGroup registerItemGroup(String name, ItemGroup itemGroup){
        return Registry.register(Registries.ITEM_GROUP, CBCollection.getID(name), itemGroup);
    }

    private static Item registerItem(String name, Item item) {
        Item registeredItem = Registry.register(Registries.ITEM, CBCollection.getID(name), item);
        ALL_ITEMS.add(new ItemStack(registeredItem));
        return registeredItem;
    }

    public static void register() {

    }
}