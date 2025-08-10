package net.ruusika.cbcollection.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.ruusika.cbcollection.util.LoggerUtilities;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

public class CustomBookItem extends Item {

    public CustomBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayer) {
            Identifier customBookIdentifier = Registries.ITEM.getId(this);
            LoggerUtilities.devLogger("id: " + customBookIdentifier);
            Book customBook = BookRegistry.INSTANCE.books.get(customBookIdentifier);

            LoggerUtilities.devLogger(String.valueOf(customBook.getBookItem()));
            PatchouliAPI.get().openBookGUI(serverPlayer, customBook.id);

            serverPlayer.playSound(PatchouliSounds.getSound(SoundEvents.ITEM_BOOK_PAGE_TURN.getId(), PatchouliSounds.BOOK_OPEN), 1, 1);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

}
