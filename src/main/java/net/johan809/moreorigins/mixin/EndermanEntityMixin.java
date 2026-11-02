package net.johan809.moreorigins.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.johan809.moreorigins.powers.PowersRefs;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin extends HostileEntity {

	protected EndermanEntityMixin(EntityType<? extends HostileEntity> type, World world) {
		super(type, world);
	}

	// Endermen go after Dragonborns on sight, not only when looked at
	@Inject(method = "initGoals", at = @At("TAIL"))
	private void addDragonbornTracking(CallbackInfo ci) {
		this.targetSelector.add(1,
				new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, PowersRefs::isHuntedByTheEnd));
	}
}
