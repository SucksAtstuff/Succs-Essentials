package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft and SuccsMod
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;
import net.succ.succsmod.datagen.custom.GemPolishingRecipeBuilder;
import net.succ.succsmod.item.ModItems;
import net.succ.succsmod.recipe.GemPolishingRecipe;
import net.succ.succsmod.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // List of smeltable Atherium ores
    public static final List<ItemLike> ATHERIUM_SMELTABLES = List.of(ModBlocks.ATHERIUM_ORE.get(), ModBlocks.DEEPSLATE_ATHERIUM_ORE.get(), ModBlocks.NETHER_ATHERIUM_ORE.get(), ModBlocks.END_ATHERIUM_ORE.get());
    public static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.NETHER_RUBY_ORE.get(), ModBlocks.END_RUBY_ORE.get());
    public static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModBlocks.END_SAPPHIRE_ORE.get());
    public static final List<ItemLike> SUNSTONE_SMELTABLES = List.of(ModBlocks.SUNSTONE_ORE.get(), ModBlocks.DEEPSLATE_SUNSTONE_ORE.get(), ModBlocks.NETHER_SUNSTONE_ORE.get(), ModBlocks.END_SUNSTONE_ORE.get());

    // Constructor for the ModRecipeProvider class
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    // Method to build and register all recipes
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Register smelting and blasting recipes for Atherium ores
        oreBlasting(pWriter, ATHERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ATHERIUM.get(), 0.25f, 100, "atherium");
        oreSmelting(pWriter, ATHERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ATHERIUM.get(), 0.25f, 200, "atherium");

        // Register smelting and blasting recipes for Ruby ores
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");

        // Register smelting and blasting recipes for Sapphire ores
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");

        // Register smelting and blasting recipes for Sunstone ores
        oreBlasting(pWriter, SUNSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.SUNSTONE.get(), 0.25f, 100, "sunstone");
        oreSmelting(pWriter, SUNSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.SUNSTONE.get(), 0.25f, 200, "sunstone");

        // Register recipe for crafting the Gem Polishing Table
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_POLISHING_TABLE.get(), 1)
                .pattern("QQQ")
                .pattern("BIB")
                .pattern("BBB")
                .define('Q', Items.QUARTZ_BLOCK)
                .define('I', Items.IRON_INGOT)
                .define('B', Items.BLACKSTONE)
                .unlockedBy(getHasName(Items.QUARTZ_BLOCK), has(Items.QUARTZ_BLOCK))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                .save(pWriter);

        // Register gem polishing recipes
        new GemPolishingRecipeBuilder(ModItems.DIRTY_RUBY.get(), ModItems.RUBY.get(), 1, 240, new FluidStack(Fluids.WATER, 500))
                .unlockedBy("has_ruby", has(ModItems.RUBY.get())).save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_SAPPHIRE.get(), ModItems.SAPPHIRE.get(), 1, 160, new FluidStack(Fluids.WATER, 250))
                .unlockedBy("has_sapphire", has(ModItems.SAPPHIRE.get())).save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_ATHERIUM.get(), ModItems.ATHERIUM.get(), 1, 400, new FluidStack(Fluids.WATER, 1000))
                .unlockedBy("has_atherium", has(ModItems.ATHERIUM.get())).save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_SUNSTONE.get(), ModItems.SUNSTONE.get(), 1, 160, new FluidStack(Fluids.WATER, 250))
                .unlockedBy("has_sunstone", has(ModItems.SUNSTONE.get())).save(pWriter);

        // Register shapeless recipe for crafting Atherium
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ATHERIUM.get(), 1)
                .requires(ModItems.SUNSTONE.get(), 3)
                .requires(ModItems.RUBY.get(), 3)
                .requires(ModItems.SAPPHIRE.get(), 3)
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter, "atherium_crafting");

        // Register shapeless recipe to convert Atherium Block back to Atherium items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ATHERIUM.get(), 9)
                .requires(ModBlocks.ATHERIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ATHERIUM_BLOCK.get()), has(ModBlocks.ATHERIUM_BLOCK.get()))
                .save(pWriter, "atherium_block_to_atherium");

        // Register shaped recipe for Atherium Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ATHERIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ATHERIUM.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Gold Handle
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_HANDLE.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern(" G ")
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(pWriter);

        // Register shaped recipe for Atherium Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_HAMMER.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.ATHERIUM.get())
                .define('S', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Paxel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_PAXEL.get())
                .pattern("ASP")
                .pattern(" G ")
                .pattern(" G ")
                .define('A', ModItems.ATHERIUM_AXE.get())
                .define('P', ModItems.ATHERIUM_PICKAXE.get())
                .define('S', ModItems.ATHERIUM_SHOVEL.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);



        // Register shaped recipe for Ruby Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("RRR")
                .pattern(" G ")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("RR ")
                .pattern("RG ")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern(" R ")
                .pattern(" G ")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("RR ")
                .pattern(" G ")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Ruby Block back to Ruby items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_PICKAXE.get())
                .pattern("HHH")
                .pattern(" G ")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_AXE.get())
                .pattern("HH ")
                .pattern("HG ")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SHOVEL.get())
                .pattern(" H ")
                .pattern(" G ")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HOE.get())
                .pattern("HH ")
                .pattern(" G ")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SWORD.get())
                .pattern(" H ")
                .pattern(" H ")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Sapphire Block back to Sapphire items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Sunstone Block back to Sunstone items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUNSTONE.get(), 9)
                .requires(ModBlocks.SUNSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SUNSTONE_BLOCK.get()), has(ModBlocks.SUNSTONE_BLOCK.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUNSTONE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SUNSTONE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" G ")
                .pattern(" G ")
                .define('S', ModItems.SUNSTONE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_AXE.get())
                .pattern("SS ")
                .pattern("SG ")
                .pattern(" G ")
                .define('S', ModItems.SUNSTONE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" G ")
                .pattern(" G ")
                .define('S', ModItems.SUNSTONE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_HOE.get())
                .pattern("SS ")
                .pattern(" G ")
                .pattern(" G ")
                .define('S', ModItems.SUNSTONE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" G ")
                .define('S', ModItems.SUNSTONE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);
    }

    // Helper method to register smelting recipes for ores
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    // Helper method to register blasting recipes for ores
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    // General helper method to register cooking recipes (both smelting and blasting)
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SuccsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
