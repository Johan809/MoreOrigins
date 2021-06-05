package net.johan809.moreorigins.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.johan809.moreorigins.powers.PowersRefs;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {

  @Inject(method = "interactMob", at = @At(value = "INVOKE"), cancellable = true)
  public void preventTrading(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
    if (PowersRefs.NIGHT_MONSTER.isActive(player)) {
    	cir.setReturnValue(ActionResult.FAIL);
    }
  }
}