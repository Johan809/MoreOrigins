package net.johan809.moreorigins.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.johan809.moreorigins.powers.PowersRefs;

@Mixin(IronGolemEntity.class)
public abstract class IronGolemEntityMixin extends GolemEntity {

  public IronGolemEntityMixin(EntityType<? extends IronGolemEntity> type, World world) {
    super(type, world);
  }

  @Inject(method = "initGoals", at = @At("HEAD"), cancellable = true)
  protected void addEnemyPlayerTracking(CallbackInfo ci) {
    targetSelector.add(3,
        new FollowTargetGoal<>(this, PlayerEntity.class, 5, true, false, PowersRefs.NIGHT_MONSTER::isActive));
  }
}