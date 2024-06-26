package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;

public class ModItems {

    // Create a DeferredRegister for items, using the mod ID
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SuccsMod.MOD_ID);

    // Register the Atherium item
    public static final RegistryObject<Item> ATHERIUM = ITEMS.register("atherium",
            () -> new Item(new Item.Properties()));

    // Register the Rock Candy item with food properties
    public static final RegistryObject<Item> ROCK_CANDY = ITEMS.register("rock_candy",
            () -> new Item(new Item.Properties().food(ModFoods.ROCK_CANDY)));

    // Register the Gold Handle item
    public static final RegistryObject<Item> GOLD_HANDLE = ITEMS.register("gold_handle",
            () -> new Item(new Item.Properties()));

    // Register the Atherium Sword item
    public static final RegistryObject<Item> ATHERIUM_SWORD = ITEMS.register("atherium_sword",
            () -> new SwordItem(ModToolTiers.ATHERIUM, 4, -2.4F, new Item.Properties()));

    // Register the Atherium Pickaxe item
    public static final RegistryObject<Item> ATHERIUM_PICKAXE = ITEMS.register("atherium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ATHERIUM, 2, -2.8F, new Item.Properties()));

    // Register the Atherium Axe item
    public static final RegistryObject<Item> ATHERIUM_AXE = ITEMS.register("atherium_axe",
            () -> new AxeItem(ModToolTiers.ATHERIUM, 7, -3F, new Item.Properties()));

    // Register the Atherium Shovel item
    public static final RegistryObject<Item> ATHERIUM_SHOVEL = ITEMS.register("atherium_shovel",
            () -> new ShovelItem(ModToolTiers.ATHERIUM, 2, -3F, new Item.Properties()));

    // Register the Atherium Hoe item
    public static final RegistryObject<Item> ATHERIUM_HOE = ITEMS.register("atherium_hoe",
            () -> new HoeItem(ModToolTiers.ATHERIUM, -4, 1F, new Item.Properties()));

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
