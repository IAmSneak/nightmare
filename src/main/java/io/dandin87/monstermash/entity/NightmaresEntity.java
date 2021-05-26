package io.dandin87.monstermash.entity;

import io.dandin87.monstermash.util.packets.EntityPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

@SuppressWarnings("ALL")
public class NightmaresEntity extends HostileEntity {

	protected NightmaresEntity(EntityType<? extends HostileEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}

}