package net.johan809.moreorigins.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.johan809.moreorigins.powers.PowersRefs;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {

	// Piglins treat the player as if wearing gold; brutes don't check this, so they still attack
	@Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
	private static void piglinNeutrality(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		if (PowersRefs.hasPiglinNeutrality(entity)) {
			cir.setReturnValue(true);
		}
	}
}
