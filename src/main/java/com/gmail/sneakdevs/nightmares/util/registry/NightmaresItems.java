package com.gmail.sneakdevs.nightmares.util.registry;

import com.gmail.sneakdevs.nightmares.Nightmares;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NightmaresItems {

	public static void init(){
		Registry.register(Registry.ITEM, new Identifier(Nightmares.MODID, "little_gremlin_spawn_egg"), new SpawnEggItem(EntityRegistry.LITTLE_GREMLIN_ENTITY, 7368557, 10120456, new Item.Settings().group(ItemGroup.MISC)));
	}

}