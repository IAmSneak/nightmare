package com.gmail.sneakdevs.nightmares;

import com.gmail.sneakdevs.nightmares.entity.LittleGremlinEntity;
import com.gmail.sneakdevs.nightmares.util.ModSoundEvents;
import com.gmail.sneakdevs.nightmares.util.registry.EntityRegistry;
import com.gmail.sneakdevs.nightmares.util.registry.NightmaresItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

public class Nightmares implements ModInitializer {

	public static boolean DISABLE_IN_DEV = false;
	boolean isDevelopmentEnvironment = FabricLoader.getInstance().isDevelopmentEnvironment();
	public static final String MODID = "nightmares";
	public static final ItemGroup ExampleEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(NightmaresItems.LITTLE_GREMLIN_SPAWN_EGG)).build();

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		if (isDevelopmentEnvironment && !GeckoLibMod.DISABLE_IN_DEV) {
			new EntityRegistry();
			FabricDefaultAttributeRegistry.register(EntityRegistry.LITTLE_GREMLIN_ENTITY,
					LittleGremlinEntity.createMobAttributes());
		}

		ModSoundEvents.init();
		System.out.println("Your worst fears have come true");

	}
}
