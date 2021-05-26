package io.dandin87.monstermash.item.eggs;

import io.dandin87.monstermash.Nightmares;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class ExampleSpawnEgg extends SpawnEggItem {

	public ExampleSpawnEgg(EntityType<?> type) {
		super(type, 11022961, 11035249, new Item.Settings().maxCount(1).group(Nightmares.ExampleEggItemGroup));
	}

}