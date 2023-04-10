package com.justinmtech.aqua.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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

    /**
     * @param location The location to check from
     * @param distance The distance in blocks the player's location must be closer than or equal to
     * @return A map of nearby players with their distance mapped to their uuid.
     */
    public static Map<Double, UUID> getNearbyPlayersWithDistance(@NotNull Location location, int distance) {
        Map<Double, UUID> nearbyPlayers = new HashMap<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().equals(location.getWorld())) {
                Location playerLocation = player.getLocation();
                double distanceFromPlayer = location.distance(playerLocation);
                if (distanceFromPlayer <= distance) {
                    nearbyPlayers.put(distanceFromPlayer, player.getUniqueId());
                }
            }
        }
        return nearbyPlayers;
    }

    /**
     * @param fromLocation The location to measure the distance from
     * @param toLocation The place to teleport the players to if they are as closer or closer than the distance
     * @param distance The distance from the fromLocation and the player the player must be to be teleported
     */
    public static void teleportPlayers(@NotNull Location fromLocation, @NotNull Location toLocation, int distance) {
        List<PlayerComparable> players = getNearbyPlayers(fromLocation, distance);
        for (PlayerComparable p : players) {
            Player player = Bukkit.getPlayer(p.getUuid());
            if (player != null) {
                player.teleport(toLocation);
            }
        }
    }

    /**
     * @param location The location to check from
     * @param distance The distance in blocks the player's location must be closer than or equal to
     * @return A List of sorted players
     */
    public static List<PlayerComparable> getNearbyPlayers(@NotNull Location location, int distance) {
        Map<Double, UUID> closestPlayers = getNearbyPlayersWithDistance(location, distance);
        List<PlayerComparable> nearbyPlayers = new ArrayList<>();
        for (Double d : closestPlayers.keySet()) {
            UUID uuid = closestPlayers.get(d);
            nearbyPlayers.add(new PlayerComparable(uuid, d));
        }
        Collections.sort(nearbyPlayers);
        return nearbyPlayers;
    }

    /**
     * Used for comparing player distances
     */
    public record PlayerComparable(UUID uuid, double distance) implements Comparable<PlayerComparable> {

        public UUID getUuid() {
            return uuid;
        }

        public double getDistance() {
            return distance;
        }

        @Override
        public int compareTo(@NotNull PlayerUtils.PlayerComparable o) {
            if (this.distance > o.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
