package net.james.radioflyermod.event;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.block.entity.DistilleryBlockEntity;
import net.james.radioflyermod.block.entity.ModBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = RadioflyerMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = RadioflyerMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

     //   @SubscribeEvent
     //   public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
      //      event.registerBlockEntityRenderer(ModBlockEntities.DISTILLERY.get(),
       //             DistilleryBlockEntityRenderer::new);
      //  }




    }
}