package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ATHERIUM.get()))
                    .title(Component.translatable("creativetab.succs_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Add items to be displayed in the custom Creative Mode Tab
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE.get()));

                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_RUBY_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.RUBY_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModBlocks.SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get()));

                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM_HOE.get()));

                        pOutput.accept(new ItemStack(ModItems.RUBY_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.RUBY_HOE.get()));

                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_PICKAXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_AXE.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_SHOVEL.get()));
                        pOutput.accept(new ItemStack(ModItems.SAPPHIRE_HOE.get()));

                        pOutput.accept(new ItemStack(ModItems.ROCK_CANDY.get()));
                        pOutput.accept(new ItemStack(ModItems.GOLD_HANDLE.get()));
                    })
                    .build());

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
