package net.succ.succsmod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.util.ModTags;

import java.util.List;

public class ModToolTiers {

    // Register a new custom tool tier for Sapphire
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            // Define the properties of the Sapphire tool tier
            new ForgeTier(5, 1561, 9.5F, 3.0F, 12,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            // Create a ResourceLocation for the Sapphire tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "sapphire"),
            // Sapphire is above Netherite
            List.of(Tiers.NETHERITE),
            // Sapphire is below Ruby
            List.of()
    );

    // Register a new custom tool tier for Sunstone
    public static final Tier SUNSTONE = TierSortingRegistry.registerTier(
            // Define the properties of the Sapphire tool tier
            new ForgeTier(5, 1561, 9.5F, 3.0F, 12,
                    ModTags.Blocks.NEEDS_SUNSTONE_TOOL, () -> Ingredient.of(ModItems.SUNSTONE.get())),
            // Create a ResourceLocation for the Sapphire tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "sunstone"),
            // Sapphire is above Netherite
            List.of(Tiers.NETHERITE),
            // Sapphire is below Ruby
            List.of()
    );

    // Register a new custom tool tier for Ruby
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            // Define the properties of the Ruby tool tier
            new ForgeTier(6, 1561, 10.0F, 4.0F, 10,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            // Create a ResourceLocation for the Ruby tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "ruby"),
            // Ruby is above Sapphire and Sunstone
            List.of(SAPPHIRE, SUNSTONE),
            // Ruby is below Malachite
            List.of()
    );

    // Register a new custom tool tier for Malachite
    public static final Tier MALACHITE = TierSortingRegistry.registerTier(
            // Define the properties of the Malachite tool tier
            new ForgeTier(7, 1854, 10.5F, 5.0F, 12,
                    ModTags.Blocks.NEEDS_MALACHITE_TOOL, () -> Ingredient.of(ModItems.MALACHITE.get())),
            // Create a ResourceLocation for the Malachite tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "malachite"),
            // Malachite is above Ruby
            List.of(RUBY),
            // Malachite is below Atherium
            List.of()
    );

    // Register a new custom tool tier for Atherium
    public static final Tier ATHERIUM = TierSortingRegistry.registerTier(
            // Define the properties of the Atherium tool tier
            new ForgeTier(8, 2565, 12.0F, 5.0F, 18,
                    ModTags.Blocks.NEEDS_ATHERIUM_TOOL, () -> Ingredient.of(ModItems.ATHERIUM.get())),
            // Create a ResourceLocation for the Atherium tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "atherium"),
            // Atherium is above all other custom tool tiers
            List.of(MALACHITE, RUBY, SAPPHIRE, SUNSTONE),
            // Atherium is at the top, so no tiers below it
            List.of()
    );
}
