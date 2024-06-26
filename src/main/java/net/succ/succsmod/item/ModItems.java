package net.succ.succsmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SuccsMod.MOD_ID);


    public static final RegistryObject<Item> ATHERIUM = ITEMS.register("atherium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROCK_CANDY = ITEMS.register("rock_candy",
            () -> new Item(new Item.Properties().food(ModFoods.ROCK_CANDY)));

    public static final RegistryObject<Item> ATHERIUM_SWORD = ITEMS.register("atherium_sword",
            () -> new SwordItem(ModToolTiers.ATHERIUM, 4, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> ATHERIUM_PICKAXE = ITEMS.register("atherium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ATHERIUM, 2, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> ATHERIUM_AXE = ITEMS.register("atherium_axe",
            () -> new AxeItem(ModToolTiers.ATHERIUM, 7, -3F, new Item.Properties()));

    public static final RegistryObject<Item> ATHERIUM_SHOVEL = ITEMS.register("atherium_shovel",
            () -> new ShovelItem(ModToolTiers.ATHERIUM, 2, -3F, new Item.Properties()));

    public static final RegistryObject<Item> ATHERIUM_HOE = ITEMS.register("atherium_hoe",
            () -> new HoeItem(ModToolTiers.ATHERIUM, -4, 1F, new Item.Properties()));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
