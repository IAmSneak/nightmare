package io.dandin87.monstermash.util.registry;

import io.dandin87.monstermash.Nightmares;
import io.dandin87.monstermash.item.eggs.ExampleSpawnEgg;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NightmaresItems {

	// Spawn Eggs

	public static ExampleSpawnEgg LITTLE_GREMLIN_SPAWN_EGG = item(new ExampleSpawnEgg(MobEntityRegister.LITTLE_GREMLIN),
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