package net.succ.succsmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.client.gui.screens.Screen;
import net.succ.succsmod.item.ModArmorMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, AttributeModifier> MATERIAL_TO_ATTRIBUTE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, AttributeModifier>())
                    .put(ModArmorMaterials.ATHERIUM, new AttributeModifier(UUID.randomUUID(), "health_boost", 20.0, AttributeModifier.Operation.ADDITION))
                    .build();

    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int pSlotId, boolean pIsSelected) {
        if (!level.isClientSide) {
            if (entity instanceof Player player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorAttributes(player);
                } else {
                    removeArmorAttributes(player);
                }
            }
        }
    }

    private void evaluateArmorAttributes(Player player) {
        for (Map.Entry<ArmorMaterial, AttributeModifier> entry : MATERIAL_TO_ATTRIBUTE_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            AttributeModifier mapAttribute = entry.getValue();

            if (hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addAttributeToPlayer(player, mapAttribute);
            }
        }
    }

    private void addAttributeToPlayer(Player player, AttributeModifier attribute) {
        if (!player.getAttribute(Attributes.MAX_HEALTH).hasModifier(attribute)) {
            player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(attribute);
        }
    }

    private void removeArmorAttributes(Player player) {
        for (AttributeModifier attribute : MATERIAL_TO_ATTRIBUTE_MAP.values()) {
            if (player.getAttribute(Attributes.MAX_HEALTH).hasModifier(attribute)) {
                player.getAttribute(Attributes.MAX_HEALTH).removeModifier(attribute);
                updatePlayerHealth(player);
            }
        }
    }

    private void updatePlayerHealth(Player player) {
        player.setHealth(player.getMaxHealth());
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial
                && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial
                && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (this.getMaterial() == ModArmorMaterials.ATHERIUM) {
            if (Screen.hasShiftDown()) {
                pTooltipComponents.add(Component.translatable("tooltip.succsmod.atherium_armor.tooltip.shift"));
            } else {
                pTooltipComponents.add(Component.translatable("tooltip.succsmod.atherium_armor.tooltip"));
            }
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
