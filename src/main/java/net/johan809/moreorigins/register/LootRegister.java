package net.johan809.moreorigins.register;

import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetNbtLootFunction;
import net.minecraft.nbt.CompoundTag;

public class LootRegister {
    private static final Identifier END_CITY = new Identifier("minecraft", "chests/end_city_treasure");

    private static CompoundTag createEnchantmentTag(Enchantment enchantment, int level) {
        EnchantmentLevelEntry entry = new EnchantmentLevelEntry(enchantment, level);
        return EnchantedBookItem.forEnchantment(entry).getTag();
    }

    public static void registerLootTables() {
        CompoundTag soaringLevel1 = createEnchantmentTag(GeneralRegister.SOARING_ENCHANTMENT, 1);
        CompoundTag soaringLevel2 = createEnchantmentTag(GeneralRegister.SOARING_ENCHANTMENT, 2);
        CompoundTag soaringLevel3 = createEnchantmentTag(GeneralRegister.SOARING_ENCHANTMENT, 3);
        CompoundTag windCatcherLevel1 = createEnchantmentTag(GeneralRegister.SOARING_ENCHANTMENT, 1);

        LootTableLoadingCallback.EVENT
                .register(((resourceManager, lootManager, identifier, fabricLootSupplierBuilder, lootTableSetter) -> {
                    if (END_CITY.equals(identifier)) {
                        FabricLootPoolBuilder lootPool = FabricLootPoolBuilder.builder()
                                .rolls(ConstantLootTableRange.create(1))
                                .with(ItemEntry.builder(Items.ENCHANTED_BOOK).weight(20)
                                        .apply(SetNbtLootFunction.builder(soaringLevel1)))
                                .with(ItemEntry.builder(Items.ENCHANTED_BOOK).weight(10)
                                        .apply(SetNbtLootFunction.builder(soaringLevel2)))
                                .with(ItemEntry.builder(Items.ENCHANTED_BOOK).weight(5)
                                        .apply(SetNbtLootFunction.builder(soaringLevel3)))
                                .with(ItemEntry.builder(Items.ENCHANTED_BOOK).weight(10)
                                        .apply(SetNbtLootFunction.builder(windCatcherLevel1)))
                                .with(EmptyEntry.Serializer().weight(75));
                        fabricLootSupplierBuilder.withPool(lootPool.build());
                    }
                }));
    }
}
