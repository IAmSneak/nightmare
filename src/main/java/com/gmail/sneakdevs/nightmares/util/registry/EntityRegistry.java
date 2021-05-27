package com.gmail.sneakdevs.nightmares.util.registry;

import com.gmail.sneakdevs.nightmares.Nightmares;
import com.gmail.sneakdevs.nightmares.entity.LittleGremlinEntity;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import software.bernie.example.registry.EntityRegistryBuilder;

public class EntityRegistry {
	public static final EntityType<LittleGremlinEntity> LITTLE_GREMLIN_ENTITY = buildEntity(LittleGremlinEntity::new,
			LittleGremlinEntity.class, .6F, 1.4F);

	public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass,
															   float width, float height) {
		if (FabricLoader.INSTANCE.isDevelopmentEnvironment()) {
			String name = entityClass.getSimpleName().toLowerCase();
			return EntityRegistryBuilder.<T>createBuilder(new Identifier(Nightmares.MODID, name)).entity(entity)
					.category(SpawnGroup.CREATURE).dimensions(EntityDimensions.changing(width, height)).build();
		}
		return null;
	}
}
