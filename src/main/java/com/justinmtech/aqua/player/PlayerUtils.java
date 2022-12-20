package com.justinmtech.aqua.player;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Simplify player calls
 */
public class PlayerUtils {

    /**
     * Add item to players inventory or drop it naturally if inventory is full
     * @param player The player that will receive the item
     * @param item The ItemStack to give the player
     */
    public static void giveOrDropItem(@NotNull Player player, @NotNull ItemStack item) {
        HashMap<Integer, ItemStack> failedItems = player.getInventory().addItem(item);
        if (!failedItems.isEmpty()) {
            World world = player.getLocation().getWorld();
            if (world != null) {
                world.dropItemNaturally(player.getLocation(), item);
            }
        }
    }

    /**
     * Get a list of players that have the specified permission
     * @param permission Permission to check for
     * @return List of online player UUIDs that have the permission
     */
    public static List<UUID> getPlayersWithPermission(@NotNull String permission) {
        List<UUID> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission(permission)) {
                players.add(player.getUniqueId());
            }
        }
        return players;
    }
}
