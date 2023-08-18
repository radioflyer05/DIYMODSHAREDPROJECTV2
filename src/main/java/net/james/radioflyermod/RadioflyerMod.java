package net.james.radioflyermod;

import com.mojang.logging.LogUtils;
import net.james.radioflyermod.block.ModBlocks;
import net.james.radioflyermod.block.entity.ModBlockEntities;
import net.james.radioflyermod.fluid.*;
import net.james.radioflyermod.item.ModItems;
import net.james.radioflyermod.networking.ModMessages;
import net.james.radioflyermod.recipe.ModRecipes;
import net.james.radioflyermod.screen.DecomposerScreen;
import net.james.radioflyermod.screen.DistilleryMenu;
import net.james.radioflyermod.screen.DistilleryScreen;
import net.james.radioflyermod.screen.ModMenuTypes;
import net.james.radioflyermod.world.feature.ModConfiguredFeatures;
import net.james.radioflyermod.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(RadioflyerMod.MOD_ID)
public class RadioflyerMod {
    public static final String MOD_ID = "radioflyermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RadioflyerMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluidTypesGas.register(modEventBus);
        ModFluidTypesYeastWater.register(modEventBus);
        ModFluidTypesHexane.register(modEventBus);
        ModFluidTypesPentane.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        ModMessages.register();
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(ModMenuTypes.DISTILLERY_MENU.get(), DistilleryScreen::new);
            MenuScreens.register(ModMenuTypes.DECOMPOSER_MENU.get(), DecomposerScreen::new);


            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_YEAST_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_YEAST_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_HEXANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_HEXANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PENTANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PENTANE.get(), RenderType.translucent());

        }
    }
}
