package io.dandin87.monstermash;

import io.dandin87.monstermash.util.MobAttributes;
import io.dandin87.monstermash.util.MobSpawn;
import io.dandin87.monstermash.util.ModSoundEvents;
import io.dandin87.monstermash.util.registry.NightmaresItems;
import io.dandin87.monstermash.util.registry.MobEntityRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Nightmares implements ModInitializer {

	public static NightmaresItems ITEMS;
	public static MobEntityRegister MOBS;
	public static final String MODID = "nightmares";
	public static final ItemGroup ExampleEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(NightmaresItems.LITTLE_GREMLIN_SPAWN_EGG)).build();

	@Override
	public void onInitialize() {

		ITEMS = new NightmaresItems();
		MOBS = new MobEntityRegister();
		ModSoundEvents.init();
		MobSpawn.addSpawnEntries();
		MobAttributes.init();
		System.out.println("Your worst fears have come true");
	}
}
