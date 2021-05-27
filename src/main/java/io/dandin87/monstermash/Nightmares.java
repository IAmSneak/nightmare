package io.dandin87.monstermash;

import io.dandin87.monstermash.util.MobAttributes;
import io.dandin87.monstermash.util.MobSpawn;
import io.dandin87.monstermash.util.ModSoundEvents;
import io.dandin87.monstermash.util.registry.NightmaresItems;
import io.dandin87.monstermash.util.registry.EntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class Nightmares implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger();
	public static boolean DISABLE_IN_DEV = false;
	boolean isDevelopmentEnvironment = FabricLoader.getInstance().isDevelopmentEnvironment();
	public static NightmaresItems ITEMS;
	public static EntityRegistry MOBS;
	public static final String MODID = "nightmares";
	public static final ItemGroup ExampleEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(NightmaresItems.LITTLE_GREMLIN_SPAWN_EGG)).build();

	@Override
	public void onInitialize() {

		GeckoLib.initialize();
		if (isDevelopmentEnvironment && !Nightmares.DISABLE_IN_DEV) {
			new EntityRegistry();
			FabricDefaultAttributeRegistry.register(EntityRegistry.LITTLE_GREMLIN_ENTITY,
					EntityUtils.createGenericEntityAttributes());
		}
		ITEMS = new NightmaresItems();
		MOBS = new EntityRegistry();
		ModSoundEvents.init();
		MobSpawn.addSpawnEntries();
		MobAttributes.init();
		System.out.println("Your worst fears have come true");

	}
}
