package net.johan809.moreorigins.register;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

public class LootRegister {
	private static LeafEntry.Builder<?> enchantedBook(RegistryWrapper.WrapperLookup registries,
			RegistryKey<Enchantment> enchantment, int level, int weight) {
		return ItemEntry.builder(Items.BOOK).weight(weight)
				.apply(new SetEnchantmentsLootFunction.Builder().enchantment(
						registries.getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(enchantment),
						ConstantLootNumberProvider.create(level)));
	}

	public static void registerLootTables() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (source.isBuiltin() && LootTables.END_CITY_TREASURE_CHEST.equals(key)) {
				LootPool.Builder lootPool = LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
						.with(enchantedBook(registries, GeneralRegister.SOARING_ENCHANTMENT, 1, 20))
						.with(enchantedBook(registries, GeneralRegister.SOARING_ENCHANTMENT, 2, 10))
						.with(enchantedBook(registries, GeneralRegister.SOARING_ENCHANTMENT, 3, 5))
						.with(enchantedBook(registries, GeneralRegister.WIND_CATCHER_ENCHANTMENT, 1, 10))
						.with(EmptyEntry.builder().weight(75));

				tableBuilder.pool(lootPool);
			}
		});
	}
}
