package net.johan809.moreorigins.register;

import net.johan809.moreorigins.MoreOrigins;
import net.johan809.moreorigins.items.OceaniteItem;
import net.johan809.moreorigins.materials.OceaniteArmorMaterial;
import net.johan809.moreorigins.status.DragonSoulStatusEffect;
import net.johan809.moreorigins.status.WitherShieldStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GeneralRegister {
    private static final Settings settings = new Item.Settings().group(MoreOrigins.OCEANITE_ARMOR_GROUP);
    
    public static final StatusEffect DRAGON_SOUL = new DragonSoulStatusEffect();
    public static final StatusEffect WITHER_SHIELD = new WitherShieldStatusEffect();
    public static final ArmorMaterial OCEANITE_ARMOR_MATERIAL = new OceaniteArmorMaterial();
    
    public static final Item OCEANITE = new OceaniteItem(settings);
    public static final Item OCEANITE_HELMET = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.HEAD, settings);
    public static final Item OCEANITE_CHESTPLATE = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.CHEST, settings);
    public static final Item OCEANITE_LEGGINGS = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.LEGS, settings);
    public static final Item OCEANITE_BOOTS = new ArmorItem(OCEANITE_ARMOR_MATERIAL, EquipmentSlot.FEET, settings);

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite"), OCEANITE);
        Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_helmet"), OCEANITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_chestplate"), OCEANITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_leggings"), OCEANITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MoreOrigins.MODID, "oceanite_boots"), OCEANITE_BOOTS);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreOrigins.MODID, "dragonsoul"), DRAGON_SOUL);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreOrigins.MODID, "wither_shield"), WITHER_SHIELD);
    }
}