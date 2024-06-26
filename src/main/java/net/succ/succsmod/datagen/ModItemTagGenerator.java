package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft and Forge
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.succ.succsmod.SuccsMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    // Constructor for ModItemTagGenerator, takes PackOutput, CompletableFuture for HolderLookup.Provider,
    // CompletableFuture for TagLookup<Block>, and an optional ExistingFileHelper as parameters
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, SuccsMod.MOD_ID, existingFileHelper);
    }

    // Override method to add custom item tags
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Custom item tags should be added here
    }
}
