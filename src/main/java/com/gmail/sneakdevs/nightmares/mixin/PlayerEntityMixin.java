package com.gmail.sneakdevs.nightmares.mixin;

import com.gmail.sneakdevs.nightmares.Nightmares;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity
{


    public PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world)
    {
        super(type, world);

    }

    @Redirect(method = "tick", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerEntity;isSpectator()Z")
    )
    private boolean makePlayerClipThroughWorld(PlayerEntity playerEntity) {
        return playerEntity.isSpectator() || Nightmares.canNoClip;
    }

    @Redirect(method = "tickMovement", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerEntity;isSpectator()Z")
    )
    private boolean collidesWithEntitiesDDD(PlayerEntity playerEntity) {
        return playerEntity.isSpectator() || Nightmares.canNoClip;
    }

    @Redirect(method = "updateSize", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerEntity;isSpectator()Z")
    )
    private boolean spectatorsDontPoseDDD(PlayerEntity playerEntity) {
        return playerEntity.isSpectator() || Nightmares.canNoClip;
    }

}