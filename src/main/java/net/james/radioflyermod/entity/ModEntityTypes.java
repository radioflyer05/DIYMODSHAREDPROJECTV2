package net.james.radioflyermod.entity;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.entity.custom.ClaymoreRoombaEntity;
import net.james.radioflyermod.entity.custom.RoboticChestEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
                DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RadioflyerMod.MOD_ID);

    public static final RegistryObject <EntityType<RoboticChestEntity>> ROBOTIC_CHEST =
            ENTITY_TYPES.register("robotic_chest",
                    () -> EntityType.Builder.of(RoboticChestEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 0.9f)
                            .build(new ResourceLocation(RadioflyerMod.MOD_ID, "robotic_chest").toString()));


    public static final RegistryObject <EntityType<ClaymoreRoombaEntity>> CLAYMORE_ROOMBA =
            ENTITY_TYPES.register("claymore_roomba",
                    () -> EntityType.Builder.of(ClaymoreRoombaEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(RadioflyerMod.MOD_ID, "claymore_roomba").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
