package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.worldgen.ModBiomeModifiers;
import net.succ.succsmod.worldgen.ModConfiguredFeatures;
import net.succ.succsmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    // Initialize a static RegistrySetBuilder to define and register custom features and biome modifiers
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            // Add the configured features to the builder, linking to the bootstrap method of ModConfiguredFeatures
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            // Add the placed features to the builder, linking to the bootstrap method of ModPlacedFeatures
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            // Add biome modifiers to the builder, linking to the bootstrap method of ModBiomeModifiers
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    // Constructor for ModWorldGenProvider
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        // Call the superclass constructor with the necessary parameters
        super(output, registries, BUILDER, Set.of(SuccsMod.MOD_ID));
    }
}
