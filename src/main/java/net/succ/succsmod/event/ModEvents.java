package net.succ.succsmod.event;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.item.HammerItem;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SuccsMod.MOD_ID)
public class ModEvents {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don´t be a jerk License

    // A set to keep track of blocks that have been harvested to avoid duplicate harvesting
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Subscribe to the BlockEvent.BreakEvent to handle custom hammer usage
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer(); // Get the player who triggered the event
        ItemStack mainHandItem = player.getMainHandItem(); // Get the item in the player's main hand

        // Check if the item is an instance of HammerItem and the player is a ServerPlayer
        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos(); // Get the position of the block being broken

            // If the block is already harvested, return to prevent duplicate processing
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            // Loop through the blocks to be destroyed by the hammer's area effect
            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                // Skip the initial block and blocks that the hammer cannot correctly drop
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Add the block position to the set to avoid duplicate harvesting
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos); // Destroy the block at the given position
                HARVESTED_BLOCKS.remove(pos); // Remove the block position from the set after destruction
            }
        }
    }
}
