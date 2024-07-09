package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.succ.succsmod.SuccsMod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SuccsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    // Method to gather data for the mod, annotated to be subscribed to the GatherDataEvent
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Retrieve the DataGenerator instance from the event
        DataGenerator generator = event.getGenerator();
        // Get the PackOutput from the DataGenerator
        PackOutput packOutput = generator.getPackOutput();
        // Get the ExistingFileHelper from the event, used for existing files reference
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        // Get the CompletableFuture for HolderLookup.Provider, used for registry lookups
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Add recipe provider to the data generator for server-side data
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        // Add loot table provider to the data generator for server-side data
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        BlockTagsProvider blockTagsProvider = new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // Add block state provider to the data generator for client-side data
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        // Add item model provider to the data generator for client-side data
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        // Add item tag generator to the data generator for server-side data, dependent on block tag generator
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        // Add world generation provider to the data generator for server-side data
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));

        // Add painting variant tag provider to the data generator for client-side data
        generator.addProvider(event.includeClient(), new ModPaintingVariantTagProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModGlobalLootModifierProvider(packOutput));

        event.getGenerator().addProvider(
                // Tell generator to run only when server data are generating
                event.includeServer(),
                new CuriosProvider(
                        SuccsMod.MOD_ID,
                        event.getGenerator().getPackOutput(),
                        event.getExistingFileHelper(),
                        event.getLookupProvider()
                )
        );
    }
}
