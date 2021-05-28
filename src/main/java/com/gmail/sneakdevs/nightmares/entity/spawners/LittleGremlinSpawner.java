package com.gmail.sneakdevs.nightmares.entity.spawners;

import java.util.Iterator;
import java.util.Random;

import com.gmail.sneakdevs.nightmares.entity.entity.LittleGremlinEntity;
import com.gmail.sneakdevs.nightmares.util.registry.EntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.gen.Spawner;

public class LittleGremlinSpawner {

    public LittleGremlinSpawner() {
    }

    public void spawnGremlin(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals) {
        Random random = world.random;
        Iterator var6 = world.getPlayers().iterator();

        LocalDifficulty localDifficulty;
        BlockPos blockPos2;

        BlockPos blockPos;

        PlayerEntity playerEntity = (PlayerEntity)var6.next();

        blockPos = playerEntity.getBlockPos();

        localDifficulty = world.getLocalDifficulty(blockPos);

        blockPos2 = blockPos.up(400).east(-10 + random.nextInt(21)).south(-10 + random.nextInt(21));
        EntityData entityData = null;

        LittleGremlinEntity phantomEntity = (LittleGremlinEntity) EntityRegistry.LITTLE_GREMLIN_ENTITY.create(world);
        phantomEntity.refreshPositionAndAngles(blockPos2, 0.0F, 0.0F);
        entityData = phantomEntity.initialize(world, localDifficulty, SpawnReason.NATURAL, entityData, (CompoundTag)null);
        world.spawnEntityAndPassengers(phantomEntity);

    }
}
