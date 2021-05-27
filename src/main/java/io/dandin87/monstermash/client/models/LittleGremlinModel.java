package io.dandin87.monstermash.client.models;

import io.dandin87.monstermash.Nightmares;
import io.dandin87.monstermash.entity.LittleGremlinEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class LittleGremlinModel extends AnimatedGeoModel {
    @Override
    public Identifier getAnimationFileLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "animations/little_gremlin.walking.json");
    }

    @Override
    public Identifier getModelLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "geo/little_gremlin_model.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "textures/entity/little_gremlin_texture.png");
    }

    @Override
    public void setLivingAnimations(IAnimatable entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}