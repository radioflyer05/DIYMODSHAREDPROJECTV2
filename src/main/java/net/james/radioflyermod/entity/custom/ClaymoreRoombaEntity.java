package net.james.radioflyermod.entity.custom;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Collection;
import java.util.List;

public class ClaymoreRoombaEntity extends Monster implements IAnimatable {
    private int explosionRadius = 3;
    private static final EntityDataAccessor<Boolean> DATA_IS_POWERED = SynchedEntityData.defineId(Creeper.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = new AnimationFactory(this);

    public ClaymoreRoombaEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.robotic_chest.idle", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.robotic_chest.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if(this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.robotic_chest.attack", false));
            this.swinging = false;

        }


        return PlayState.CONTINUE;

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    @Override
    public void tick() {
        super.tick();

        // Call the explosion method when the player is near
        double playerDetectionRadius = 10.0; // Adjust this radius as needed
        Player nearestPlayer = this.level.getNearestPlayer(this, playerDetectionRadius);

        if (nearestPlayer != null) {
            double distanceToPlayer = this.distanceTo(nearestPlayer);

            if (distanceToPlayer <= playerDetectionRadius) {
                explodeNearbyPlayers();
            }
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.WOOD_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHEST_LOCKED;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BARREL_CLOSE;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CHEST_CLOSE;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    private void explodeCreeper() {
        if (!this.level.isClientSide) {
            Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            float f = this.isPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, explosion$blockinteraction);
            this.discard();
            this.spawnLingeringCloud();
        }
    }

        private void spawnLingeringCloud() {
            Collection<MobEffectInstance> collection = this.getActiveEffects();
            if (!collection.isEmpty()) {
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
                areaeffectcloud.setRadius(2.5F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(10);
                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());

                for(MobEffectInstance mobeffectinstance : collection) {
                    areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
                }

                this.level.addFreshEntity(areaeffectcloud);
            }

        }
    public boolean isPowered() {
        return this.entityData.get(DATA_IS_POWERED);
    }


    private void explodeNearbyPlayers() {
        double explosionRadius = 5.0; // Set the explosion radius as you prefer

        // Find nearby players within the explosion radius
        Level world = this.level;
        BlockPos entityPos = this.blockPosition();

        List<Player> nearbyPlayers = world.getEntitiesOfClass(Player.class,
                new AABB(entityPos.getX() - explosionRadius, entityPos.getY() - explosionRadius, entityPos.getZ() - explosionRadius,
                        entityPos.getX() + explosionRadius, entityPos.getY() + explosionRadius, entityPos.getZ() + explosionRadius));

        nearbyPlayers.forEach(player -> {
            // Create an explosion centered around the robotic chest entity
            Explosion explosion = new Explosion(world, this, entityPos.getX(), entityPos.getY(), entityPos.getZ(), (float) explosionRadius, false, Explosion.BlockInteraction.BREAK);

            // Trigger the explosion
            explosion.explode();
        });
    }
    private void createExplosionEffect() {
        // Get the particle manager from the world
        ParticleManager particleManager = this.level.getParticleManager();

        // Spawn explosion particles
        for (int i = 0; i < 100; i++) {
            double xOffset = this.random.nextGaussian() * explosionRadius;
            double yOffset = this.random.nextGaussian() * explosionRadius;
            double zOffset = this.random.nextGaussian() * explosionRadius;
            particleManager.add(ParticleTypes.EXPLOSION, this.getX() + xOffset, this.getY() + yOffset, this.getZ() + zOffset, 0.0D, 0.0D, 0.0D);
        }
    }



}



