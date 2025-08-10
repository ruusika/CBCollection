package net.ruusika.cbcollection.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.ruusika.cbcollection.CBCollection;

public class CBCollectionItemTags {

    public static final TagKey<Item> ASPARAGUS = createTag("asparagus");

    public static final TagKey<Item> BBQ_INGREDIENTS = createTag("barbecue_ingredients");
    public static final TagKey<Item> BROTH_INGREDIENTS = createTag("broth_ingredients");

    public static final TagKey<Item> CABBAGE_ROLL_INGREDIENTS = createTag("cabbage_roll_ingredients");
    public static final TagKey<Item> CAVE_INGREDIENTS = createTag("cave_ingredients");
    public static final TagKey<Item> CHEESE = createTag("cheese");
    public static final TagKey<Item> CHILE_PEPPER = createTag("chile_pepper");
    public static final TagKey<Item> CHOCOLATE = createTag("chocolate");
    public static final TagKey<Item> CINNAMON = createTag("cinnamon");
    public static final TagKey<Item> COOKED_BACON = createTag("cooked_bacon");
    public static final TagKey<Item> CORN = createTag("corn");
    public static final TagKey<Item> CRAB = createTag("crab");
    public static final TagKey<Item> CRUSTANIMAL = createTag("crustanimal");

    public static final TagKey<Item> DUMPLING_FILLS = createTag("dumpling_fills");

    public static final TagKey<Item> EGG = createTag("egg");
    public static final TagKey<Item> EGGPLANT = createTag("eggplant");

    public static final TagKey<Item> FLOUR = createTag("flour");
    public static final TagKey<Item> FRIED_EGG = createTag("fried_egg");

    public static final TagKey<Item> GARLIC = createTag("garlic");

    public static final TagKey<Item> LETTUCE = createTag("lettuce");

    public static final TagKey<Item> MILK = createTag("milk");

    public static final TagKey<Item> NOODLES = createTag("noodles");
    public static final TagKey<Item> NORMAL_BITTER = createTag("normal_bitter");
    public static final TagKey<Item> NORMAL_SALTY = createTag("normal_salty");
    public static final TagKey<Item> NORMAL_SOUR = createTag("normal_sour");
    public static final TagKey<Item> NORMAL_SWEET = createTag("normal_sweet");
    public static final TagKey<Item> NORMAL_UNAMI = createTag("normal_unami");

    public static final TagKey<Item> ONION = createTag("onion");

    public static final TagKey<Item> PUMPKIN_SOUP = createTag("pumpkin_soup");

    public static final TagKey<Item> RICE = createTag("rice");
    public static final TagKey<Item> ROSE = createTag("rose");

    public static final TagKey<Item> SALT = createTag("salt");
    public static final TagKey<Item> SEASHELL = createTag("seashell");
    public static final TagKey<Item> SPICY_CROPS = createTag("spicy_crops");
    public static final TagKey<Item> STRONG_BITTER = createTag("strong_bitter");
    public static final TagKey<Item> STRONG_SWEET = createTag("strong_sweet");

    public static final TagKey<Item> TOMATO = createTag("tomato");
    public static final TagKey<Item> TROPICAL_FISH = createTag("tropical_fish");

    public static final TagKey<Item> VEGGIES = createTag("veggies");

    public static final TagKey<Item> WEAK_BITTER = createTag("weak_bitter");
    public static final TagKey<Item> WEAK_GLOOPY = createTag("weak_gloopy");
    public static final TagKey<Item> WEAK_SALTY = createTag("weak_salty");
    public static final TagKey<Item> WEAK_SHINING = createTag("weak_shining");
    public static final TagKey<Item> WEAK_SOUR = createTag("weak_sour");
    public static final TagKey<Item> WEAK_SWEET = createTag("weak_sweet");
    public static final TagKey<Item> WEAK_UNAMI = createTag("weak_unami");

    private static TagKey<Item> createTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, CBCollection.getID(name));
    }
}
