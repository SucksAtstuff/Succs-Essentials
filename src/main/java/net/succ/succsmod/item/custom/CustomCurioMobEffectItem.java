package net.succ.succsmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class CustomCurioMobEffectItem extends Item implements ICurioItem {

    private final MobEffectInstance mobEffectInstance;
    private final String slotType;

    public CustomCurioMobEffectItem(MobEffectInstance mobEffectInstance, String slotType) {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
        this.mobEffectInstance = mobEffectInstance;
        this.slotType = slotType;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        // No periodic update needed for this item
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if (slotContext.entity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) slotContext.entity();
            entity.addEffect(new MobEffectInstance(mobEffectInstance));
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if (slotContext.entity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) slotContext.entity();
            entity.removeEffect(mobEffectInstance.getEffect());
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return slotContext.identifier().equals(slotType);
    }
}
