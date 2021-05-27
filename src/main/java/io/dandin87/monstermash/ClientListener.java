package io.dandin87.monstermash;

import io.dandin87.monstermash.client.renderers.LittleGremlinRenderer;
import io.dandin87.monstermash.util.registry.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;

public class ClientListener implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isDevelopmentEnvironment() && !Nightmares.DISABLE_IN_DEV) {
			EntityRendererRegistry.INSTANCE.register(EntityRegistry.LITTLE_GREMLIN_ENTITY,
					(entityRenderDispatcher, context) -> new LittleGremlinRenderer(entityRenderDispatcher));
		}
	}
}