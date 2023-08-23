package net.james.radioflyermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.james.radioflyermod.RadioflyerMod;
import net.james.radioflyermod.entity.custom.RoboticChestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RoboticChestRenderer extends GeoEntityRenderer<RoboticChestEntity> {
    public RoboticChestRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RoboticChestModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public ResourceLocation getTextureLocation(RoboticChestEntity instance) {
        return new ResourceLocation(RadioflyerMod.MOD_ID, "textures/entity/robotic_chest_texture.png");
    }

    @Override
    public RenderType getRenderType(RoboticChestEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
