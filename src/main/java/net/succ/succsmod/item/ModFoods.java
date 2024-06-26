package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    // Define the FoodProperties for ROCK_CANDY
    public static final FoodProperties ROCK_CANDY = (new FoodProperties.Builder()
            // Set the nutrition value (hunger restored) to 1
            .nutrition(1)
            // Make the food consume quickly
            .fast()
            // Set the saturation modifier to 0.1F (how much saturation is restored)
            .saturationMod(0.1F)
            // Add an effect that grants a speed boost for 200 ticks (10 seconds) at level 5, with a 100% chance
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 5), 1.0f)
            // Build the FoodProperties instance
            .build());
}
