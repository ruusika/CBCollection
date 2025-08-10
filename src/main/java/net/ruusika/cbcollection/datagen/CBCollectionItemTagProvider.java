package net.ruusika.cbcollection.datagen;

import com.hugman.culinaire.registry.content.CandyContent;
import com.hugman.culinaire.registry.content.DairyContent;
import com.hugman.culinaire.registry.content.PastryContent;
import com.hugman.culinaire.registry.content.VegetableContent;
import com.ianm1647.expandeddelight.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.ruusika.cbcollection.util.CBCollectionItemTags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ConventionalTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CBCollectionItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public CBCollectionItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CBCollectionItemTags.ASPARAGUS)
                .addOptional(Identifier.of("croptopia", "asparagus"))
                .add(ItemRegistry.ASPARAGUS);

        FabricTagProvider<Item>.FabricTagBuilder builder = getOrCreateTagBuilder(CBCollectionItemTags.BBQ_INGREDIENTS);
        for (Item item : getCooked()) {
            builder.add(item);
        }

        getOrCreateTagBuilder(CBCollectionItemTags.BROTH_INGREDIENTS)
                .add(Items.MILK_BUCKET)
                .addOptional(Identifier.of("croptopia", "soy_milk"))
                .addOptional(Identifier.of("croptopia", "milk_bottle"))
                .add(DairyContent.MILK_BOTTLE)
                .add(ModItems.MILK_BOTTLE.get())
                .add(ModItems.BONE_BROTH.get());
        getOrCreateTagBuilder(CBCollectionItemTags.CABBAGE_ROLL_INGREDIENTS).addOptionalTag(ModTags.CABBAGE_ROLL_INGREDIENTS);
        getOrCreateTagBuilder(CBCollectionItemTags.CAVE_INGREDIENTS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM)
                .add(Items.GLOW_BERRIES)
                .add(Items.HANGING_ROOTS)
                .add(Items.GLOW_LICHEN);
        getOrCreateTagBuilder(CBCollectionItemTags.CHEESE)
                .add(ItemRegistry.CHEESE_WHEEL)
                .addOptional(Identifier.of("croptopia", "cheese"))
                .add(DairyContent.CHEESE_WHEEL.asItem())
                .add(DairyContent.CHEESE);
        getOrCreateTagBuilder(CBCollectionItemTags.CHILE_PEPPER)
                .addOptional(Identifier.of("croptopia","chile_pepper"))
                .add(ItemRegistry.CHILI_PEPPER);
        getOrCreateTagBuilder(CBCollectionItemTags.CHOCOLATE)
                .addOptional(Identifier.of("croptopia","chocolate"))
                .add(CandyContent.DARK_CHOCOLATE_BAR)
                .add(CandyContent.MILK_CHOCOLATE_BAR)
                .add(CandyContent.WHITE_CHOCOLATE_BAR);
        getOrCreateTagBuilder(CBCollectionItemTags.CINNAMON)
                .add(ItemRegistry.GROUND_CINNAMON)
                .add(ItemRegistry.RAW_CINNAMON)
                .addOptional(Identifier.of("croptopia","cinnamon"));
        getOrCreateTagBuilder(CBCollectionItemTags.CORN).addOptional(Identifier.of("croptopia","corn"));
        getOrCreateTagBuilder(CBCollectionItemTags.CRAB).addOptional(Identifier.of("croptopia","crab"));
        getOrCreateTagBuilder(CBCollectionItemTags.CRUSTANIMAL).addOptional(Identifier.of("croptopia","crab"));
        getOrCreateTagBuilder(CBCollectionItemTags.DUMPLING_FILLS)
                .addOptionalTag(ConventionalTags.FOODS_RAW_MEATS)
                .add(Items.RABBIT)
                .addOptional(Identifier.of("croptopia","bacon"));
        getOrCreateTagBuilder(CBCollectionItemTags.EGG).add(Items.TURTLE_EGG).add(Items.EGG);
        getOrCreateTagBuilder(CBCollectionItemTags.EGGPLANT).addOptional(Identifier.of("croptopia","eggplant"));
        getOrCreateTagBuilder(CBCollectionItemTags.FLOUR).addOptional(Identifier.of("croptopia","flour"));
        getOrCreateTagBuilder(CBCollectionItemTags.FRIED_EGG).add(ModItems.FRIED_EGG.get());
        getOrCreateTagBuilder(CBCollectionItemTags.GARLIC)
                .addOptional(Identifier.of("croptopia","garlic"))
                .addOptional(Identifier.of("bewitchment","garlic"));
        getOrCreateTagBuilder(CBCollectionItemTags.LETTUCE)
                .add(VegetableContent.LETTUCE)
                .addOptional(Identifier.of("croptopia","cabbage"))
                .addOptional(Identifier.of("croptopia","lettuce"))
                .addOptional(Identifier.of("croptopia","sea_lettuce"))
                .add(ModItems.CABBAGE.get())
                .add(ModItems.CABBAGE_LEAF.get());
        getOrCreateTagBuilder(CBCollectionItemTags.MILK)
                .add(Items.MILK_BUCKET)
                .addOptional(Identifier.of("croptopia", "soy_milk"))
                .addOptional(Identifier.of("croptopia", "milk_bottle"))
                .add(DairyContent.MILK_BOTTLE)
                .add(ModItems.MILK_BOTTLE.get());
        getOrCreateTagBuilder(CBCollectionItemTags.NOODLES)
                .addOptional(Identifier.of("croptopia", "noodle"))
                .add(ModItems.RAW_PASTA.get());
        getOrCreateTagBuilder(CBCollectionItemTags.NORMAL_BITTER).add(Items.COCOA_BEANS).add(Items.DEAD_BUSH);
        getOrCreateTagBuilder(CBCollectionItemTags.NORMAL_SALTY)
                .add(Items.WARPED_ROOTS)
                .add(Items.SEAGRASS)
                .add(Items.KELP)
                .add(VegetableContent.TOMATO)
                .addOptional(Identifier.of("croptopia","tomato"))
                .add(ModItems.TOMATO.get());
        getOrCreateTagBuilder(CBCollectionItemTags.NORMAL_SOUR).add(Items.FERN).add(Items.LARGE_FERN);
        getOrCreateTagBuilder(CBCollectionItemTags.NORMAL_SWEET).add(Items.MELON_SEEDS).add(Items.SWEET_BERRIES).add(PastryContent.CHOUQUETTE);
        getOrCreateTagBuilder(CBCollectionItemTags.NORMAL_UNAMI).add(Items.CRIMSON_ROOTS);
        getOrCreateTagBuilder(CBCollectionItemTags.ONION)
                .add(ModItems.ONION.get())
                .addOptional(Identifier.of("croptopia","greenonion"))
                .addOptional(Identifier.of("croptopia","onion"));
        getOrCreateTagBuilder(CBCollectionItemTags.PUMPKIN_SOUP).addOptional(Identifier.of("croptopia","pumpkin_soup"));
        getOrCreateTagBuilder(CBCollectionItemTags.RICE)
                .addOptional(Identifier.of("croptopia","rice"))
                .addOptional(Identifier.of("croptopia","steamed_rice"))
                .add(ModItems.RICE.get())
                .add(ModItems.COOKED_RICE.get());
        getOrCreateTagBuilder(CBCollectionItemTags.ROSE).add(Items.WITHER_ROSE).add(Items.ROSE_BUSH);
        getOrCreateTagBuilder(CBCollectionItemTags.SALT)
                .addOptional(Identifier.of("croptopia","salt"))
                .addOptional(Identifier.of("bewitchment","salt"))
                .add(ItemRegistry.SALT_ROCK)
                .add(ItemRegistry.GROUND_SALT);
        getOrCreateTagBuilder(CBCollectionItemTags.SEASHELL).addOptional(Identifier.of("croptopia","clam"));
        getOrCreateTagBuilder(CBCollectionItemTags.SPICY_CROPS)
                .addOptional(Identifier.of("croptopia","chile_pepper"))
                .add(ItemRegistry.CHILI_PEPPER);
        getOrCreateTagBuilder(CBCollectionItemTags.STRONG_BITTER)
                .add(Items.WITHER_ROSE)
                .add(Items.GUNPOWDER)
                .add(Items.PUFFERFISH)
                .add(Items.FERMENTED_SPIDER_EYE);
        getOrCreateTagBuilder(CBCollectionItemTags.STRONG_SWEET).add(Items.HONEYCOMB)
                .add(DairyContent.CHEESE)
                .add(CandyContent.WHITE_CHOCOLATE_BAR)
                .add(CandyContent.MILK_CHOCOLATE_BAR)
                .add(CandyContent.DARK_CHOCOLATE_BAR);
        getOrCreateTagBuilder(CBCollectionItemTags.TOMATO).addOptional(Identifier.of("croptopia","tomato"))
                .add(VegetableContent.TOMATO)
                .add(ModItems.TOMATO.get());
        getOrCreateTagBuilder(CBCollectionItemTags.TROPICAL_FISH).add(Items.TROPICAL_FISH);
        getOrCreateTagBuilder(CBCollectionItemTags.VEGGIES)
                .addOptionalTag(ConventionalTags.FOODS_VEGETABLES)
                .addOptionalTag(CBCollectionItemTags.SPICY_CROPS)
                .add(VegetableContent.TOMATO)
                .add(Items.CARROT)
                .add(Items.POTATO)
                .add(Items.PUMPKIN)
                .addOptionalTag(CBCollectionItemTags.TOMATO)
                .addOptionalTag(CBCollectionItemTags.ONION)
                .addOptional(Identifier.of("croptopia","corn"))
                .addOptional(Identifier.of("croptopia","eggplant"));
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_BITTER).add(Items.BAMBOO).add(Items.CACTUS).add(Items.SNOWBALL);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_GLOOPY).add(Items.CHORUS_FRUIT);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_SALTY)
                .add(Items.PUMPKIN_SEEDS)
                .add(Items.NETHER_SPROUTS)
                .add(Items.WARPED_FUNGUS)
                .add(Items.DRIED_KELP);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_SHINING).add(Items.GLOWSTONE_DUST).add(Items.AMETHYST_SHARD);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_SOUR).add(Items.RED_MUSHROOM).add(Items.BROWN_MUSHROOM);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_SWEET)
                .add(Items.PUMPKIN_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.SUGAR)
                .add(CandyContent.MARSHMALLOW);
        getOrCreateTagBuilder(CBCollectionItemTags.WEAK_UNAMI).add(Items.CARROT).add(Items.CRIMSON_FUNGUS).add(VegetableContent.LETTUCE_SEEDS);
        getOrCreateTagBuilder(CBCollectionItemTags.COOKED_BACON).add(ModItems.COOKED_BACON.get()).addOptional(Identifier.of("croptopia","cooked_bacon"));
    }

    private static List<Item> getCooked() {
        return Registries.ITEM.stream().filter(item -> {
            Identifier id = Registries.ITEM.getId(item);
            return id.getPath().contains("cooked_");
        }).toList();
    }
}
