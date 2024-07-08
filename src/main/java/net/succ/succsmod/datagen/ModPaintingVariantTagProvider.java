package net.succ.succsmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.succ.succsmod.SuccsMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends PaintingVariantTagsProvider {
    public ModPaintingVariantTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, SuccsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(SuccsMod.MOD_ID, "theomonty"));

        this.tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(SuccsMod.MOD_ID, "kurgerbing"));

        this.tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(SuccsMod.MOD_ID, "jack_sip"));
    }
}
