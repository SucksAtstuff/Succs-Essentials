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
            new ForgeTier(5, 2565, 10.0F, 4.0F, 18,
                    ModTags.Blocks.NEEDS_ATHERIUM_TOOL, () -> Ingredient.of(ModItems.ATHERIUM.get())),
            // Create a ResourceLocation for the Atherium tool tier
            new ResourceLocation(SuccsMod.MOD_ID, "atherium"),
            // Specify that Atherium is above Netherite in the tool tier hierarchy
            List.of(Tiers.NETHERITE),
            // No tool tiers are below Atherium
            List.of()
    );

    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1561, 8.0F, 3.0F, 10,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(SuccsMod.MOD_ID, "ruby"),
            List.of(Tiers.DIAMOND),
            // No tool tiers are below Ruby
            List.of()

    );

    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1561, 8.0F, 3.0F, 10,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(SuccsMod.MOD_ID, "sapphire"),
            List.of(Tiers.DIAMOND),
            // No tool tiers are below Sapphire
            List.of()

    );
}
