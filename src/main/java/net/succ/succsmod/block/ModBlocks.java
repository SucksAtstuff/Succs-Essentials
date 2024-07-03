package net.succ.succsmod.block;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.custom.GemPolishingTableBlock;
import net.succ.succsmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    // Create a DeferredRegister for blocks, using the mod ID
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SuccsMod.MOD_ID);

    // Register the Atherium Ore block with properties copied from Ancient Debris and custom sound and experience drop
    public static final RegistryObject<Block> ATHERIUM_ORE = registerBlock("atherium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    // Register the Deepslate Atherium Ore block with properties copied from Ancient Debris and custom sound and experience drop
    public static final RegistryObject<Block> DEEPSLATE_ATHERIUM_ORE = registerBlock("deepslate_atherium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    // Register the Nether Atherium Ore block with properties copied from Ancient Debris and custom sound and experience drop
    public static final RegistryObject<Block> NETHER_ATHERIUM_ORE = registerBlock("nether_atherium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    // Register the End Atherium Ore block with properties copied from Ancient Debris and custom sound and experience drop
    public static final RegistryObject<Block> END_ATHERIUM_ORE = registerBlock("end_atherium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    // Register the Atherium Block with properties copied from Ancient Debris and custom sound
    public static final RegistryObject<Block> ATHERIUM_BLOCK = registerBlock("atherium_block",
            () -> new Block(Block.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.AMETHYST)));


    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> END_RUBY_ORE = registerBlock("end_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(Block.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.AMETHYST)));

public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> END_SAPPHIRE_ORE = registerBlock("end_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> SUNSTONE_ORE = registerBlock("sunstone_ore",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> DEEPSLATE_SUNSTONE_ORE = registerBlock("deepslate_sunstone_ore",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> NETHER_SUNSTONE_ORE = registerBlock("nether_sunstone_ore",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> END_SUNSTONE_ORE = registerBlock("end_sunstone_ore",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> SUNSTONE_BLOCK = registerBlock("sunstone_block",
            () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GEM_POLISHING_TABLE = registerBlock("gem_polishing_table",
            () -> new GemPolishingTableBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE).noOcclusion()));


    // Generic method to register a block and its corresponding item
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Method to register the BlockItem for a given block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
