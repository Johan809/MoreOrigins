package net.johan809.moreorigins.mixin;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.johan809.moreorigins.MoreOrigins;
import net.johan809.moreorigins.powers.PowersRefs;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	private static final TagKey<Item> PIGLIN_LORD_FAVORED = TagKey.of(RegistryKeys.ITEM,
			MoreOrigins.id("piglin_lord_favored"));
	// How many times faster the rest of the equipment wears out for a Piglin Lord
	private static final int GOLD_AFFINITY_WEAR_MULTIPLIER = 2;

	// Runs before Unbreaking is applied, so it still helps
	@ModifyVariable(method = "damage(ILnet/minecraft/server/world/ServerWorld;Lnet/minecraft/server/network/ServerPlayerEntity;Ljava/util/function/Consumer;)V",
			at = @At("HEAD"), argsOnly = true)
	private int goldAffinityWear(int amount, int originalAmount, ServerWorld world, @Nullable ServerPlayerEntity player,
			Consumer<Item> breakCallback) {
		ItemStack self = (ItemStack) (Object) this;
		if (amount > 0 && player != null && PowersRefs.hasGoldAffinity(player) && !self.isIn(PIGLIN_LORD_FAVORED)) {
			return amount * GOLD_AFFINITY_WEAR_MULTIPLIER;
		}
		return amount;
	}
}
