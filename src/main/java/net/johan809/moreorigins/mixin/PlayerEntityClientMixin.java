package net.johan809.moreorigins.mixin;

import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityClientMixin extends LivingEntity implements SkinOverlayOwner {
	protected PlayerEntityClientMixin(EntityType<? extends LivingEntity> entType, World world) {
		super(entType, world);
	}
}
