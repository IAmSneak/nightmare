package io.dandin87.monstermash.client;

import io.dandin87.monstermash.client.render.*;
import io.dandin87.monstermash.util.registry.MobEntityRegister;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class NightmaresRenderRegistry {

	public static void init() {
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.LITTLE_GREMLIN, (dispatcher, context) -> new LittleGremlinRender(dispatcher));
	}
}