package net.james.radioflyermod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.recipe.DecomposerRecipe;
import net.james.radioflyermod.recipe.DistilleryRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIRadioflyerModPlugin implements IModPlugin {
    public static RecipeType<DistilleryRecipe> INFUSION_TYPE =
            new RecipeType<>(DistilleryRecipeCategory.UID, DistilleryRecipe.class);

    public static RecipeType<DecomposerRecipe> DECOMPOSING_TYPE =
            new RecipeType<>(DecomposerRecipeCategory.UID, DecomposerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                DistilleryRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                DecomposerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<DistilleryRecipe> recipesInfusing = rm.getAllRecipesFor(DistilleryRecipe.Type.INSTANCE);
        List<DecomposerRecipe> recipesDecomposing = rm.getAllRecipesFor(DecomposerRecipe.Type.INSTANCE);
        registration.addRecipes(INFUSION_TYPE, recipesInfusing);
        registration.addRecipes(DECOMPOSING_TYPE, recipesDecomposing);
    }
}