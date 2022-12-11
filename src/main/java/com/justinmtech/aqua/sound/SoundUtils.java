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
     * @param sound Bukkit Sound
     * @param vol Volume of sound
     * @param pitch Pitch of sound
     */
    //Play a sound for all online players
    public static void playForAll(@NotNull Sound sound, float vol, float pitch) {
        playSound(sound, vol, pitch, null);
    }

    //Player a sound for all online players that have a permission
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
