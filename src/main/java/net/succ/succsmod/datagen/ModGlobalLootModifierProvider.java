package net.succ.succsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
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

        add("ring_of_ruby_from_chest", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.01f).build() }, ModItems.RING_OF_RUBY.get()));

        add("ring_of_sapphire_from_chest", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.01f).build() }, ModItems.RING_OF_SAPPHIRE.get()));

        add("ring_of_sunstone_from_chest", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.01f).build() }, ModItems.RING_OF_SUNSTONE.get()));

        add("ring_of_atherium_from_chest", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.01f).build() }, ModItems.RING_OF_ATHERIUM.get()));

        add("bracelet_of_malachite", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.01f).build() }, ModItems.BRACELET_OF_MALACHITE.get()));
        }



    }

