package net.james.radioflyermod.entity.client;

import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.entity.custom.RoboticChestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RoboticChestModel extends AnimatedGeoModel<RoboticChestEntity> {
    @Override
    public ResourceLocation getModelResource(RoboticChestEntity object) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "geo/robotic_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RoboticChestEntity object) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "textures/entity/robotic_chest_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RoboticChestEntity animatable) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "animations/robotic_chest.animation.json");
    }
}
