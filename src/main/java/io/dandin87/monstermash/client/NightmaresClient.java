package io.dandin87.monstermash.client;

import io.dandin87.monstermash.util.packets.EntityPacket;
import io.dandin87.monstermash.util.packets.EntityPacketOnClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

@Environment(EnvType.CLIENT)
public class NightmaresClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		NightmaresRenderRegistry.init();
		ClientSidePacketRegistry.INSTANCE.register(EntityPacket.ID, (ctx, buf) -> {
			EntityPacketOnClient.onPacket(ctx, buf);
		});
	}

}