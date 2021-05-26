package io.dandin87.monstermash.util;

import io.dandin87.monstermash.entity.LittleGremlinEntity;
import io.dandin87.monstermash.util.registry.MobEntityRegister;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MobAttributes {

	public static void init() {
		FabricDefaultAttributeRegistry.register(MobEntityRegister.LITTLE_GREMLIN, LittleGremlinEntity.createMobAttributes());
	}
}