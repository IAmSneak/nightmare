package com.gmail.sneakdevs.nightmares.item.eggs;

import com.gmail.sneakdevs.nightmares.Nightmares;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class ExampleSpawnEgg extends SpawnEggItem {

	public ExampleSpawnEgg(EntityType<?> type) {
		super(type, 11022961, 11035249, new Item.Settings().maxCount(64).group(Nightmares.ExampleEggItemGroup));
	}

}