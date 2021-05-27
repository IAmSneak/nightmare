package com.gmail.sneakdevs.nightmares.client.renderer.entity;

import com.gmail.sneakdevs.nightmares.client.model.entity.LittleGremlinModel;
import com.gmail.sneakdevs.nightmares.entity.LittleGremlinEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class LittleGremlinRenderer extends GeoEntityRenderer<LittleGremlinEntity> {
    public LittleGremlinRenderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new LittleGremlinModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}