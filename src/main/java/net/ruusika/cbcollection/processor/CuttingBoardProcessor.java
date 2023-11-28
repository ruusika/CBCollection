package net.ruusika.cbcollection.processor;

import com.nhoryzon.mc.farmersdelight.recipe.CuttingBoardRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ruusika.cbcollection.CBCollection;
import net.ruusika.cbcollection.util.LoggerUtilities;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class CuttingBoardProcessor implements IComponentProcessor {
    private CuttingBoardRecipe recipe;
    @Override
    public void setup(IVariableProvider variables) {
        if (!CBCollection.isFarmerdsDelightLoaded()) return;
        RecipeType<?> cuttingRecipe = Registry.RECIPE_TYPE.get(new Identifier(CBCollection.MODID_FARMERSDELIGHT, "cutting"));

        if (MinecraftClient.getInstance().world == null) return;
        RecipeManager manager = MinecraftClient.getInstance().world.getRecipeManager();

        Identifier id = new Identifier(variables.get("recipe").asString());
        this.recipe = (CuttingBoardRecipe) manager.get(id).filter(recipe -> recipe.getType().equals(cuttingRecipe)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public IVariable process(String key) {
        LoggerUtilities.devLogger(String.format("Key: %s", key));
        return switch (key) {
            case "header" -> IVariable.from(recipe.getOutput().getName());
            case "item0" -> IVariable.from(recipe.getIngredients().get(0));
            case "item1" -> IVariable.from(recipe.getIngredients().get(1));
            case "result" -> IVariable.from(recipe.getResultList().get(0));
            case "result2" -> IVariable.from(recipe.getResultList().get(1));
            case "tool" -> IVariable.from(recipe.getTool().getMatchingStacks());
            default -> null;
        };
    }
}
