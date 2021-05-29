package com.gmail.sneakdevs.nightmares.goals;

import com.gmail.sneakdevs.nightmares.Nightmares;
import com.gmail.sneakdevs.nightmares.mixin.PlayerEntityMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;

public class PhaseTargetGoal extends Goal {
    private final BlockView world;
    private final MobEntity mob;
    private LivingEntity target;

    public PhaseTargetGoal(MobEntity mob) {
        this.mob = mob;
        this.world = mob.world;
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null) {
            return false;
        } else {
            this.target = livingEntity;
            System.out.println("clipfh");
            return true;
        }
    }

    public boolean shouldContinue() {
        if (this.target.isAlive() && this.mob.getY() + 10 <= this.target.getY()) {
            return true;
        }
        return false;
    }

    public void stop() {
        Nightmares.canNoClip = false;
        System.out.println("clipn't");
        this.target = null;
        this.mob.getNavigation().stop();
    }

    public void tick() {
        if (this.target.isAlive() && this.mob.getY() + 10 <= this.target.getY()) {
            Nightmares.canNoClip = true;
        } else {
            Nightmares.canNoClip = false;
        }
    }
}
