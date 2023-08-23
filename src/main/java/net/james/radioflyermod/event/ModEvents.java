package net.james.radioflyermod.event;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.entity.ModEntityTypes;
import net.james.radioflyermod.entity.custom.RoboticChestEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;




public class ModEvents {
    @Mod.EventBusSubscriber(modid = RadioflyerMod.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = RadioflyerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.ROBOTIC_CHEST.get(), RoboticChestEntity.setAttributes());
        }
    }
}