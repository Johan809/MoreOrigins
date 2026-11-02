package net.johan809.moreorigins.effects;

import net.johan809.moreorigins.MoreOrigins;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

// Granted to Dragonborns when they kill an enderman. Its faster Dragon's Breath
// recharge lives in data/moreorigins/powers/dragon_breath.json
public class DragonSoulStatusEffect extends StatusEffect {
	public DragonSoulStatusEffect() {
		super(StatusEffectCategory.BENEFICIAL, 0xB43CE6);
		this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, MoreOrigins.id("effect.dragon_soul"), 2.0,
				EntityAttributeModifier.Operation.ADD_VALUE);
	}
}
