package io.dandin87.monstermash.util.registry;

import io.dandin87.monstermash.util.ModSoundEvents;

public class ModRegistry {

	public static ModSoundEvents SOUNDS;
	public static NightmaresItems ITEMS;
	public static MobEntityRegister MOBS;

	public static void init() {

		ITEMS = new NightmaresItems();
		SOUNDS = new ModSoundEvents();
		MOBS = new MobEntityRegister();

	}
}