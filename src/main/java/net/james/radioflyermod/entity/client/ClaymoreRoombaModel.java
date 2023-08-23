package net.james.radioflyermod.entity.client;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.entity.custom.ClaymoreRoombaEntity;
import net.james.radioflyermod.entity.custom.RoboticChestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClaymoreRoombaModel extends AnimatedGeoModel<ClaymoreRoombaEntity> {
    @Override
    public ResourceLocation getModelResource(ClaymoreRoombaEntity object) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "geo/claymore_roomba.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ClaymoreRoombaEntity object) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "textures/entity/claymore_roomba_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ClaymoreRoombaEntity animatable) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "animations/claymore_roomba.animation.json");
    }
}
