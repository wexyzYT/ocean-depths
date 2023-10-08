package w3xyz.oceandepths.oceandepths.entity.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
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
	public BonkfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
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
		controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
	}

	private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
		if(tAnimationState.isMoving()){
			tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.bonkfish.swim", Animation.LoopType.LOOP));
		}
		tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.bonkfish.swim", Animation.LoopType.LOOP));



		return PlayState.CONTINUE;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cashe;
	}
}
