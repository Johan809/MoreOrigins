package net.johan809.moreorigins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.johan809.moreorigins.register.GeneralRegister;
import net.johan809.moreorigins.register.LootRegister;

public class MoreOrigins implements ModInitializer {
	public static final String MODID = "moreorigins";

	public static Identifier id(String path) {
		return Identifier.of(MODID, path);
	}

	@Override
	public void onInitialize() {
		GeneralRegister.register();
		LootRegister.registerLootTables();

		ItemGroup oceaniteArmorGroup = FabricItemGroup.builder()
				.icon(() -> new ItemStack(GeneralRegister.OCEANITE))
				.displayName(Text.translatable("itemGroup.moreorigins.oceanite_armor_group"))
				.entries((context, entries) -> {
					entries.add(GeneralRegister.OCEANITE);
					entries.add(GeneralRegister.OCEANITE_HELMET);
					entries.add(GeneralRegister.OCEANITE_CHESTPLATE);
					entries.add(GeneralRegister.OCEANITE_LEGGINGS);
					entries.add(GeneralRegister.OCEANITE_BOOTS);
				})
				.build();
		Registry.register(Registries.ITEM_GROUP, id("oceanite_armor_group"), oceaniteArmorGroup);
	}
}
