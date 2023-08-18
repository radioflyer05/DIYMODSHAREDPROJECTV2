package net.james.radioflyermod.fluid;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.james.radioflyermod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, RadioflyerMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_OIL = FLUIDS.register("oil_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.OIL_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_GAS = FLUIDS.register("gas_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.GAS_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_YEAST_WATER = FLUIDS.register("yeast_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.YEAST_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_HEXANE = FLUIDS.register("hexane_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HEXANE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_PENTANE = FLUIDS.register("pentane_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PENTANE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_OIL = FLUIDS.register("flowing_oil",
             () -> new ForgeFlowingFluid.Flowing(ModFluids.OIL_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_GAS = FLUIDS.register("flowing_gas",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.GAS_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_YEAST_WATER = FLUIDS.register("flowing_yeast_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.YEAST_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_HEXANE = FLUIDS.register("flowing_hexane",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HEXANE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_PENTANE = FLUIDS.register("flowing_pentane",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PENTANE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties OIL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.OIL_FLUID_TYPE, SOURCE_OIL, FLOWING_OIL)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.OIL_BLOCK).bucket(ModItems.OIL_BUCKET);

    public static final ForgeFlowingFluid.Properties GAS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypesGas.GAS_FLUID_TYPE, SOURCE_GAS, FLOWING_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.GAS_BLOCK).bucket(ModItems.GAS_BUCKET);

    public static final ForgeFlowingFluid.Properties YEAST_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypesYeastWater.YEAST_WATER_FLUID_TYPE, SOURCE_YEAST_WATER, FLOWING_YEAST_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.YEAST_WATER_BLOCK).bucket(ModItems.YEAST_WATER_BUCKET);

    public static final ForgeFlowingFluid.Properties HEXANE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypesHexane.HEXANE_FLUID_TYPE, SOURCE_HEXANE, FLOWING_HEXANE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.HEXANE_BLOCK).bucket(ModItems.HEXANE_BUCKET);

    public static final ForgeFlowingFluid.Properties PENTANE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypesPentane.PENTANE_FLUID_TYPE, SOURCE_PENTANE, FLOWING_PENTANE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.PENTANE_BLOCK).bucket(ModItems.PENTANE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
