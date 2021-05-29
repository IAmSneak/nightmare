package com.gmail.sneakdevs.nightmares;

import com.gmail.sneakdevs.nightmares.entity.entity.LittleGremlinEntity;
import com.gmail.sneakdevs.nightmares.entity.spawners.LittleGremlinSpawner;
import com.gmail.sneakdevs.nightmares.util.registry.ModSoundEvents;
import com.gmail.sneakdevs.nightmares.util.registry.EntityRegistry;
import com.gmail.sneakdevs.nightmares.util.registry.NightmaresItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import software.bernie.geckolib3.GeckoLib;

public class Nightmares implements ModInitializer {

	public static final String MODID = "nightmares";
	public static boolean canNoClip = false;

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		new EntityRegistry();
		FabricDefaultAttributeRegistry.register(EntityRegistry.LITTLE_GREMLIN_ENTITY,
				LittleGremlinEntity.createMobAttributes());

		NightmaresItems.init();
		ModSoundEvents.init();
		System.out.println("Your worst fears have come true");

	}
}
