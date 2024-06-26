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
    public static final Tier ATHERIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2565, 10.0F, 4.0F, 18,
                    ModTags.Blocks.NEEDS_ATHERIUM_TOOL, () -> Ingredient.of(ModItems.ATHERIUM.get())),
            new ResourceLocation(SuccsMod.MOD_ID, "atherium"), List.of(Tiers.NETHERITE), List.of());

}
