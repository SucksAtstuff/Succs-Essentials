package net.succ.succsmod.item;

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
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuccsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SUCCS_MOD_TAB = CREATIVE_MODE_TABS.register("succsmod",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ATHERIUM.get()))
                    .title(Component.translatable("creativetab.succs_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(new ItemStack(ModItems.ATHERIUM.get()));

                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_ATHERIUM_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.ATHERIUM_BLOCK.get()));
                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
