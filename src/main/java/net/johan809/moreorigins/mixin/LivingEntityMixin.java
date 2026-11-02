package net.johan809.moreorigins.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.johan809.moreorigins.register.GeneralRegister;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	// While gliding level, vanilla elytras sink with a quarter of the gravity; Soaring cancels
	// this fraction of that sink per level (level III: 75%), so you stay in the air longer.
	// It fades out as you pitch up or down, so diving still works as usual
	private static final double SOARING_LIFT_PER_LEVEL = 0.25;
	private static final double ELYTRA_LEVEL_SINK = 0.25;
	// Air brake: velocity kept per tick while sneaking with Wind Catcher (about half a second to halve speed)
	private static final double WIND_CATCHER_BRAKE = 0.93;

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "tickMovement", at = @At("TAIL"))
	private void modifyGlidingSpeed(CallbackInfo ci) {
		LivingEntity self = (LivingEntity) (Object) this;
		if (!self.isFallFlying()) {
			return;
		}

		int soaring = getEnchantmentLevel(self, GeneralRegister.SOARING_ENCHANTMENT);
		if (soaring > 0 && self.getVelocity().y < 0) {
			double cosPitch = Math.cos(Math.toRadians(self.getPitch()));
			double lift = self.getFinalGravity() * ELYTRA_LEVEL_SINK * cosPitch * cosPitch
					* Math.min(1, SOARING_LIFT_PER_LEVEL * soaring);
			self.setVelocity(self.getVelocity().add(0, lift, 0));
		}

		// Its fall and crash protection is in data/moreorigins/enchantment/wind_catcher.json
		if (self.isSneaking() && getEnchantmentLevel(self, GeneralRegister.WIND_CATCHER_ENCHANTMENT) > 0) {
			self.setVelocity(self.getVelocity().multiply(WIND_CATCHER_BRAKE));
		}
	}

	private static int getEnchantmentLevel(LivingEntity entity, RegistryKey<Enchantment> key) {
		return entity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntry(key)
				.map(enchantment -> EnchantmentHelper.getEquipmentLevel(enchantment, entity))
				.orElse(0);
	}
}
