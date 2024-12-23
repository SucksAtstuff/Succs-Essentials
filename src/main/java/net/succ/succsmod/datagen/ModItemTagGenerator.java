package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft and Forge
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.item.ModItems;
import net.succ.succsmod.util.ModTags;
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
        // Add Armour to "TRIMMABLE_ARMOR" tag
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ATHERIUM_HELMET.get())
                .add(ModItems.ATHERIUM_CHESTPLATE.get())
                .add(ModItems.ATHERIUM_LEGGINGS.get())
                .add(ModItems.ATHERIUM_BOOTS.get())
                .add(ModItems.RUBY_HELMET.get())
                .add(ModItems.RUBY_CHESTPLATE.get())
                .add(ModItems.RUBY_LEGGINGS.get())
                .add(ModItems.RUBY_BOOTS.get())
                .add(ModItems.SAPPHIRE_HELMET.get())
                .add(ModItems.SAPPHIRE_CHESTPLATE.get())
                .add(ModItems.SAPPHIRE_LEGGINGS.get())
                .add(ModItems.SAPPHIRE_BOOTS.get())
                .add(ModItems.SUNSTONE_HELMET.get())
                .add(ModItems.SUNSTONE_CHESTPLATE.get())
                .add(ModItems.SUNSTONE_LEGGINGS.get())
                .add(ModItems.SUNSTONE_BOOTS.get())
                .add(ModItems.MALACHITE_HELMET.get())
                .add(ModItems.MALACHITE_CHESTPLATE.get())
                .add(ModItems.MALACHITE_LEGGINGS.get())
                .add(ModItems.MALACHITE_BOOTS.get());



        // Inside your pickaxe item class or item registry
        this.tag(ModTags.Items.SUNSTONE_SAPPHIRE_TOOLS)
                .add(ModItems.SUNSTONE_PICKAXE.get())
                .add(ModItems.SAPPHIRE_PICKAXE.get());

    }
}
