package com.justinmtech.aqua.player;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Objects;

/**
 * Simplify player calls
 */
public class PlayerUtils {

    /**
     * Add item to players inventory or drop it naturally if inventory is full
     * @param player Player
     * @param item ItemStack
     */
    public static void giveOrDropItem(@NotNull Player player, @NotNull ItemStack item) {
        HashMap<Integer, ItemStack> failedItems = player.getInventory().addItem(item);
        if (!failedItems.isEmpty()) {
            Objects.requireNonNull(player.getLocation().getWorld()).dropItemNaturally(player.getLocation(), item);
        }
    }
}
