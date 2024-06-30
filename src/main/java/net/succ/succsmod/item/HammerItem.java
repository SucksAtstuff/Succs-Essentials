package net.succ.succsmod.item;

// Import statements for necessary classes from Minecraft and SuccsMod
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem implements Vanishable {

    // Constructor for HammerItem
    public HammerItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        // Call the superclass constructor with the specified parameters and BlockTags.MINEABLE_WITH_PICKAXE
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
    }

    // Method to get a list of blocks to be destroyed by the hammer in an area
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        // Initialize a list to store the positions of blocks to be destroyed
        List<BlockPos> positions = new ArrayList<>();

        // Perform a ray trace to determine the direction the player is looking at
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        // If the ray trace misses, return the empty list of positions
        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        // Determine the direction of the block face being hit
        Direction direction = traceResult.getDirection();

        // Add positions of blocks to be destroyed based on the direction of the block face being hit
        if (direction == Direction.DOWN || direction == Direction.UP) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y));
                }
            }
        } else if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                }
            }
        } else if (direction == Direction.EAST || direction == Direction.WEST) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                }
            }
        }

        // Return the list of block positions to be destroyed
        return positions;
    }
}
