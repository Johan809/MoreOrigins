package net.johan809.moreorigins.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.johan809.moreorigins.register.GeneralRegister;
import net.minecraft.entity.attribute.EntityAttributeInstance;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow
    @Nullable
    public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute atribute);

    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    public void addGlidingSpeed(CallbackInfo ci) {
        if ((EnchantmentHelper.getLevel(GeneralRegister.SOARING_ENCHANTMENT,
                this.getEquippedStack(EquipmentSlot.CHEST)) >= 1)) {
            this.getAttributeInstance(EntityAttributes.GENERIC_FLYING_SPEED).setBaseValue(20 + EnchantmentHelper
                    .getLevel(GeneralRegister.SOARING_ENCHANTMENT, this.getEquippedStack(EquipmentSlot.CHEST)));
        }
    }

    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    public void sustractGlidingSpeed(CallbackInfo ci) {
        if ((EnchantmentHelper.getLevel(GeneralRegister.WIND_CATCHER_ENCHANTMENT,
                this.getEquippedStack(EquipmentSlot.CHEST))) >= 1) {
            this.getAttributeInstance(EntityAttributes.GENERIC_FLYING_SPEED).setBaseValue(-10 - EnchantmentHelper
                    .getLevel(GeneralRegister.SOARING_ENCHANTMENT, this.getEquippedStack(EquipmentSlot.CHEST)));
        }
    }
}
