package net.johan809.moreorigins.enchantments;

import net.johan809.moreorigins.register.GeneralRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.EquipmentSlot;

public class WindCatcherEnchantment extends Enchantment {
	public WindCatcherEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() == Items.ELYTRA;
	}

	public int getMaxLevel() {
		return 1;
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

	@Override
	protected boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != GeneralRegister.SOARING_ENCHANTMENT;
	}
}
