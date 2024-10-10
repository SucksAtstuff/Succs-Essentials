package net.succ.succsmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoisonSwordItem extends SwordItem {

    private final int poisonDuration; // Duration of poison in ticks (20 ticks = 1 second)
    private final int poisonAmplifier; // Poison level

    public PoisonSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, int poisonDuration, int poisonAmplifier) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.poisonDuration = poisonDuration;
        this.poisonAmplifier = poisonAmplifier;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.succsmod.poison_sword.tooltip.shift"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.succsmod.poison_sword.tooltip"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            // Apply poison effect to the entity
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, poisonDuration, poisonAmplifier));
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
