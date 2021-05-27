package com.gmail.sneakdevs.nightmares.client.model.entity;

import com.gmail.sneakdevs.nightmares.Nightmares;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LittleGremlinModel extends AnimatedGeoModel {
    @Override
    public Identifier getAnimationFileLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "animations/little_gremlin.walk.json");
    }

    @Override
    public Identifier getModelLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "geo/little_gremlin_model.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Object entity) {
        return new Identifier(Nightmares.MODID, "textures/model/entity/little_gremlin_texture.png");
    }
}