package net.johan809.moreorigins.powers;

import io.github.apace100.origins.power.Power;
import io.github.apace100.origins.power.PowerType;
import io.github.apace100.origins.power.PowerTypeReference;
import net.minecraft.util.Identifier;
import net.johan809.moreorigins.MoreOrigins;

public class PowersRefs {
    public static final PowerType<Power> NIGHT_MONSTER = new PowerTypeReference<>(
            new Identifier(MoreOrigins.MODID, "night_monster"));
}
