package io.dandin87.monstermash.entity;

import io.dandin87.monstermash.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

@SuppressWarnings("ALL")
public class LittleGremlinEntity extends NightmaresEntity implements IAnimatable {
	private static TrackedData<Boolean> SHOOTING;

	private AnimationFactory factory = new AnimationFactory(this);

	public LittleGremlinEntity(EntityType<? extends NightmaresEntity> type, World worldIn)
	{
		super(type, worldIn);
		this.ignoreCameraFrustum = true;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.little_gremlin.arms", true));
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.little_gremlin.munch", true));
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.little_gremlin.walking", true));
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
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(5, new LookAroundGoal(this));
		this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.8D));
		this.goalSelector.add(5, new AttackGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, HostileEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, true));
	}

	protected void initDataTracker() {
		super.initDataTracker();
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