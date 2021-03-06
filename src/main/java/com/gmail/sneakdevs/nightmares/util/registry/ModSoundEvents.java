package com.gmail.sneakdevs.nightmares.util.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

	//Little Gremlin
	public static final Identifier LITTLE_GREMLIN_IDLE = new Identifier("nightmares:little_gremlin_idle");
	public static final Identifier LITTLE_GREMLIN_DEATH = new Identifier("nightmares:little_gremlin_death");
	public static final Identifier LITTLE_GREMLIN_HURT = new Identifier("nightmares:little_gremlin_hurt");
	public static SoundEvent LITTLE_GREMLIN_IDLE_EVENT = new SoundEvent(LITTLE_GREMLIN_IDLE);
	public static SoundEvent LITTLE_GREMLIN_DEATH_EVENT = new SoundEvent(LITTLE_GREMLIN_DEATH);
	public static SoundEvent LITTLE_GREMLIN_HURT_EVENT = new SoundEvent(LITTLE_GREMLIN_HURT);

	public static void init(){
		Registry.register(Registry.SOUND_EVENT, ModSoundEvents.LITTLE_GREMLIN_IDLE, LITTLE_GREMLIN_IDLE_EVENT);
		Registry.register(Registry.SOUND_EVENT, ModSoundEvents.LITTLE_GREMLIN_DEATH, LITTLE_GREMLIN_DEATH_EVENT);
		Registry.register(Registry.SOUND_EVENT, ModSoundEvents.LITTLE_GREMLIN_HURT, LITTLE_GREMLIN_HURT_EVENT);
	}

}