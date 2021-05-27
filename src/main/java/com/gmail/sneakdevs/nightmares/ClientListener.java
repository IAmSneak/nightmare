package com.gmail.sneakdevs.nightmares;

import com.gmail.sneakdevs.nightmares.client.renderer.entity.LittleGremlinRenderer;
import com.gmail.sneakdevs.nightmares.util.registry.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ClientListener implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(EntityRegistry.LITTLE_GREMLIN_ENTITY,
				(entityRenderDispatcher, context) -> new LittleGremlinRenderer(entityRenderDispatcher));
	}
}