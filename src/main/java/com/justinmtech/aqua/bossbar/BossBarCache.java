package com.justinmtech.aqua.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

//Store and modify bossbars
public class BossBarCache {
    final Map<UUID, BossBar> bossBars;
    final Map<UUID, Long> timeout;

    public BossBarCache() {
        this.bossBars = new HashMap<>();
        this.timeout = new HashMap<>();
    }

    public void addBossBar(JavaPlugin plugin, UUID uuid, BossBar bossBar, double progress) {
        initializeBossBar(plugin, uuid, bossBar, progress);
    }

    //Progress 1.0 (100%)
    public void addBossBar(JavaPlugin plugin, UUID uuid, BossBar bossBar) {
        initializeBossBar(plugin, uuid, bossBar, 1.0);
    }

    private void initializeBossBar(JavaPlugin plugin, UUID uuid, BossBar bossBar, double progress) {
        if (plugin == null) return;
        if (uuid == null) return;
        if (bossBar == null) return;
        if (progress < 0) progress = 0;
        bossBar.setProgress(progress);
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        bossBar.addPlayer(player);
        bossBars.put(uuid, bossBar);
        timeout.put(uuid, System.currentTimeMillis());
        removeBossBar(plugin, player);
    }

    public BossBar getBossBar(UUID uuid) {
        return bossBars.get(uuid);
    }

    public void updateBossBar(JavaPlugin plugin, UUID uuid, float progress) {
        bossBars.get(uuid).setProgress(progress);
        timeout.replace(uuid, System.currentTimeMillis());
        removeBossBar(plugin, Bukkit.getPlayer(uuid));
    }

    public Map<UUID, BossBar> getBossBars() {
        return bossBars;
    }

    public void removePlayer(Player player) {
        bossBars.get(player.getUniqueId()).removePlayer(player);
    }

    private void removeBossBar(JavaPlugin plugin, Player player) {
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

