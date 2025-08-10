package net.ruusika.cbcollection.processor;


import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ruusika.cbcollection.CBCollection;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;

public class CuttingBoardProcessor implements IComponentProcessor {
    private CuttingBoardRecipe recipe;

    @Override
    public void setup(World world, IVariableProvider variables) {
        if (!CBCollection.isModLoaded(CBCollection.MODID_FARMERSDELIGHT)) return;
        RecipeType<?> cuttingRecipe = Registries.RECIPE_TYPE.get(new Identifier(CBCollection.MODID_FARMERSDELIGHT, "cutting"));
        if (MinecraftClient.getInstance().world == null) return;
        RecipeManager manager = MinecraftClient.getInstance().world.getRecipeManager();
        Identifier id = new Identifier(variables.get("recipe").asString());
        this.recipe = (CuttingBoardRecipe) manager.get(id).filter(recipe -> recipe.getType().equals(cuttingRecipe)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public IVariable process(World world, String key) {
        return switch (key) {
            case "header" -> IVariable.from(recipe.getOutput(world.getRegistryManager()).getName());
            case "slot0" -> IVariable.from(recipe.getIngredients().get(0));
            case "result0" -> IVariable.from(recipe.getResults().get(0));
            case "result1" -> {
                if (recipe.getResults().size() > 1) yield IVariable.from(recipe.getResults().get(1));
                else yield null;
            }
            case "tool" -> IVariable.from(recipe.getTool().getMatchingStacks());
            default -> null;
        };
    }
}
