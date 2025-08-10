package net.ruusika.cbcollection.processor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ruusika.cbcollection.CBCollection;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

public class PotCraftingProcessor implements IComponentProcessor {
    private CookingPotRecipe recipe;

    @Override
    public void setup(World world, IVariableProvider variables) {
        if (!CBCollection.isModLoaded(CBCollection.MODID_FARMERSDELIGHT)) return;
        RecipeType<?> potRecipe = Registries.RECIPE_TYPE.get(new Identifier(CBCollection.MODID_FARMERSDELIGHT, "cooking"));
        if (MinecraftClient.getInstance().world == null) return;
        RecipeManager manager = MinecraftClient.getInstance().world.getRecipeManager();
        Identifier id = new Identifier(variables.get("recipe").asString());
        this.recipe = (CookingPotRecipe) manager.get(id).filter(recipe -> recipe.getType().equals(potRecipe)).orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public IVariable process(World world, String key) {
        switch (key) {
            case "result" -> {
                return IVariable.from(recipe.getOutput(world.getRegistryManager()));
            }
            case "header" -> {
                return IVariable.from(recipe.getOutput(world.getRegistryManager()).getName());
            }
            case "container" -> {
                return IVariable.from(recipe.getOutputContainer());
            }
        }
        int listedIngredientsCount = recipe.getIngredients().size();
        for (int i = 0; i < 6; i++) {
            if (key.equals("slot" + i)) {
                if (i >= listedIngredientsCount) return IVariable.from(new ItemStack(Items.AIR));
                ItemStack[] stack = recipe.getIngredients().get(i).getMatchingStacks();
                return stack.length > 0 ? IVariable.from(stack) : null;
            }
        }
        return null;
    }
}
