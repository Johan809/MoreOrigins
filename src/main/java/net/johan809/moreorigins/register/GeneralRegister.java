package net.johan809.moreorigins.register;

import net.johan809.moreorigins.MoreOrigins;
import net.johan809.moreorigins.items.OceaniteItem;
import net.johan809.moreorigins.materials.OceaniteArmorMaterial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public class GeneralRegister {
	public static final RegistryEntry<ArmorMaterial> OCEANITE_ARMOR_MATERIAL = OceaniteArmorMaterial.register();

	public static final Item OCEANITE = new OceaniteItem(new Item.Settings());
	public static final Item OCEANITE_HELMET = oceaniteArmor(ArmorItem.Type.HELMET);
	public static final Item OCEANITE_CHESTPLATE = oceaniteArmor(ArmorItem.Type.CHESTPLATE);
	public static final Item OCEANITE_LEGGINGS = oceaniteArmor(ArmorItem.Type.LEGGINGS);
	public static final Item OCEANITE_BOOTS = oceaniteArmor(ArmorItem.Type.BOOTS);

	// Enchantments are data-driven since 1.21, see data/moreorigins/enchantment
	public static final RegistryKey<Enchantment> SOARING_ENCHANTMENT = enchantmentKey("soaring");
	public static final RegistryKey<Enchantment> WIND_CATCHER_ENCHANTMENT = enchantmentKey("wind_catcher");

	private static Item oceaniteArmor(ArmorItem.Type type) {
		return new ArmorItem(OCEANITE_ARMOR_MATERIAL, type,
				new Item.Settings().maxDamage(type.getMaxDamage(OceaniteArmorMaterial.DURABILITY_MULTIPLIER)));
	}

	private static RegistryKey<Enchantment> enchantmentKey(String path) {
		return RegistryKey.of(RegistryKeys.ENCHANTMENT, MoreOrigins.id(path));
	}

	public static void register() {
		Registry.register(Registries.ITEM, MoreOrigins.id("oceanite"), OCEANITE);
		Registry.register(Registries.ITEM, MoreOrigins.id("oceanite_helmet"), OCEANITE_HELMET);
		Registry.register(Registries.ITEM, MoreOrigins.id("oceanite_chestplate"), OCEANITE_CHESTPLATE);
		Registry.register(Registries.ITEM, MoreOrigins.id("oceanite_leggings"), OCEANITE_LEGGINGS);
		Registry.register(Registries.ITEM, MoreOrigins.id("oceanite_boots"), OCEANITE_BOOTS);
	}
}
