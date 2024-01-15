package net.ruusika.cbcollection.processor;

import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ruusika.cbcollection.CBCollection;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class JuicerProcessor implements IComponentProcessor {

    private JuicerRecipe recipe;

    @Override
    public void setup(IVariableProvider variables) {
        if (!CBCollection.isModLoaded(CBCollection.MODID_EXPANDEDDELIGHT)) return;
        RecipeType<?> juicingRecipe = Registry.RECIPE_TYPE.get(new Identifier(CBCollection.MODID_EXPANDEDDELIGHT, "juicing"));
        if (MinecraftClient.getInstance().world == null) return;
        RecipeManager manager = MinecraftClient.getInstance().world.getRecipeManager();
        Identifier id = new Identifier(variables.get("recipe").asString());
        this.recipe = (JuicerRecipe) manager.get(id).filter(recipe -> recipe.getType().equals(juicingRecipe)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public IVariable process(String key) {
        return switch (key) {
            case "header" -> IVariable.from(recipe.getOutput().getName());
            case "slot0" -> IVariable.from(recipe.getIngredients().get(0));
            case "slot1" -> IVariable.from(recipe.getIngredients().get(1));
            case "result" -> IVariable.from(recipe.getOutput());
            default -> null;
        };
    }
}
