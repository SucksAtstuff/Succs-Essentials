package net.succ.succsmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;
import net.succ.succsmod.villager.ModVillagers;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, SuccsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
       tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
               .addOptional(new ResourceLocation(SuccsMod.MOD_ID, "gem_cutter_poi"));
    }
}
