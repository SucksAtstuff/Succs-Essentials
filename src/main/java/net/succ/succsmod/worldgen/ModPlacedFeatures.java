package net.succ.succsmod.worldgen;

// Import statements for necessary classes from Minecraft and SuccsMod
import net.succ.succsmod.SuccsMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    // Define ResourceKeys for custom placed features (Atherium ore and Deepslate Atherium ore)
    public static final ResourceKey<PlacedFeature> ATHERIUM_ORE_PLACED_KEY = registerKey("atherium_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_ATHERIUM_ORE_PLACED_KEY = registerKey("deepslate_atherium_ore_placed");

    // Method to register placed features during the bootstrap phase
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        // Get a HolderGetter to lookup ConfiguredFeatures
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register Atherium ore placed feature with its configuration and placement modifiers
        // Atherium Ore is most common around Y level 13 (range from 6 to 20)
        register(context, ATHERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ATHERIUM_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (2 veins per chunk for Atherium ore)
                ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(6), VerticalAnchor.absolute(20))));

        // Register Deepslate Atherium ore placed feature with its configuration and placement modifiers
        // Deepslate Atherium Ore is most common around Y level -6 (range from -20 to 8)
        register(context, DEEPSLATE_ATHERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_ATHERIUM_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (1 veins per chunk for Deepslate Atherium ore)
                ModOrePlacement.commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(8))));
    }

    // Utility method to create a ResourceKey for a PlacedFeature using the mod ID and a given name
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SuccsMod.MOD_ID, name));
    }

    // Method to register a PlacedFeature with the given key, configuration, and placement modifiers
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
