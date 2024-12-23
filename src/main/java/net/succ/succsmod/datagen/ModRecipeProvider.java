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
    public static final List<ItemLike> MALACHITE_SMELTABLES = List.of(ModBlocks.MALACHITE_ORE.get(), ModBlocks.DEEPSLATE_MALACHITE_ORE.get());

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

        // Register smelting and blasting recipes for Malachite ores
        oreBlasting(pWriter, MALACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE.get(), 0.25f, 100, "malachite");
        oreSmelting(pWriter, MALACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE.get(), 0.25f, 200, "malachite");

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
                .unlockedBy(getHasName(ModItems.DIRTY_RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_SAPPHIRE.get(), ModItems.SAPPHIRE.get(), 1, 160, new FluidStack(Fluids.WATER, 250))
                .unlockedBy(getHasName(ModItems.DIRTY_SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_ATHERIUM.get(), ModItems.ATHERIUM.get(), 1, 400, new FluidStack(Fluids.WATER, 1000))
                .unlockedBy(getHasName(ModItems.DIRTY_ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_SUNSTONE.get(), ModItems.SUNSTONE.get(), 1, 160, new FluidStack(Fluids.WATER, 250))
                .unlockedBy(getHasName(ModItems.DIRTY_SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        new GemPolishingRecipeBuilder(ModItems.DIRTY_MALACHITE.get(), ModItems.MALACHITE.get(), 1, 160, new FluidStack(Fluids.WATER, 750))
                .unlockedBy(getHasName(ModItems.DIRTY_MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);


        // Register shapeless recipe to convert Atherium Block back to Atherium items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ATHERIUM.get(), 9)
                .requires(ModBlocks.ATHERIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ATHERIUM_BLOCK.get()), has(ModBlocks.ATHERIUM_BLOCK.get()))
                .save(pWriter, SuccsMod.MOD_ID + ":" + "atherium_block_to_atherium");

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

        // Register shaped recipe for Atherium Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.ATHERIUM.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ATHERIUM.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ATHERIUM.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shaped recipe for Atherium Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATHERIUM_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ATHERIUM.get())
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

        // Register shaped recipe for Ruby Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HAMMER.get())
                .pattern("RRR")
                .pattern("RGR")
                .pattern(" G ")
                .define('R', ModItems.RUBY.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Paxel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PAXEL.get())
                .pattern("ASP")
                .pattern(" G ")
                .pattern(" G ")
                .define('A', ModItems.RUBY_AXE.get())
                .define('S', ModItems.RUBY_SHOVEL.get())
                .define('P', ModItems.RUBY_PICKAXE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.ATHERIUM.get()), has(ModItems.ATHERIUM.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Ruby Block back to Ruby items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HELMET.get())
                .pattern("RRR")
                .pattern("R R")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_CHESTPLATE.get())
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_LEGGINGS.get())
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        // Register shaped recipe for Ruby Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_BOOTS.get())
                .pattern("R R")
                .pattern("R R")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
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

        // Register shaped recipe for Sapphire Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HAMMER.get())
                .pattern("HHH")
                .pattern("HGH")
                .pattern(" G ")
                .define('H', ModItems.SAPPHIRE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Paxel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_PAXEL.get())
                .pattern("ASP")
                .pattern(" G ")
                .pattern(" G ")
                .define('A', ModItems.SAPPHIRE_AXE.get())
                .define('S', ModItems.SAPPHIRE_SHOVEL.get())
                .define('P', ModItems.SAPPHIRE_PICKAXE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Sapphire Block back to Sapphire items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HELMET.get())
                .pattern("HHH")
                .pattern("H H")
                .define('H', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_CHESTPLATE.get())
                .pattern("H H")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_LEGGINGS.get())
                .pattern("HHH")
                .pattern("H H")
                .pattern("H H")
                .define('H', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        // Register shaped recipe for Sapphire Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_BOOTS.get())
                .pattern("H H")
                .pattern("H H")
                .define('H', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
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

        // Register shaped recipe for Sunstone Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_HAMMER.get())
                .pattern("HHH")
                .pattern("HSH")
                .pattern(" G ")
                .define('H', ModItems.SUNSTONE.get())
                .define('S', ModItems.SUNSTONE_SHOVEL.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Paxel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_PAXEL.get())
                .pattern("ASP")
                .pattern(" G ")
                .pattern(" G ")
                .define('A', ModItems.SAPPHIRE_AXE.get())
                .define('S', ModItems.SAPPHIRE_SHOVEL.get())
                .define('P', ModItems.SUNSTONE_PICKAXE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define('S', ModItems.SUNSTONE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SUNSTONE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.SUNSTONE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shaped recipe for Sunstone Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNSTONE_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.SUNSTONE.get())
                .unlockedBy(getHasName(ModItems.SUNSTONE.get()), has(ModItems.SUNSTONE.get()))
                .save(pWriter);

        // Register shapeless recipe to convert Malachite Block back to Malachite items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MALACHITE.get(), 9)
                .requires(ModBlocks.MALACHITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MALACHITE_BLOCK.get()), has(ModBlocks.MALACHITE_BLOCK.get()))
                .save(pWriter);
        
        // Register shaped recipe for Malachite Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MALACHITE_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MALACHITE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register the shaped recipe for Malachite Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_SWORD.get())
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" G ")
                .define('M', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register the shaped recipe for Malachite Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_PICKAXE.get())
                .pattern("MMM")
                .pattern(" G ")
                .pattern(" G ")
                .define('M', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register the shaped recipe for Malachite Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_AXE.get())
                .pattern("MM ")
                .pattern("MG ")
                .pattern(" G ")
                .define('M', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register the shaped recipe for Malachite Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_SHOVEL.get())
                .pattern(" M ")
                .pattern(" G ")
                .pattern(" G ")
                .define('M', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register the shaped recipe for Malachite Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_HOE.get())
                .pattern("MM ")
                .pattern(" G ")
                .pattern(" G ")
                .define('M', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register shaped recipe for Malachite Hammer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_HAMMER.get())
                .pattern("HHH")
                .pattern("HGH")
                .pattern(" G ")
                .define('H', ModItems.MALACHITE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);

        // Register shaped recipe for Malachite Paxel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MALACHITE_PAXEL.get())
                .pattern("ASP")
                .pattern(" G ")
                .pattern(" G ")
                .define('A', ModItems.MALACHITE_AXE.get())
                .define('S', ModItems.MALACHITE_SHOVEL.get())
                .define('P', ModItems.MALACHITE_PICKAXE.get())
                .define('G', ModItems.GOLD_HANDLE.get())
                .unlockedBy(getHasName(ModItems.MALACHITE.get()), has(ModItems.MALACHITE.get()))
                .save(pWriter);


        // Register shapeless recipe for Garlic Bread
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GARLIC_BREAD.get(), 1)
                .requires(Items.BREAD)
                .requires(ModItems.GARLIC.get())
                .unlockedBy(getHasName(ModItems.GARLIC.get()), has(ModItems.GARLIC.get()))
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
