package net.johan809.moreorigins.register;

import net.johan809.moreorigins.MoreOrigins;
import net.johan809.moreorigins.enchantments.SoaringEnchantment;
import net.johan809.moreorigins.enchantments.WindCatcherEnchantment;
import net.johan809.moreorigins.items.OceaniteItem;
import net.johan809.moreorigins.materials.OceaniteArmorMaterial;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GeneralRegister {
  private static final Settings settings = new Item.Settings().group(MoreOrigins.OCEANITE_ARMOR_GROUP);

  public static final ArmorMaterial OCEANITE_ARMOR_MATERIAL = new OceaniteArmorMaterial();

  public static final Item OCEANITE = new OceaniteItem(settings);
  public static final Item OCEANITE_HELMET = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.HEAD, settings);
  public static final Item OCEANITE_CHESTPLATE = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.CHEST, settings);
  public static final Item OCEANITE_LEGGINGS = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.LEGS, settings);
  public static final Item OCEANITE_BOOTS = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.FEET, settings);

  public static final Enchantment WIND_CATCHER_ENCHANTMENT = new WindCatcherEnchantment(Enchantment.Rarity.RARE,
      EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] { EquipmentSlot.CHEST });
  public static final Enchantment SOARING_ENCHANTMENT = new SoaringEnchantment(Enchantment.Rarity.RARE,
      EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] { EquipmentSlot.CHEST });

  public static void register() {
    Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite"), OCEANITE);
    Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_helmet"), OCEANITE_HELMET);
    Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_chestplate"), OCEANITE_CHESTPLATE);
    Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_leggings"), OCEANITE_LEGGINGS);
    Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_boots"), OCEANITE_BOOTS);
    Registry.register(Registry.ENCHANTMENT, new Identifier(MoreOrigins.MODID, "soaring"), SOARING_ENCHANTMENT);
    Registry.register(Registry.ENCHANTMENT, new Identifier(MoreOrigins.MODID, "wind_catcher"),
        WIND_CATCHER_ENCHANTMENT);
  }
}