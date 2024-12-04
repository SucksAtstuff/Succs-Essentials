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

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GEM_POLISHING_TABLE.get());

        // Add Atherium blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ATHERIUM_BLOCK.get())
                .add(ModBlocks.ATHERIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get())
                .add(ModBlocks.NETHER_ATHERIUM_ORE.get())
                .add(ModBlocks.END_ATHERIUM_ORE.get());

        // Add Ruby blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.NETHER_RUBY_ORE.get())
                .add(ModBlocks.END_RUBY_ORE.get());

        // Add Malachite blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MALACHITE_BLOCK.get())
                .add(ModBlocks.MALACHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MALACHITE_ORE.get())
                .add(ModBlocks.NETHER_MALACHITE_ORE.get())
                .add(ModBlocks.END_MALACHITE_ORE.get());

        // Add Sapphire blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.END_SAPPHIRE_ORE.get());

        // Add Sunstone blocks to the "mineable with pickaxe" tag
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SUNSTONE_BLOCK.get())
                .add(ModBlocks.SUNSTONE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUNSTONE_ORE.get())
                .add(ModBlocks.NETHER_SUNSTONE_ORE.get())
                .add(ModBlocks.END_SUNSTONE_ORE.get());

        // Add Atherium blocks to the "needs Malachite tool" tag
        this.tag(ModTags.Blocks.NEEDS_MALACHITE_TOOL)
                .add(ModBlocks.ATHERIUM_BLOCK.get())
                .add(ModBlocks.ATHERIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get())
                .add(ModBlocks.NETHER_ATHERIUM_ORE.get())
                .add(ModBlocks.END_ATHERIUM_ORE.get());

        // Add Malachite blocks to the "needs Ruby tool" tag
        this.tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .add(ModBlocks.MALACHITE_BLOCK.get())
                .add(ModBlocks.MALACHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MALACHITE_ORE.get())
                .add(ModBlocks.NETHER_MALACHITE_ORE.get())
                .add(ModBlocks.END_MALACHITE_ORE.get());

        // Add Ruby blocks and ores to a custom tag that requires Sunstone or Sapphire tools
        this.tag(ModTags.Blocks.MINEABLE_WITH_SUNSTONE_OR_SAPPHIRE)
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.NETHER_RUBY_ORE.get())
                .add(ModBlocks.END_RUBY_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)  // Use the standard NEEDS_NETHERITE_TOOL tag
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.END_SAPPHIRE_ORE.get());

        // Add Sunstone blocks to the "needs Netherite tool" tag
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)  // Use the standard NEEDS_NETHERITE_TOOL tag
                .add(ModBlocks.SUNSTONE_BLOCK.get())
                .add(ModBlocks.SUNSTONE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUNSTONE_ORE.get())
                .add(ModBlocks.NETHER_SUNSTONE_ORE.get())
                .add(ModBlocks.END_SUNSTONE_ORE.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
            .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .addTag(BlockTags.MINEABLE_WITH_AXE)
            .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        // Add a custom tag for blocks that need Atherium tools
        this.tag(ModTags.Blocks.NEEDS_ATHERIUM_TOOL);

    }
}
