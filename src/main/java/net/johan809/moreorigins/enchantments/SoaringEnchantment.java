package net.johan809.moreorigins.enchantments;

import net.johan809.moreorigins.register.GeneralRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;

public class SoaringEnchantment extends Enchantment {
	public SoaringEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ElytraItem;
	}

	public int getMaxLevel() {
		return 3;
	}

	public int getMinPower(int level) {
		return 8 + level * 5;
	}

	public int getMaxPower(int level) {
		return this.getMaxPower(level) + 8;
	}

	public boolean isTreasure() {
		return true;
	}

	protected boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != GeneralRegister.WIND_CATCHER_ENCHANTMENT;
	}
}
