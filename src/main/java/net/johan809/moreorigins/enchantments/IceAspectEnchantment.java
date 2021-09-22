package net.johan809.moreorigins.enchantments;

import net.johan809.moreorigins.register.GeneralRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class IceAspectEnchantment extends Enchantment {
	public IceAspectEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public int getMinPower(int level) {
		return 10 + 20 * (level - 1);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean isAvailableForEnchantedBookOffer() {
		return true;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			((LivingEntity) target)
					.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3 * level, level - 1));
		}

		super.onTargetDamaged(user, target, level);
	}

	@Override
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != Enchantments.FIRE_ASPECT
				&& other != GeneralRegister.WITHER_ASPECT_ENCHANTMENT;
	}
}
