package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;
import net.succ.succsmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    // Constructor for ModBlockTagGenerator, takes PackOutput, CompletableFuture for HolderLookup.Provider,
    // and an optional ExistingFileHelper as parameters
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SuccsMod.MOD_ID, existingFileHelper);
    }

    // Override method to add custom block tags
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Atherium blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ATHERIUM_BLOCK.get())
                .add(ModBlocks.ATHERIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get());

        // Add Atherium blocks to the "needs netherite tool" tag
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ATHERIUM_BLOCK.get())
                .add(ModBlocks.ATHERIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get());

        // Add a custom tag for blocks that need Atherium tools
        this.tag(ModTags.Blocks.NEEDS_ATHERIUM_TOOL);
    }
}
