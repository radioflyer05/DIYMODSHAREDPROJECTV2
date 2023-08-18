package net.james.radioflyermod.block.entity;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RadioflyerMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<DistilleryBlockEntity>> DISTILLERY =
            BLOCK_ENTITIES.register("distillery", () ->
              BlockEntityType.Builder.of(DistilleryBlockEntity::new,
                      ModBlocks.DISTILLERY.get()).build(null));

    public static final RegistryObject<BlockEntityType<DecomposerBlockEntity>> DECOMPOSER =
            BLOCK_ENTITIES.register("decomposer", () ->
                    BlockEntityType.Builder.of(DecomposerBlockEntity::new,
                            ModBlocks.DECOMPOSER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
