package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft and SuccsMod
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.succ.succsmod.datagen.loot.ModBlockLootTables;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {

    // Method to create a LootTableProvider for the mod
    public static LootTableProvider create(PackOutput output) {
        // Return a new LootTableProvider with the specified output, no additional conditions, and a list of sub-provider entries
        return new LootTableProvider(output, Set.of(), List.of(
                // Add a sub-provider entry for block loot tables, using ModBlockLootTables and the BLOCK context parameter set
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
