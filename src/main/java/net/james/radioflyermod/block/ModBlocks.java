
package net.james.radioflyermod.block;
import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.custom.*;
import net.james.radioflyermod.fluid.ModFluids;
import net.james.radioflyermod.item.ModCreativeModeTab;
import net.james.radioflyermod.item.ModItems;
import net.james.radioflyermod.world.feature.tree.ParaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RadioflyerMod.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.RADIOFLYER_TAB);
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> NETHERACK_TITANIUM_ORE = registerBlock("netherack_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> ENDSTONE_TITANIUM_ORE = registerBlock("endstone_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> REPULSION_BLOCK = registerBlock("repulsion_block",
            () -> new RepulsionBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> LED_LAMP = registerBlock("led_lamp",
            () -> new LEDLampBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(LEDLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.RADIOFLYER_TAB);
    public static final RegistryObject<Block> BARLEY_CROP = BLOCKS.register("barley_crop",
            () -> new BarleyCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<LiquidBlock> OIL_BLOCK = BLOCKS.register("oil_block",
            () -> new LiquidBlock(ModFluids.SOURCE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> GAS_BLOCK = BLOCKS.register("gas_block",
            () -> new LiquidBlock(ModFluids.SOURCE_GAS, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> YEAST_WATER_BLOCK = BLOCKS.register("yeast_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_YEAST_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> HEXANE_BLOCK = BLOCKS.register("hexane_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HEXANE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> PENTANE_BLOCK = BLOCKS.register("pentane_block",
            () -> new LiquidBlock(ModFluids.SOURCE_PENTANE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> DISTILLERY = registerBlock("distillery",
            () -> new DistilleryBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().dynamicShape()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> DECOMPOSER = registerBlock("decomposer",
            () -> new DecomposerBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().dynamicShape()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> ROBOTIC_CHEST_BLOCK = registerBlock("robotic_chest_block",
            () -> new RoboticChestBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> PARA_LOG = registerBlock("para_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> PARA_WOOD = registerBlock("para_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> STRIPPED_PARA_LOG = registerBlock("stripped_para_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> STRIPPED_PARA_WOOD = registerBlock("stripped_para_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> PARA_LEAVES = registerBlock("para_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.RADIOFLYER_TAB);

    public static final RegistryObject<Block> PARA_PLANKS = registerBlock("para_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.RADIOFLYER_TAB);

        public static final RegistryObject<Block> PARA_SAPLING = registerBlock("para_sapling",
            () -> new SaplingBlock(new ParaTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.RADIOFLYER_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}