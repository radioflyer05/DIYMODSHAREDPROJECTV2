package net.james.radioflyermod.item;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.james.radioflyermod.entity.ModEntityTypes;
import net.james.radioflyermod.fluid.ModFluids;
import net.james.radioflyermod.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RadioflyerMod.MOD_ID);

        public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
                () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));
          public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titaniumingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

          public static final RegistryObject<Item> BARLEY_SEEDS = ITEMS.register("barley_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BARLEY_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

          public static final RegistryObject<Item> BARLEY = ITEMS.register("barley",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

          public static final RegistryObject<Item> ETHANOL = ITEMS.register("ethanol",
            () -> new EthanolItem(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> ROCKET_PACK = ITEMS.register("rocket_pack",
            () -> new RocketPackItem(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> BLOWTORCH = ITEMS.register("blow_torch",
            () -> new BlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> UPGRADED_ROCKET_PACK = ITEMS.register("upgraded_rocket_pack",
            () -> new UpgradedRocketPackItem(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

          public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_OIL,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> GAS_BUCKET = ITEMS.register("gas_bucket",
            () -> new BucketItem(ModFluids.SOURCE_GAS,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> YEAST_WATER_BUCKET = ITEMS.register("yeast_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_YEAST_WATER,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> HEXANE_BUCKET = ITEMS.register("hexane_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HEXANE,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> PENTANE_BUCKET = ITEMS.register("pentane_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PENTANE,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

          public static final RegistryObject<Item> REPULSION_SWORD = ITEMS.register("repulsion_sword",
            () -> new RepulsionSwordItem(Tiers.NETHERITE, 6, -2.0f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(Tiers.DIAMOND, 3, -2.4f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(Tiers.DIAMOND, 5.0F, -3.0f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(Tiers.DIAMOND, -3, 0.0f, new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GLASS_JAR = ITEMS.register("glass_jar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CRUSHED_BARLEY = ITEMS.register("crushed_barley",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> BARLEY_JAR = ITEMS.register("barley_jar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> YEAST = ITEMS.register("yeast",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> FUEL_TANK = ITEMS.register("fuel_tank",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> SMALL_2_STROKE_ENGINE = ITEMS.register("small_2_stroke_engine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> ROCKET_ENGINE = ITEMS.register("rocket_engine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> TURBINE = ITEMS.register("turbine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CRANK_CASE = ITEMS.register("crank_case",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CRANK_SHAFT = ITEMS.register("crank_shaft",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CYLINDER = ITEMS.register("cylinder",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> PISTON = ITEMS.register("piston",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> SPARK_PLUG = ITEMS.register("spark_plug",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> EMPTY_PRESSUREIZED_CONTAINER = ITEMS.register("empty_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> PENTANE_PRESSUREIZED_CONTAINER = ITEMS.register("pentane_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> BUTANE_PRESSUREIZED_CONTAINER = ITEMS.register("butane_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> PROPANE_PRESSUREIZED_CONTAINER = ITEMS.register("propane_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> ETHANE_PRESSUREIZED_CONTAINER = ITEMS.register("ethane_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> METHANE_PRESSUREIZED_CONTAINER = ITEMS.register("methane_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> PROPYLENE_PRESSUREIZED_CONTAINER = ITEMS.register("propylene_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> ETHYLENE_PRESSUREIZED_CONTAINER = ITEMS.register("ethylene_pressurized_container",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> PLASTIC_SHARD = ITEMS.register("plastic_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CLEAR_PLASTIC_SHARD = ITEMS.register("clear_plastic_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> ROBOTIC_CHEST_SPAWN_EGG = ITEMS.register("robotic_chest_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ROBOTIC_CHEST, 0x865D20, 0x211D18,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static final RegistryObject<Item> CLAYMORE_ROOMBA_SPAWN_EGG = ITEMS.register("claymore_roomba_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CLAYMORE_ROOMBA, 0xFFC600, 0x547C58,
                    new Item.Properties().tab(ModCreativeModeTab.RADIOFLYER_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);



    }

}
