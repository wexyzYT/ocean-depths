package w3xyz.oceandepths.oceandepths.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class BonkfishEntity extends SchoolingFishEntity implements GeoEntity {
	public AnimatableInstanceCache cashe = new SingletonAnimatableInstanceCache(this);
	public int variant;  // Added this line

	public BonkfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.variant = this.random.nextInt(4);  // Randomly choose one of 4 variants
	}
	public int getVariant() {
		return this.variant;
	}
	public static DefaultAttributeContainer.Builder setAttributes() {
		return SchoolingFishEntity.createAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 10D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2f)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2f)
				.add(EntityAttributes.GENERIC_ATTACK_SPEED, 1f);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));
		this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
		this.goalSelector.add(2, new FleeEntityGoal(this, PlayerEntity.class, 8.0F, 1.6, 1.4));

		this.targetSelector.add(2, new TargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new TargetGoal<>(this, SchoolingFishEntity.class, true));
		this.targetSelector.add(4, new TargetGoal<>(this, DolphinEntity.class, true));
		this.targetSelector.add(3, new TargetGoal<>(this, TropicalFishEntity.class, true));
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_COD_HURT;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_COD_AMBIENT;
	}

	@Override
	public ItemStack getBucketItem() {
		return null;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "controller", 0, this::predicate)
				.triggerableAnim("attack", RawAnimation.begin().then("animation.bonkfish.attack", Animation.LoopType.PLAY_ONCE)));
	}

	@Override
	public boolean tryAttack(Entity target) {
		this.triggerAnim("controller", "attack");
		return super.tryAttack(target);
	}

	private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
		if(tAnimationState.isMoving()){
			tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.bonkfish.swim", Animation.LoopType.LOOP));
			return PlayState.CONTINUE; // Added this line to return PlayState.CONTINUE when the entity is moving.
		}

		tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.bonkfish.swim", Animation.LoopType.LOOP));

		return PlayState.CONTINUE; // Moved this line outside the if statement to ensure it always returns a PlayState.
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cashe;
	}
}
