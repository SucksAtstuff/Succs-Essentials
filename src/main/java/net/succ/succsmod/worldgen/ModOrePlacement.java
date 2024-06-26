package net.succ.succsmod.worldgen;

// Import statements for necessary classes from the Minecraft world generation and placement packages
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {

    // Method to create a list of placement modifiers for ores
    // Takes two placement modifiers as parameters
    // Adds additional modifiers for in-square placement and biome filtering
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    // Method to create common ore placements
    // pCount specifies the number of veins per chunk
    // pHeightRange specifies the height range for ore placement
    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        // Calls orePlacement with CountPlacement and the given height range
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    // Method to create rare ore placements
    // pChance specifies the average number of chunks between ore veins
    // pHeightRange specifies the height range for ore placement
    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        // Calls orePlacement with RarityFilter and the given height range
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
