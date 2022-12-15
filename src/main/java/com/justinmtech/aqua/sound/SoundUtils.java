package com.justinmtech.aqua.sound;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Tools to simply broadcast sound
 */
public class SoundUtils {

    /**
     * Play a sound for all online players.
     * @param sound Bukkit Sound
     * @param vol Volume of sound
     * @param pitch Pitch of sound
     */
    public static void playForAll(@NotNull Sound sound, float vol, float pitch) {
        playSound(sound, vol, pitch, null);
    }


    /**
     * Play sound for all players who have a permission
     * @param sound Bukkit Sound
     * @param vol Volume of sound
     * @param pitch Pitch of sound
     * @param permission Trigger sound if player has this permission
     */
    public static void playForAllWithPerm(@NotNull Sound sound, float vol, float pitch, String permission) {
        playSound(sound, vol, pitch, permission);
    }

    private static void playSound(@NotNull Sound sound, float vol, float pitch, String permission) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (permission == null) {
                player.playSound(player.getLocation(), sound, vol, pitch);
            } else if (player.hasPermission(permission)) {
                player.playSound(player.getLocation(), sound, vol, pitch);
            }
        }
    }
}
