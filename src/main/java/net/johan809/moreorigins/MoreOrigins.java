package net.johan809.moreorigins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.johan809.moreorigins.register.GeneralRegister;

public class MoreOrigins implements ModInitializer {
		
	public static final String MODID = "moreorigins";
	
	public static final ItemGroup OCEANITE_ARMOR_GROUP = FabricItemGroupBuilder
			.create(new Identifier(MODID, "oceanite_armor_group"))
			.icon(() -> new ItemStack(GeneralRegister.OCEANITE)).build();

	@Override
	public void onInitialize() {
		GeneralRegister.register();
	}
}
