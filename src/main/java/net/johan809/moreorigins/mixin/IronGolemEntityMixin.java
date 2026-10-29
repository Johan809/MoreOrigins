package net.johan809.moreorigins.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.johan809.moreorigins.powers.PowersRefs;
import net.minecraft.entity.passive.IronGolemEntity;

@Mixin(IronGolemEntity.class)
public abstract class IronGolemEntityMixin extends GolemEntity {

	protected IronGolemEntityMixin(EntityType<? extends GolemEntity> type, World world) {
		super(type, world);
	}

	@Inject(method = "initGoals", at = @At("TAIL"))
	private void addEnemyPlayerTracking(CallbackInfo ci) {
		this.targetSelector.add(3,
				new ActiveTargetGoal<>(this, PlayerEntity.class, 5, true, false, PowersRefs::isNightMonster));
	}
}
