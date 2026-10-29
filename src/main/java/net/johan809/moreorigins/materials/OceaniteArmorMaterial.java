package net.johan809.moreorigins.materials;

import java.util.EnumMap;
import java.util.List;

import net.johan809.moreorigins.MoreOrigins;
import net.johan809.moreorigins.register.GeneralRegister;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;

public class OceaniteArmorMaterial {
	public static final int DURABILITY_MULTIPLIER = 35;

	public static RegistryEntry<ArmorMaterial> register() {
		EnumMap<ArmorItem.Type, Integer> protectionValues = new EnumMap<>(ArmorItem.Type.class);
		protectionValues.put(ArmorItem.Type.BOOTS, 3);
		protectionValues.put(ArmorItem.Type.LEGGINGS, 8);
		protectionValues.put(ArmorItem.Type.CHESTPLATE, 8);
		protectionValues.put(ArmorItem.Type.HELMET, 3);
		protectionValues.put(ArmorItem.Type.BODY, 8);

		ArmorMaterial material = new ArmorMaterial(protectionValues, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				() -> Ingredient.ofItems(GeneralRegister.OCEANITE),
				List.of(new ArmorMaterial.Layer(MoreOrigins.id("oceanite"))), 2.5F, 0);

		return Registry.registerReference(Registries.ARMOR_MATERIAL, MoreOrigins.id("oceanite"), material);
	}
}
