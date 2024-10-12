package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;

public class ModCreateModeTabs {

    // Create a DeferredRegister for CreativeModeTabs, using the mod ID
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuccsMod.MOD_ID);

    // Register the custom Creative Mode Tab for the mod
    public static final RegistryObject<CreativeModeTab> SUCCS_MOD_TAB = CREATIVE_MODE_TABS.register("succsmod",
            // Create a new CreativeModeTab with specified icon, title, and displayed items
            () -> CreativeModeTab.builder()
                    // Set the icon of the Creative Mode Tab to be an Atherium item
                    .icon(() -> new ItemStack(ModItems.ATHERIUM.get()))
                    // Set the title of the Creative Mode Tab
                    .title(Component.translatable("creativetab.succs_mod_tab"))
                    // Define the items to be displayed in the Creative Mode Tab
                    .displayItems((pParameters, pOutput) -> {
                        // Add ingots and raw materials first
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_ATHERIUM.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_RUBY.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_SAPPHIRE.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_SUNSTONE.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_MALACHITE.get()));

                        // Add blocks next (ores and blocks of materials)
                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.NETHER_ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.END_ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.NETHER_RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.END_RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.RUBY_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.NETHER_SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.END_SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.SUNSTONE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_SUNSTONE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.NETHER_SUNSTONE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.END_SUNSTONE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SUNSTONE_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.MALACHITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_MALACHITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.NETHER_MALACHITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.END_MALACHITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.MALACHITE_BLOCK.get()));

                        // Add swords, grouped by material
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE_SWORD.get()));

                        // Add pickaxes
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE_PICKAXE.get()));

                        // Add axes
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE_AXE.get()));

                        // Add shovels
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE_SHOVEL.get()));

                        // Add hoes
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_HOE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_HOE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_HOE.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_HOE.get()));
                        pOutput.accept(new ItemStack(ModItems.MALACHITE_HOE.get()));

                        // Add paxels
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_PAXEL.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_PAXEL.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_PAXEL.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_PAXEL.get()));

                        // Add hammers
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_HAMMER.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_HAMMER.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_HAMMER.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_HAMMER.get()));

                        // Add armor pieces, grouped by material
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_HELMET.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_CHESTPLATE.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_LEGGINGS.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_BOOTS.get()));

                        pOutput.accept(new ItemStack(ModItems.RUBY_HELMET.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_CHESTPLATE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_LEGGINGS.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_BOOTS.get()));

                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_HELMET.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_CHESTPLATE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_LEGGINGS.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_BOOTS.get()));

                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_HELMET.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_CHESTPLATE.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_LEGGINGS.get()));
                        pOutput.accept(new ItemStack(ModItems.SUNSTONE_BOOTS.get()));

                        // Add rings
                        pOutput.accept(new ItemStack(ModItems.RING_OF_RUBY.get()));
                        pOutput.accept(new ItemStack(ModItems.RING_OF_SAPPHIRE.get()));
                        pOutput.accept(new ItemStack(ModItems.RING_OF_SUNSTONE.get()));
                        pOutput.accept(new ItemStack(ModItems.RING_OF_ATHERIUM.get()));

                        // Add Bracelets
                        pOutput.accept(new ItemStack(ModItems.BRACELET_OF_MALACHITE.get()));

                        // Add miscellaneous items
                        pOutput.accept(new ItemStack(ModItems.GOLD_HANDLE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.GEM_POLISHING_TABLE.get()));

                        // Add food items
                        pOutput.accept(new ItemStack(ModItems.ROCK_CANDY.get()));
                        pOutput.accept(new ItemStack(ModItems.ROCK.get()));
                        pOutput.accept(new ItemStack(ModItems.GARLIC.get()));
                        pOutput.accept(new ItemStack(ModItems.GARLIC_BREAD.get()));
                    })
                    // Build the Creative Mode Tab
                    .build());

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
