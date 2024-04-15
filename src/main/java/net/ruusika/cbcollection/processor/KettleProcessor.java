package net.ruusika.cbcollection.processor;

import com.hugman.culinaire.objects.recipe.TeaBagMakingRecipe;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class KettleProcessor implements IComponentProcessor {

    private TeaBagMakingRecipe recipe;

    @Override
    public void setup(IVariableProvider variables) {

    }

    @Override
    public IVariable process(String key) {
        return null;
    }
}
