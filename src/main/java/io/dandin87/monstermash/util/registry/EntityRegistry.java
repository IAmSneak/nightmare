package io.dandin87.monstermash.util.registry;

import io.dandin87.monstermash.Nightmares;
import io.dandin87.monstermash.entity.LittleGremlinEntity;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;

public class EntityRegistry {
	public static final EntityType<LittleGremlinEntity> LITTLE_GREMLIN_ENTITY = buildEntity(LittleGremlinEntity::new,
			LittleGremlinEntity.class, .7F, 1.3F);

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