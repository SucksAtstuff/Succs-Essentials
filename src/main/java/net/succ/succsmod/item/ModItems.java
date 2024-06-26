package net.succ.succsmod.item;

import net.minecraft.world.item.Item;
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






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
