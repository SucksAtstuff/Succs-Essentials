package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
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

    // Register a new custom tool tier for Atherium
    public static final Tier ATHERIUM = TierSortingRegistry.registerTier(
            // Define the properties of the Atherium tool tier
            new ForgeTier(7, 2565, 12.0F, 5.0F, 18,
                    ModTags.Blocks.NEEDS_ATHERIUM_TOOL, () -> Ingredient.of(ModItems.ATHERIUM.get())),
            // Create a ResourceLocation for the Atherium tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "atherium"),
            // Specify that Atherium is above Netherite in the tool tier hierarchy
            List.of(Tiers.NETHERITE),
            // No tool tiers are below Atherium
            List.of()
    );

    // Register a new custom tool tier for Ruby
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            // Define the properties of the Ruby tool tier
            new ForgeTier(6, 1561, 10.0F, 4.0F, 10,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            // Create a ResourceLocation for the Ruby tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "ruby"),
            // Specify that Ruby is above Sapphire in the tool tier hierarchy
            List.of(Tiers.DIAMOND),
            // Specify that Ruby is below Atherium in the tool tier hierarchy
            List.of(ATHERIUM)
    );

    // Register a new custom tool tier for Sapphire
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            // Define the properties of the Sapphire tool tier
            new ForgeTier(5, 1561, 9.5F, 3F, 12,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            // Create a ResourceLocation for the Sapphire tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "sapphire"),
            // Specify that Sapphire is above Diamond in the tool tier hierarchy
            List.of(Tiers.DIAMOND),
            // Specify that Sapphire is below Ruby in the tool tier hierarchy
            List.of(RUBY)
    );

    // Register a new custom tool tier for Sunstone
    public static final Tier SUNSTONE = TierSortingRegistry.registerTier(
            // Define the properties of the Sunstone tool tier
            new ForgeTier(5, 1561, 9.5F, 3F, 12,
                    ModTags.Blocks.NEEDS_SUNSTONE_TOOL, () -> Ingredient.of(ModItems.SUNSTONE.get())),
            // Create a ResourceLocation for the Sunstone tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "sunstone"),
            // Specify that Sunstone is above Diamond in the tool tier hierarchy
            List.of(Tiers.DIAMOND),
            // Specify that Sunstone is below Ruby in the tool tier hierarchy
            List.of(RUBY)
    );

    // Register a new custom tool tier for Malachite
    public static final Tier MALACHITE = TierSortingRegistry.registerTier(
            // Define the properties of the Malachite tool tier
            new ForgeTier(4, 1561, 8.0F, 2.5F, 10,
                    ModTags.Blocks.NEEDS_MALACHITE_TOOL, () -> Ingredient.of(ModItems.MALACHITE.get())),
            // Create a ResourceLocation for the Malachite tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "malachite"),
            // Specify that Malachite is above Ruby in the tool tier hierarchy
            List.of(RUBY),
            // Specify that Ruby is below Atherium in the tool tier hierarchy
            List.of(ATHERIUM)
    );
}
