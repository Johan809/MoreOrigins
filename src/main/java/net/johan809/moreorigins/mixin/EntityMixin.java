package net.johan809.moreorigins.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.johan809.moreorigins.register.GeneralRegister;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Inject(method = "isInvulnerableTo", at = @At(value = "HEAD", target = "net/minecraft/entity/Entity.isInvulnerableTo(Lnet/minecraft/entity/damage/DamageSource;)Z"), cancellable = true)
	public void dmgInvulnerability(PlayerEntity player, DamageSource damage, CallbackInfoReturnable<Boolean> cir) {
		if(damage.isProjectile() && player.hasStatusEffect(GeneralRegister.WITHER_SHIELD)) {
			cir.setReturnValue(true);
		}
	}
}