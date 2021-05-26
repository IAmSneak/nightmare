package io.dandin87.monstermash.util;

import io.dandin87.monstermash.util.packets.EntityPacket;
import io.dandin87.monstermash.util.packets.EntityPacketOnClient;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class ClientPacketRegister {
	public static void register() {
		ClientSidePacketRegistry.INSTANCE.register(EntityPacket.ID, (ctx, buf) -> {
            EntityPacketOnClient.onPacket(ctx, buf);
        });
	}
}
