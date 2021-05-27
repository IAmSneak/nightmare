package io.dandin87.monstermash.client.renderers;

import io.dandin87.monstermash.client.models.LittleGremlinModel;
import io.dandin87.monstermash.entity.LittleGremlinEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class LittleGremlinRenderer extends GeoEntityRenderer<LittleGremlinEntity> {
    public LittleGremlinRenderer(EntityRenderDispatcher renderDispatcher) {
        super(renderDispatcher, new LittleGremlinModel());
    }

    @Override
    public RenderLayer getRenderType(LittleGremlinEntity animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }
}