package com.gmail.sneakdevs.nightmares.util.registry;

import com.gmail.sneakdevs.nightmares.Nightmares;
import com.gmail.sneakdevs.nightmares.item.eggs.ExampleSpawnEgg;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NightmaresItems {

	// Spawn Eggs
	public static ExampleSpawnEgg LITTLE_GREMLIN_SPAWN_EGG = item(new ExampleSpawnEgg(EntityRegistry.LITTLE_GREMLIN_ENTITY),
			"little_gremlin_spawn_egg");

	static <T extends Item> T item(T c, String id) {
		Registry.register(Registry.ITEM, new Identifier(Nightmares.MODID, id), c);
		return c;
	}

	static <T extends Item> T item(String id, T c) {
		Registry.register(Registry.ITEM, new Identifier(Nightmares.MODID, id), c);
		return c;
	}
}