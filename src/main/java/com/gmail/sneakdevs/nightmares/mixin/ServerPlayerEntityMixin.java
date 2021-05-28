package com.gmail.sneakdevs.nightmares.mixin;

import com.gmail.sneakdevs.nightmares.entity.spawners.LittleGremlinSpawner;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
    @Shadow
    public abstract ServerWorld getServerWorld();

    protected ServerPlayerEntityMixin(ServerWorld world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    @Inject(at = @At(value="TAIL"), method = "playerTick")
    private void tick(CallbackInfo callbackInfo) {
        ServerWorld world1 = this.getServerWorld();

        if (!this.world.isClient && this.world.getTimeOfDay() == 157000) {
            LittleGremlinSpawner spawner = new LittleGremlinSpawner();
            spawner.spawnGremlin(world1, true, true);
        }
    }
}