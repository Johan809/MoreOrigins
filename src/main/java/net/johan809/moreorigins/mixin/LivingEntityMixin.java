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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.johan809.moreorigins.register.GeneralRegister;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	// Extra acceleration along the look direction, per tick and per Soaring level
	private static final double SOARING_BOOST = 0.004;
	// Extra drag per tick while Wind Catcher is on
	private static final double WIND_CATCHER_DRAG = 0.985;

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
		if (soaring > 0) {
			Vec3d look = self.getRotationVector();
			self.setVelocity(self.getVelocity().add(look.multiply(SOARING_BOOST * soaring)));
		}

		if (getEnchantmentLevel(self, GeneralRegister.WIND_CATCHER_ENCHANTMENT) > 0) {
			self.setVelocity(self.getVelocity().multiply(WIND_CATCHER_DRAG));
		}
	}

	private static int getEnchantmentLevel(LivingEntity entity, RegistryKey<Enchantment> key) {
		return entity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntry(key)
				.map(enchantment -> EnchantmentHelper.getEquipmentLevel(enchantment, entity))
				.orElse(0);
	}
}
