package io.dandin87.monstermash.entity;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import io.dandin87.monstermash.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import java.util.Random;

@SuppressWarnings("ALL")
public class LittleGremlinEntity extends NightmaresEntity implements IAnimatedEntity {
	private static TrackedData<Boolean> SHOOTING;

	EntityAnimationManager manager = new EntityAnimationManager();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	EntityAnimationController controller = new EntityAnimationController(this, "walkController", 5,
			this::animationPredicate);

	public LittleGremlinEntity(EntityType<LittleGremlinEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		manager.addAnimationController(controller);
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (this.dataTracker.get(SHOOTING)){
			System.out.println("Attacking");
			controller.setAnimation(new AnimationBuilder().addAnimation("attack", true));
			return true;
		}
		if (!(lastLimbDistance > -0.15F && this.lastLimbDistance < 0.15F)) {
			System.out.println("Walking");
			controller.setAnimation(new AnimationBuilder().addAnimation("walk", true));
			return true;
		}
		return false;
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(6, new LookAroundGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.goalSelector.add(6, new AttackGoal(this));
		this.goalSelector.add(7, new LittleGremlinEntity.ShootFireballGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, HostileEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, true));
	}


	@Environment(EnvType.CLIENT)
	public boolean isShooting() {
		return (Boolean)this.dataTracker.get(SHOOTING);
	}

	public void setShooting(boolean shooting) {
		this.dataTracker.set(SHOOTING, shooting);
	}

	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOTING, false);
	}

	static {
		SHOOTING = DataTracker.registerData(LittleGremlinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	}

	static class ShootFireballGoal extends Goal {
		private final LittleGremlinEntity pumpkin;
		public int cooldown;

		public ShootFireballGoal(LittleGremlinEntity pumpkin) {
			this.pumpkin = pumpkin;
		}

		public boolean canStart() {
			return this.pumpkin.getTarget() != null;
		}

		public void start() {
			this.cooldown = 0;
		}

		public void stop() {
			this.pumpkin.setShooting(false);
		}

		public void tick() {
			LivingEntity livingEntity = this.pumpkin.getTarget();
			double d = 64.0D;
			if (livingEntity.squaredDistanceTo(this.pumpkin) < 4096.0D && this.pumpkin.canSee(livingEntity)) {
				World world = this.pumpkin.world;
				++this.cooldown;
				if (this.cooldown == 10 && !this.pumpkin.isSilent()) {
					world.syncWorldEvent((PlayerEntity)null, 1015, this.pumpkin.getBlockPos(), 0);
				}

				if (this.cooldown == 40) {
					double e = 4.0D;
					Vec3d vec3d = this.pumpkin.getRotationVec(1.0F);
					double f = livingEntity.getX() - (this.pumpkin.getX() + vec3d.x * 4.0D);
					double g = livingEntity.getBodyY(0.5D) - (0.5D + this.pumpkin.getBodyY(0.5D));
					double h = livingEntity.getZ() - (this.pumpkin.getZ() + vec3d.z * 4.0D);
					if (!this.pumpkin.isSilent()) {
						world.syncWorldEvent((PlayerEntity)null, 1016, this.pumpkin.getBlockPos(), 0);
					}

					FireballEntity fireballEntity = new FireballEntity(world, this.pumpkin, f, g, h);
					fireballEntity.updatePosition(this.pumpkin.getX() + vec3d.x * 4.0D, this.pumpkin.getBodyY(0.5D) + 0.5D, fireballEntity.getZ() + vec3d.z * 4.0D);
					world.spawnEntity(fireballEntity);
					this.cooldown = -80;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}

			this.pumpkin.setShooting(this.cooldown > 10);
		}
	}


	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8D).add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.0D);
	}

	public static boolean spawning(EntityType<LittleGremlinEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
                                   BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}


	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 1.0F;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.LITTLE_GREMLIN_IDLE_EVENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.LITTLE_GREMLIN_DEATH_EVENT;
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.LITTLE_GREMLIN_IDLE_EVENT;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}
}