package net.johan809.moreorigins.status;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class DragonSoulStatusEffect extends StatusEffect {
    private int DURATION = 0;

    public DragonSoulStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.DURATION = duration;
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, this.DURATION, 2, false, false, false));
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, this.DURATION, 1, false, false, false));
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, this.DURATION, 0, false, false, false));
        }
    }
}
