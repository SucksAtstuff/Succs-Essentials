package net.succ.succsmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ROCK_CANDY = (new FoodProperties.Builder().nutrition(1).fast()
               .saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 5), 1f).build());

}