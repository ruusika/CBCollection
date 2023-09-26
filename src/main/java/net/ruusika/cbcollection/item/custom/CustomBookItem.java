package net.ruusika.cbcollection.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.ruusika.cbcollection.item.CBCollectionItemGroups;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

public class CustomBookItem extends Item {
    public CustomBookItem() {
        super(new FabricItemSettings().maxCount(1).group(CBCollectionItemGroups.COOKBOOKS));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user instanceof ServerPlayerEntity serverPlayer){
            Identifier test = Registry.ITEM.getId(this);
            Book book = BookRegistry.INSTANCE.books.get(test);
            PatchouliAPI.get().openBookGUI(serverPlayer, book.id);
            serverPlayer.playSound(PatchouliSounds.getSound(book.openSound, PatchouliSounds.BOOK_OPEN), 1, 1);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
