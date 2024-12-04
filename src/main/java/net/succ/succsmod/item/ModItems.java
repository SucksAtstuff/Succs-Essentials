package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;
import net.succ.succsmod.item.custom.*;

public class ModItems {

    // Create a DeferredRegister for items, using the mod ID
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SuccsMod.MOD_ID);

    // Register the Atherium items
    public static final RegistryObject<Item> DIRTY_ATHERIUM = ITEMS.register("dirty_atherium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ATHERIUM = ITEMS.register("atherium",
            () -> new Item(new Item.Properties()));

    // Register the Sunstone items
    public static final RegistryObject<Item> DIRTY_SUNSTONE = ITEMS.register("dirty_sunstone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUNSTONE = ITEMS.register("sunstone",
            () -> new Item(new Item.Properties()));

    // Register the Ruby items
    public static final RegistryObject<Item> DIRTY_RUBY = ITEMS.register("dirty_ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    // Register the Sapphire items
    public static final RegistryObject<Item> DIRTY_SAPPHIRE = ITEMS.register("dirty_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    // Register the Malachite items
    public static final RegistryObject<Item> MALACHITE = ITEMS.register("malachite",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIRTY_MALACHITE = ITEMS.register("dirty_malachite",
            () -> new Item(new Item.Properties()));

    // Register the Rock Candy item with food properties
    public static final RegistryObject<Item> ROCK_CANDY = ITEMS.register("rock_candy",
            () -> new Item(new Item.Properties().food(ModFoods.ROCK_CANDY)));

    // Register the Rock item
    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties().food(ModFoods.ROCK)));

    // Register the Garlic item
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new GarlicItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties()));

    // Register the Garlic Bread item with food properties
    public static final RegistryObject<Item> GARLIC_BREAD = ITEMS.register("garlic_bread",
            () -> new Item(new Item.Properties().food(ModFoods.GARLIC_BREAD)));

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

    // Register the Atherium Hammer item
    public static final RegistryObject<Item> ATHERIUM_HAMMER = ITEMS.register("atherium_hammer",
            () -> new HammerItem(ModToolTiers.ATHERIUM, 10, -3.5F, new Item.Properties()));

    // Register the Atherium Paxel item
    public static final RegistryObject<Item> ATHERIUM_PAXEL = ITEMS.register("atherium_paxel",
            () -> new PaxelItem(ModToolTiers.ATHERIUM, 3, -2.5F, new Item.Properties()));

    // Register the Atherium Helmet item
    public static final RegistryObject<Item> ATHERIUM_HELMET = ITEMS.register("atherium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ATHERIUM, ArmorItem.Type.HELMET, new Item.Properties()));

    // Register the Atherium Chestplate item
    public static final RegistryObject<Item> ATHERIUM_CHESTPLATE = ITEMS.register("atherium_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ATHERIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    // Register the Atherium Leggings item
    public static final RegistryObject<Item> ATHERIUM_LEGGINGS = ITEMS.register("atherium_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ATHERIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Register the Atherium Boots item
    public static final RegistryObject<Item> ATHERIUM_BOOTS = ITEMS.register("atherium_boots",
            () -> new ModArmorItem(ModArmorMaterials.ATHERIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Register the Ruby Sword item
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 3, -2.4F, new Item.Properties()));

    // Register the Ruby Pickaxe item
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 2, -2.8F, new Item.Properties()));

    // Register the Ruby Axe item
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 6, -3F, new Item.Properties()));

    // Register the Ruby Shovel item
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 2, -3F, new Item.Properties()));

    // Register the Ruby Hoe item
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -4, 1F, new Item.Properties()));

    // Register the Ruby Hammer item
    public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(ModToolTiers.RUBY, 9, -3.5F, new Item.Properties()));

    // Register the Ruby Paxel Item
    public static final RegistryObject<Item> RUBY_PAXEL = ITEMS.register("ruby_paxel",
            () -> new PaxelItem(ModToolTiers.RUBY, 2, -2.5F, new Item.Properties()));

    // Register the Ruby Helmet item
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));

    // Register the Ruby Chestplate item
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    // Register the Ruby Leggings item
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Register the Ruby Boots item
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Register the Sapphire Sword item
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new LootingSwordItem(ModToolTiers.SAPPHIRE, 3, -2.4F, new Item.Properties()));

    // Register the Sapphire Pickaxe item
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new LootingPickaxeItem(ModToolTiers.SAPPHIRE, 2, -2.8F, new Item.Properties()));

    // Register the Sapphire Axe item
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 6, -3F, new Item.Properties()));

    // Register the Sapphire Shovel item
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 2, -3F, new Item.Properties()));

    // Register the Sapphire Hoe item
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, -3, 1F, new Item.Properties()));

    // Register the Sapphire Paxel Item
    public static final RegistryObject<Item> SAPPHIRE_PAXEL = ITEMS.register("sapphire_paxel",
            () -> new PaxelItem(ModToolTiers.SAPPHIRE, 1, -2.5F, new Item.Properties()));

    // Register the Sapphire Hammer item
    public static final RegistryObject<Item> SAPPHIRE_HAMMER = ITEMS.register("sapphire_hammer",
            () -> new HammerItem(ModToolTiers.SAPPHIRE, 8, -3.5F, new Item.Properties()));

    // Register the Sapphire Helmet item
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));

    // Register the Sapphire Chestplate item
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    // Register the Sapphire Leggings item
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Register the Sapphire Boots item
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Register the Sunstone Sword item
    public static final RegistryObject<Item> SUNSTONE_SWORD = ITEMS.register("sunstone_sword",
            () -> new FireSwordItem(ModToolTiers.SUNSTONE, 3, -2.4F, new Item.Properties()));

    // Register the Sunstone Pickaxe item
    public static final RegistryObject<Item> SUNSTONE_PICKAXE = ITEMS.register("sunstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SUNSTONE, 2, -2.8F, new Item.Properties()));

    // Register the Sunstone Axe item
    public static final RegistryObject<Item> SUNSTONE_AXE = ITEMS.register("sunstone_axe",
            () -> new AxeItem(ModToolTiers.SUNSTONE, 6, -3F, new Item.Properties()));

    // Register the Sunstone Shovel item
    public static final RegistryObject<Item> SUNSTONE_SHOVEL = ITEMS.register("sunstone_shovel",
            () -> new ShovelItem(ModToolTiers.SUNSTONE, 2, -3F, new Item.Properties()));

    // Register the Sunstone Hoe item
    public static final RegistryObject<Item> SUNSTONE_HOE = ITEMS.register("sunstone_hoe",
            () -> new HoeItem(ModToolTiers.SUNSTONE, -3, 1F, new Item.Properties()));

    // Register the Sunstone Hammer item
    public static final RegistryObject<Item> SUNSTONE_HAMMER = ITEMS.register("sunstone_hammer",
            () -> new HammerItem(ModToolTiers.SUNSTONE, 8, -3.5F, new Item.Properties()));

    // Register the Sunstone Paxel Item
    public static final RegistryObject<Item> SUNSTONE_PAXEL = ITEMS.register("sunstone_paxel",
            () -> new PaxelItem(ModToolTiers.SUNSTONE, 1, -2.5F, new Item.Properties()));

    // Register the Sunstone Helmet item
    public static final RegistryObject<Item> SUNSTONE_HELMET = ITEMS.register("sunstone_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SUNSTONE, ArmorItem.Type.HELMET, new Item.Properties()));

    // Register the Sunstone Chestplate item
    public static final RegistryObject<Item> SUNSTONE_CHESTPLATE = ITEMS.register("sunstone_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SUNSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    // Register the Sunstone Leggings item
    public static final RegistryObject<Item> SUNSTONE_LEGGINGS = ITEMS.register("sunstone_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SUNSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Register the Sunstone Boots item
    public static final RegistryObject<Item> SUNSTONE_BOOTS = ITEMS.register("sunstone_boots",
            () -> new ModArmorItem(ModArmorMaterials.SUNSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Register the Malachite Sword item
    public static final RegistryObject<Item> MALACHITE_SWORD = ITEMS.register("malachite_sword",
            () -> new PoisonSwordItem(ModToolTiers.MALACHITE, 3, -2.4F, new Item.Properties(), 100, 1)); // 100 ticks = 5 seconds, amplifier 0 = Poison I

    // Register the Malachite Pickaxe item
    public static final RegistryObject<Item> MALACHITE_PICKAXE = ITEMS.register("malachite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MALACHITE, 2, -2.8F, new Item.Properties()));

    // Register the Malachite Axe item
    public static final RegistryObject<Item> MALACHITE_AXE = ITEMS.register("malachite_axe",
            () -> new AxeItem(ModToolTiers.MALACHITE, 6, -3F, new Item.Properties()));

    // Register the Malachite Shovel item
    public static final RegistryObject<Item> MALACHITE_SHOVEL = ITEMS.register("malachite_shovel",
            () -> new ShovelItem(ModToolTiers.MALACHITE, 2, -3F, new Item.Properties()));

    // Register the Malachite Hoe item
    public static final RegistryObject<Item> MALACHITE_HOE = ITEMS.register("malachite_hoe",
            () -> new HoeItem(ModToolTiers.MALACHITE, -5, 1F, new Item.Properties()));

    // Register the Malachite Hammer item
    public static final RegistryObject<Item> MALACHITE_HAMMER = ITEMS.register("malachite_hammer",
            () -> new HammerItem(ModToolTiers.MALACHITE, 8, -3.5F, new Item.Properties()));

    // Register the Malachite Paxel Item
    public static final RegistryObject<Item> MALACHITE_PAXEL = ITEMS.register("malachite_paxel",
            () -> new PaxelItem(ModToolTiers.MALACHITE, 1, -2.5F, new Item.Properties()));

    // Register the Malachite Helmet item
    public static final RegistryObject<Item> MALACHITE_HELMET = ITEMS.register("malachite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.HELMET, new Item.Properties()));

    // Register the Malachite Chestplate item
    public static final RegistryObject<Item> MALACHITE_CHESTPLATE = ITEMS.register("malachite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    // Register the Malachite Leggings item
    public static final RegistryObject<Item> MALACHITE_LEGGINGS = ITEMS.register("malachite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Register the Malachite Boots item
    public static final RegistryObject<Item> MALACHITE_BOOTS = ITEMS.register("malachite_boots",
            () -> new ModArmorItem(ModArmorMaterials.MALACHITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Register the Ring of Atherium item with attack speed effect for the ring slot
    public static final RegistryObject<Item> RING_OF_ATHERIUM = ITEMS.register("ring_of_atherium",
            () -> new CustomCurioAttributeItem(Attributes.ATTACK_SPEED, "a7e8f2d7-5e4b-4e7e-8f89-8c7e1f94e76f", 0.4, AttributeModifier.Operation.ADDITION, "ring"));

    // Register the Ring of Ruby item with health effect for the ring slot
    public static final RegistryObject<Item> RING_OF_RUBY = ITEMS.register("ring_of_ruby",
            () -> new CustomCurioAttributeItem(Attributes.MAX_HEALTH, "e3a7c2a3-4c5b-4e3e-9b8e-b6b9f781df55", 10, AttributeModifier.Operation.ADDITION, "ring"));

    // Register the Ring of Sapphire item with luck effect for the ring slot
    public static final RegistryObject<Item> RING_OF_SAPPHIRE = ITEMS.register("ring_of_sapphire",
            () -> new CustomCurioAttributeItem(Attributes.LUCK, "e3a7c2a3-4c5b-4e3e-9b8e-b6b9f781df55", 20, AttributeModifier.Operation.ADDITION, "ring"));

    // Register the Ring of Sunstone item with fire resistance effect for the ring slot
    public static final RegistryObject<Item> RING_OF_SUNSTONE = ITEMS.register("ring_of_sunstone",
            () -> new CustomCurioMobEffectItem(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, true, false, false), "ring"));

    // Register the Bracelet of Malachite item with poison immunity for the bracelet slot
    public static final RegistryObject<Item> BRACELET_OF_MALACHITE = ITEMS.register("bracelet_of_malachite",
            () -> new CustomCurioMobEffectItem(new MobEffectInstance(MobEffects.POISON, Integer.MAX_VALUE, 0, true, false, false), "bracelet"));

    // Register the Necklace of Amethyst item with haste effect for the necklace slot
    public static final RegistryObject<Item> NECKLACE_OF_AMETHYST = ITEMS.register("necklace_of_amethyst",
            () -> new CustomCurioMobEffectItem(new MobEffectInstance(MobEffects.DIG_SPEED, Integer.MAX_VALUE, 1, true, false, false), "necklace"));


    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
