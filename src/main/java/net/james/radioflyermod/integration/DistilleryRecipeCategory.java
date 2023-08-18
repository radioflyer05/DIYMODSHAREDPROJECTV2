package net.james.radioflyermod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.james.radioflyermod.recipe.DistilleryRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DistilleryRecipeCategory implements IRecipeCategory<DistilleryRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(RadioflyerMod.MOD_ID, "distilling");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(RadioflyerMod.MOD_ID, "textures/gui/distillery_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DistilleryRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DISTILLERY.get()));
    }

    @Override
    public RecipeType<DistilleryRecipe> getRecipeType() {
        return JEIRadioflyerModPlugin.INFUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Distillery");
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
    public void setRecipe(IRecipeLayoutBuilder builder, DistilleryRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 48, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 48, 56)
                        .addIngredients(ForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
                                .setFluidRenderer(30000, false, 67, 16);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 99, 18).addItemStack(recipe.getResultItem());
    }
}