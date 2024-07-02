package net.succ.succsmod.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, SuccsMod.MOD_ID);

    public static final RegistryObject<MenuType<GemPolishingTableMenu>> GEM_POLISHING_MENU =
            registerMenuType(GemPolishingTableMenu::new, "gem_polishing_station");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register (IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}
