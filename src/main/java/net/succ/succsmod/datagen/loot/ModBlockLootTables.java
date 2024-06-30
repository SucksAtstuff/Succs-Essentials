package net.succ.succsmod.datagen.loot;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.block.ModBlocks;
import net.succ.succsmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    // Constructor for ModBlockLootTables
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Define loot tables for blocks that drop themselves
        this.dropSelf(ModBlocks.ATHERIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());

        // Define loot tables for ore blocks that drop items similar to diamond ores
        this.add(ModBlocks.ATHERIUM_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.ATHERIUM_ORE.get(), ModItems.ATHERIUM.get()));

        this.add(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get(), ModItems.ATHERIUM.get()));

        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));

        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        // Define loot tables for ore blocks that drop items similar to copper ores
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

    }

    // Helper method to create loot tables for ores that drop like diamond ores
    protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    // Helper method to create loot tables for ores that drop like copper ores
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Return an iterable of all known blocks in the mod
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
