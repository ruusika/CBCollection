package net.ruusika.cbcollection.processor;

import com.nhoryzon.mc.farmersdelight.recipe.CookingPotRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ruusika.cbcollection.CBCollection;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class PotCraftingProcessor implements IComponentProcessor {
    private CookingPotRecipe recipe;

    @Override
    public void setup(IVariableProvider variables) {
        if (!CBCollection.isFarmerdsDelightLoaded()) return;
        RecipeType<?> potRecipe = Registry.RECIPE_TYPE.get(new Identifier(CBCollection.MODID_FARMERSDELIGHT, "cooking"));

        if (MinecraftClient.getInstance().world == null) return;
        RecipeManager manager = MinecraftClient.getInstance().world.getRecipeManager();

        Identifier id = new Identifier(variables.get("recipe").asString());
        this.recipe = (CookingPotRecipe) manager.get(id).filter(recipe -> recipe.getType().equals(potRecipe)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public IVariable process(String key) {
        switch (key) {
            case "result" -> IVariable.from(recipe.getOutput());
            case "header" -> IVariable.from(recipe.getOutput().getName());
            case "container" ->  IVariable.from(recipe.getContainer());
        }

        int listedIngredientsCount = recipe.getIngredients().size();

        for (int i = 0; i < listedIngredientsCount; i++) {
            if (key.equals("slot" + i)) {
                ItemStack[] stack = recipe.getIngredients().get(i).getMatchingStacks();
                return stack.length > 0 ? IVariable.from(stack[0]) : null;
            }
        }
        return null;
    }
}
