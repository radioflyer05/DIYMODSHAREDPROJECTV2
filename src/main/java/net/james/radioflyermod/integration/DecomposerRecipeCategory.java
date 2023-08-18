package net.james.radioflyermod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.james.radioflyermod.recipe.DecomposerRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DecomposerRecipeCategory implements IRecipeCategory<DecomposerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(RadioflyerMod.MOD_ID, "decomposing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(RadioflyerMod.MOD_ID, "textures/gui/decomposer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DecomposerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DECOMPOSER.get()));
    }

    @Override
    public RecipeType<DecomposerRecipe> getRecipeType() {
        return JEIRadioflyerModPlugin.DECOMPOSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Chemical Decomposition");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DecomposerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 61).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 15).addItemStack(recipe.getResultItem());
    }
}