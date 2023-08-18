package net.james.radioflyermod.recipe;

import net.james.radioflyermod.RadioflyerMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RadioflyerMod.MOD_ID);

    public static final RegistryObject <RecipeSerializer<DistilleryRecipe>> DISTILLING_SERIALIZER =
            SERIALIZERS.register("distilling", () -> DistilleryRecipe.Serializer.INSTANCE);

    public static final RegistryObject <RecipeSerializer<DecomposerRecipe>> DECOMPOSING_SERIALIZER =
            SERIALIZERS.register("decomposing", () -> DecomposerRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);

    }
}
