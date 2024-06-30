package net.succ.succsmod.worldgen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.succ.succsmod.SuccsMod;

public class ModBiomeModifiers {

    // Define ResourceKeys for custom biome modifiers to add Atherium ore and Deepslate Atherium ore
    public static final ResourceKey<BiomeModifier> ADD_ATHERIUM_ORE = registerKey("add_atherium_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_ATHERIUM_ORE = registerKey("add_deepslate_atherium_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ATHERIUM_ORE = registerKey("add_nether_atherium_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_ATHERIUM_ORE = registerKey("add_end_atherium_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("add_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_RUBY_ORE = registerKey("add_deepslate_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_RUBY_ORE = registerKey("add_nether_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_RUBY_ORE = registerKey("add_end_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_SAPPHIRE_ORE = registerKey("add_deepslate_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("add_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_SAPPHIRE_ORE = registerKey("add_nether_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_SAPPHIRE_ORE = registerKey("add_end_sapphire_ore");



    // Method to register biome modifiers during the bootstrap phase
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // Get references to placed features and biomes using the context lookup
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // Register the biome modifier for adding Atherium ore to overworld biomes
        context.register(ADD_ATHERIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Atherium ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ATHERIUM_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding Deepslate Atherium ore to overworld biomes
        context.register(ADD_DEEPSLATE_ATHERIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Deepslate Atherium ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_ATHERIUM_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding Nether Atherium ore to Nether biomes
        context.register(ADD_NETHER_ATHERIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all Nether biomes
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                // Specify the placed feature to add (Nether Atherium ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_ATHERIUM_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding End Atherium ore to End biomes
        context.register(ADD_END_ATHERIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all End biomes
                biomes.getOrThrow(BiomeTags.IS_END),
                // Specify the placed feature to add (End Atherium ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_ATHERIUM_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));


        // Register the biome modifier for adding Ruby ore to overworld biomes
        context.register(ADD_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Ruby ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding Deepslate Ruby ore to overworld biomes
        context.register(ADD_DEEPSLATE_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Deepslate Ruby ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_RUBY_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding Nether Ruby ore to Nether biomes
        context.register(ADD_NETHER_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all Nether biomes
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                // Specify the placed feature to add (Nether Ruby ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_RUBY_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));



        // Register the biome modifier for adding Sapphire ore to overworld biomes
        context.register(ADD_SAPPHIRE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Sapphire ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SAPPHIRE_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Register the biome modifier for adding Deepslate Sapphire ore to overworld biomes
        context.register(ADD_DEEPSLATE_SAPPHIRE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // Specify that the modifier applies to all overworld biomes
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // Specify the placed feature to add (Deepslate Sapphire ore)
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEEPSLATE_SAPPHIRE_ORE_PLACED_KEY)),
                // Specify that the feature should be added during the underground ores generation step
                GenerationStep.Decoration.UNDERGROUND_ORES));




    }

    // Utility method to create a ResourceKey for a BiomeModifier using the mod ID and a given name
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SuccsMod.MOD_ID, name));
    }
}
