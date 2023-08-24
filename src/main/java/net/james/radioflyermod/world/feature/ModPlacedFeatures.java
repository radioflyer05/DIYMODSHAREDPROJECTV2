package net.james.radioflyermod.world.feature;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, RadioflyerMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED = PLACED_FEATURES.register("titanium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TITANIUM_ORE.getHolder().get(),
                    commonOrePlacement(4, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> OIL_DEPOSIT_PLACED = PLACED_FEATURES.register("oil_deposit_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.OVERWORLD_OIL.getHolder().get(),
                    commonOrePlacement(10, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> END_TITANIUM_ORE_PLACED = PLACED_FEATURES.register("end_titanium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_TITANIUM_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_TITANIUM_ORE_PLACED = PLACED_FEATURES.register("nether_titanium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_TITANIUM_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));




    public static final RegistryObject<PlacedFeature> PARA_CHECKED = PLACED_FEATURES.register("para_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.PARA.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.PARA_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> PARA_PLACED = PLACED_FEATURES.register("para_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PARA_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    //Spawn Chance (0 Tree Per Chunk, 10% Chance To Spawn 1 more Tree Per Chunk)
                    PlacementUtils.countExtra(0, 0.1f, 1))));

    public static final RegistryObject<PlacedFeature> BISMUTH_GEODE_PLACED = PLACED_FEATURES.register("bismuth_geode_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BISMUTH_GEODE.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(2), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome())));




    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);

    }
}
