package net.succ.succsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.succ.succsmod.item.ModFoods;

public class GarlicItem extends ItemNameBlockItem {

    public GarlicItem(Block cropBlock, Item.Properties properties) {
        super(cropBlock, properties.food(ModFoods.GARLIC));
    }
}
