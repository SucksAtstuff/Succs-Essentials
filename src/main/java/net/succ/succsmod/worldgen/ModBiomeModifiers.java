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
    }

    // Utility method to create a ResourceKey for a BiomeModifier using the mod ID and a given name
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SuccsMod.MOD_ID, name));
    }
}
