package net.succ.succsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.item.ModItems;
import net.succ.succsmod.loot.AddItemModifier;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, SuccsMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("rock_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build() }, ModItems.ROCK.get()));

        add("garlic_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.GARLIC.get()));

        add("garlic_from_tall_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.GARLIC.get()));

        // Define an array of all dungeon chest loot tables
        ResourceLocation[] dungeonChestLootTables = new ResourceLocation[] {
                new ResourceLocation("minecraft", "chests/simple_dungeon"),
                new ResourceLocation("minecraft", "chests/stronghold_corridor"),
                new ResourceLocation("minecraft", "chests/nether_bridge"),
                new ResourceLocation("minecraft", "chests/bastion_treasure"),
                new ResourceLocation("minecraft", "chests/end_city_treasure"),
                new ResourceLocation("minecraft", "chests/abandoned_mineshaft")
        };

        // Loop over each dungeon chest loot table and add all rings and bracelet to each one
        for (ResourceLocation lootTable : dungeonChestLootTables) {
            // Add Ring of Ruby
            add("ring_of_ruby_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.RING_OF_RUBY.get()));

            // Add Ring of Sapphire
            add("ring_of_sapphire_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.RING_OF_SAPPHIRE.get()));

            // Add Ring of Sunstone
            add("ring_of_sunstone_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.RING_OF_SUNSTONE.get()));

            // Add Ring of Atherium
            add("ring_of_atherium_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.RING_OF_ATHERIUM.get()));

            // Add Bracelet of Malachite
            add("bracelet_of_malachite_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.BRACELET_OF_MALACHITE.get()));

            // Add Necklace of Amethyst
            add("necklace_of_amethyst_in_" + lootTable.getPath(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(lootTable).build(),
                    LootItemRandomChanceCondition.randomChance(0.01f).build()
            }, ModItems.NECKLACE_OF_AMETHYST.get()));
        }
    }
}

