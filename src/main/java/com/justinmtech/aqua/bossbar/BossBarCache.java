package com.justinmtech.aqua.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Store and modify bossbars.
 * Useful for handling bossbar notifications and progress bars.
 */
public class BossBarCache {
    final Map<UUID, BossBar> bossBars;
    final Map<UUID, Long> timeout;

    public BossBarCache() {
        this.bossBars = new HashMap<>();
        this.timeout = new HashMap<>();
    }

    /**
     * Initialize bossbar with customizable progress
     * @param plugin Plugin instance
     * @param uuid Player ID
     * @param bossBar Bossbar object
     * @param progress Double from 0-1.0
     */
    public void addBossBar(@NotNull JavaPlugin plugin, @NotNull UUID uuid, @NotNull BossBar bossBar, double progress) {
        initializeBossBar(plugin, uuid, bossBar, progress);
    }

    /**
     * Initialize bossbar with 100% progress
     * @param plugin Plugin instance
     * @param uuid Player ID
     * @param bossBar Bossbar
     */
    public void addBossBar(@NotNull JavaPlugin plugin, @NotNull UUID uuid, @NotNull BossBar bossBar) {
        initializeBossBar(plugin, uuid, bossBar, 1.0);
    }

    private void initializeBossBar(@NotNull JavaPlugin plugin, @NotNull UUID uuid, @NotNull BossBar bossBar, double progress) {
        if (progress < 0) progress = 0;
        bossBar.setProgress(progress);
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        bossBar.addPlayer(player);
        bossBars.put(uuid, bossBar);
        timeout.put(uuid, System.currentTimeMillis());
        removeBossBar(plugin, player);
    }

    /**
     * @param uuid Player ID
     * @return BossBar
     */
    public BossBar getBossBar(@NotNull UUID uuid) {
        return bossBars.get(uuid);
    }

    /**
     * Updates progress bar of a player's bossbar
     * @param plugin Plugin instance
     * @param uuid Player ID
     * @param progress Progress (0-1.0)
     */
    public void updateBossBar(@NotNull JavaPlugin plugin, @NotNull UUID uuid, float progress) {
        bossBars.get(uuid).setProgress(progress);
        timeout.replace(uuid, System.currentTimeMillis());
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        removeBossBar(plugin, player);
    }

    /**
     * @return Map<UUID, BossBar>
     */
    public Map<UUID, BossBar> getBossBars() {
        return bossBars;
    }

    public void removePlayer(@NotNull Player player) {
        bossBars.get(player.getUniqueId()).removePlayer(player);
    }

    private void removeBossBar(@NotNull JavaPlugin plugin, @NotNull Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                double currentTime = System.currentTimeMillis();
                double lastUsed = timeout.get(player.getUniqueId());
                if (currentTime - lastUsed > 5000) {
                    if (bossBars.get(player.getUniqueId()) != null) {
                        bossBars.get(player.getUniqueId()).removePlayer(player);
                        bossBars.remove(player.getUniqueId());
                    }
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 100L, 100L);
    }
}

