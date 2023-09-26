package net.ruusika.cbcollection.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.ruusika.cbcollection.CBCollection;
import vazkii.patchouli.common.item.PatchouliItems;

@SuppressWarnings("ALL")
public class CBCollectionItemGroups {
    public static final ItemGroup COOKBOOKS = registerGroup("cookbooks", PatchouliItems.BOOK);

    private static ItemGroup registerGroup(String name, Item groupIconItem) {
        return FabricItemGroupBuilder.build(new Identifier(CBCollection.MODID, name), () -> new ItemStack(groupIconItem));
    }
}
