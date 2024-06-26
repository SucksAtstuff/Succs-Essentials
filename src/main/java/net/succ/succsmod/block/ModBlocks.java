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

    // Register the Atherium Block with properties copied from Ancient Debris and custom sound
    public static final RegistryObject<Block> ATHERIUM_BLOCK = registerBlock("atherium_block",
            () -> new Block(Block.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.AMETHYST)));

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
