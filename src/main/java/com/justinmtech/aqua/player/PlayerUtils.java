package com.justinmtech.aqua.player;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;

public class PlayerUtils {

    //Add item to players inventory or drop it naturally if inventory is full
    public static void giveOrDropItem(Player player, ItemStack item) {
        if (player == null) return;
        if (item == null) return;
        HashMap<Integer, ItemStack> failedItems = player.getInventory().addItem(item);
        if (!failedItems.isEmpty()) {
            Objects.requireNonNull(player.getLocation().getWorld()).dropItemNaturally(player.getLocation(), item);
        }
    }
}
