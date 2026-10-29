package net.johan809.moreorigins.powers;

import net.minecraft.entity.LivingEntity;

public class PowersRefs {
	// Command tags kept in sync by their powers (see data/moreorigins/powers),
	// so the mod doesn't need to compile against Origins/Apoli
	public static final String NIGHT_MONSTER_TAG = "moreorigins.night_monster";
	public static final String PIGLIN_NEUTRALITY_TAG = "moreorigins.piglin_neutrality";

	public static boolean isNightMonster(LivingEntity entity) {
		return entity.getCommandTags().contains(NIGHT_MONSTER_TAG);
	}

	public static boolean hasPiglinNeutrality(LivingEntity entity) {
		return entity.getCommandTags().contains(PIGLIN_NEUTRALITY_TAG);
	}
}
