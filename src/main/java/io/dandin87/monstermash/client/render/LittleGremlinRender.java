package io.dandin87.monstermash.client.render;

import io.dandin87.monstermash.entity.LittleGremlinEntity;
import io.dandin87.monstermash.Nightmares;
import io.dandin87.monstermash.client.models.LittleGremlinModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LittleGremlinRender extends MobEntityRenderer<LittleGremlinEntity, LittleGremlinModel> {

	protected static final Identifier TEXTURE;

	static {
		TEXTURE = new Identifier(Nightmares.MODID, "texture/entity/pumpkin_carves_you_texture.png");
	}

	public LittleGremlinRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LittleGremlinModel(), 1.0F);
	}

	@Override
	public Identifier getTexture(LittleGremlinEntity entity) {
		return TEXTURE;
	}

}