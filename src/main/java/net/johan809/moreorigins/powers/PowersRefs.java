package net.johan809.moreorigins.powers;

import io.github.apace100.origins.power.Power;
import io.github.apace100.origins.power.PowerType;
import io.github.apace100.origins.power.PowerTypeReference;
import net.minecraft.util.Identifier;
import net.johan809.moreorigins.MoreOrigins;

public class PowersRefs {
    public static final PowerType<Power> NIGHT_MONSTER = new PowerTypeReference<>(
            new Identifier(MoreOrigins.MODID, "night_monster"));
    public static final PowerType<Power> HOSTILE_BEING = new PowerTypeReference<>(
    		new Identifier(MoreOrigins.MODID, "hostile_being"));
    public static final PowerType<Power> WITHER_AMOR = new PowerTypeReference<>(
    		new Identifier(MoreOrigins.MODID, "wither_armor"));
    public static final PowerType<Power> WITHER_FLIGHT = new PowerTypeReference<>(
            new Identifier(MoreOrigins.MODID, "wither_flight"));
}
