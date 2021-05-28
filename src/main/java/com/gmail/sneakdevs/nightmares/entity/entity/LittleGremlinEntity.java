package com.gmail.sneakdevs.nightmares.entity.entity;

import com.gmail.sneakdevs.nightmares.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


@SuppressWarnings("all")
public class LittleGremlinEntity extends NightmaresEntity implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);

	public LittleGremlinEntity(EntityType<? extends NightmaresEntity> type, World worldIn)
	{
		super(type, worldIn);
		this.ignoreCameraFrustum = true;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.little_gremlin.walk", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data)
	{
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory()
	{
		return this.factory;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(2, new FleeEntityGoal(this, SpiderEntity.class, 10.0F, 1.0D, 1.2D));
		this.goalSelector.add(1, new SwimGoal(this));
		this.goalSelector.add(3, new AttackGoal(this));
		this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
		this.targetSelector.add(4, new RevengeGoal(this, new Class[0]));
		this.targetSelector.add(3, new FollowTargetGoal(this, PlayerEntity.class, false));
	}

	protected void initDataTracker() {
		super.initDataTracker();
	}

	public void tick() {
		if (!this.world.isClient && world.getTimeOfDay() == 167500) {
			this.kill();
		}

		super.tick();
	}

	public boolean canImmediatelyDespawn(double distanceSquared) {
		return false;
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 500.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6D).add(EntityAttributes.GENERIC_MAX_HEALTH, 5000.0D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 40.0D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.0D)
				.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5F);
	}

	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {

		if (fallDistance > 30 && !this.world.isClient && world.getTimeOfDay() >= 156500) {
			Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.BREAK : Explosion.DestructionType.NONE;
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 12.0F, destructionType);
		}

		return false;
	}

	public void writeCustomDataToTag(CompoundTag tag) {
		super.writeCustomDataToTag(tag);
	}

	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 1.1F;
	}

	@Override
	public boolean canFly() {
		return true;
	}

	protected boolean shouldDrown() {
		return false;
	}

	@Override
	public boolean isFireImmune() {
		return true;
	}

	@Override
	public boolean canBreatheInWater() {
		return true;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	//Sounds
	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.LITTLE_GREMLIN_IDLE_EVENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.LITTLE_GREMLIN_DEATH_EVENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.LITTLE_GREMLIN_HURT_EVENT;
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.LITTLE_GREMLIN_IDLE_EVENT;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

}