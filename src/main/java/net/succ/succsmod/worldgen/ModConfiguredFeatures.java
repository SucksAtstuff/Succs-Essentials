package net.succ.succsmod.worldgen;

// Import statements for necessary classes from Minecraft and SuccsMod
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    // Define ResourceKeys for custom configured features (Atherium ore and Deepslate Atherium ore)
    public static final ResourceKey<ConfiguredFeature<?,?>> ATHERIUM_ORE_KEY = registerKey("atherium_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEEPSLATE_ATHERIUM_ORE_KEY = registerKey("deepslate_atherium_ore");

    // Method to register configured features during the bootstrap phase
    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        // Define RuleTests for blocks that can be replaced by ores
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Define target block states for Atherium ores
        List<OreConfiguration.TargetBlockState> atheriumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.ATHERIUM_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_ATHERIUM_ORE.get().defaultBlockState())
        );

        // Register Atherium ore configured feature
        register(context, ATHERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(atheriumOres, 2));

        // Register Deepslate Atherium ore configured feature
        register(context, DEEPSLATE_ATHERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(atheriumOres, 1));
    }

    // Utility method to create a ResourceKey for a ConfiguredFeature using the mod ID and a given name
    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SuccsMod.MOD_ID, name));
    }

    // Method to register a ConfiguredFeature with the given key, feature, and configuration
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?,?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
