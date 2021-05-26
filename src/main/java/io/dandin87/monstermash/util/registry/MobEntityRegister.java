package io.dandin87.monstermash.util.registry;

import io.dandin87.monstermash.Nightmares;
import io.dandin87.monstermash.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MobEntityRegister {

	public static final EntityType<LittleGremlinEntity> LITTLE_GREMLIN = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(Nightmares.MODID, "little_gremlin"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LittleGremlinEntity::new)
					.dimensions(EntityDimensions.fixed(1.0F, 1.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

}