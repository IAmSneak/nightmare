package io.dandin87.monstermash.util;

import io.dandin87.monstermash.entity.LittleGremlinEntity;
import io.dandin87.monstermash.util.registry.EntityRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MobAttributes {

	public static void init() {
		FabricDefaultAttributeRegistry.register(EntityRegistry.LITTLE_GREMLIN_ENTITY, LittleGremlinEntity.createMobAttributes());
	}
}