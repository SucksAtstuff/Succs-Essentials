package net.succ.succsmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.succ.succsmod.SuccsMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ATHERIUM_TOOL = tag("needs_atherium_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");


        private static TagKey<Block> tag (String name){
            return BlockTags.create(new ResourceLocation(SuccsMod.MOD_ID, name));
        }
    }



    public static class Items {
        private static TagKey<Item> tag (String name){
            return ItemTags.create(new ResourceLocation(SuccsMod.MOD_ID, name));
        }
    }
}
