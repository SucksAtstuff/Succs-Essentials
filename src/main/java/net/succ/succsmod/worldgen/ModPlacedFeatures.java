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

    // Define ResourceKeys for custom placed features (Atherium ore, Deepslate Atherium ore, Ruby ore, and Deepslate Ruby ore)
    public static final ResourceKey<PlacedFeature> END_ATHERIUM_ORE_PLACED_KEY = registerKey("end_atherium_ore_placed");

    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed");

    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_SAPPHIRE_ORE_PLACED_KEY = registerKey("deepslate_sapphire_ore_placed");

    public static final ResourceKey<PlacedFeature> SUNSTONE_ORE_PLACED_KEY = registerKey("sunstone_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_SUNSTONE_ORE_PLACED_KEY = registerKey("deepslate_sunstone_ore_placed");

    public static final ResourceKey<PlacedFeature> MALACHITE_ORE_PLACED_KEY = registerKey("malachite_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_MALACHITE_ORE_PLACED_KEY = registerKey("deepslate_malachite_ore_placed");



    // Method to register placed features during the bootstrap phase
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        // Get a HolderGetter to lookup ConfiguredFeatures
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register End Atherium ore placed feature with its configuration and placement modifiers
        // End Atherium Ore is most common around Y level 8 (range from -32 to 32)
        register(context, END_ATHERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ATHERIUM_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (3 veins per chunk for End Atherium ore)
                ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));


        // Register Nether Ruby ore placed feature with its configuration and placement modifiers
        // Nether Ruby Ore is most common around Y level 60 (range from 40 to 80)
        register(context, NETHER_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (5 veins per chunk for Ruby ore)
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(40), VerticalAnchor.absolute(80))));


        // Register Sapphire ore placed feature with its configuration and placement modifiers
        // Sapphire Ore is most common around Y level 36 (range from 8 to 64)
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (5 veins per chunk for Sapphire ore)
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(64))));

        // Register Deepslate Sapphire ore placed feature with its configuration and placement modifiers
        // Deepslate Sapphire Ore is most common around Y level -28 (range from -64 to 8)
        register(context, DEEPSLATE_SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SAPPHIRE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (3 veins per chunk for Deepslate Sapphire ore)
                ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));

        // Register Sapphire ore placed feature with its configuration and placement modifiers
        // Sapphire Ore is most common around Y level 36 (range from 8 to 64)
        register(context, SUNSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (5 veins per chunk for Sapphire ore)
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(64))));

        // Register Deepslate Sapphire ore placed feature with its configuration and placement modifiers
        // Deepslate Sapphire Ore is most common around Y level -28 (range from -64 to 8)
        register(context, DEEPSLATE_SUNSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SUNSTONE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (3 veins per chunk for Deepslate Sapphire ore)
                ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));

        // Register Malachite ore placed feature with its configuration and placement modifiers
        // Malachite Ore is most common around Y level 36 (range from 8 to 64)
        register(context, MALACHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MALACHITE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (5 veins per chunk for Malachite ore)
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(64))));

        // Register Deepslate Malachite ore placed feature with its configuration and placement modifiers
        // Deepslate Malachite Ore is most common around Y level -28 (range from -64 to 8)
        register(context, DEEPSLATE_MALACHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_MALACHITE_ORE_KEY),
                // pCount represents the number of ore veins to generate per chunk (3 veins per chunk for Deepslate Malachite ore)
                ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));




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
