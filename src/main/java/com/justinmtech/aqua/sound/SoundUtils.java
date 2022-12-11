package com.justinmtech.aqua.sound;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {

    //Play a sound for all online players
    public static void playSoundOnlinePlayers(Sound sound, float vol, float pitch) {
        playSound(sound, vol, pitch, null);
    }

    //Player a sound for all online players that have a permission
    public static void playSoundOnlinePlayersWithPerm(Sound sound, float vol, float pitch, String permission) {
        playSound(sound, vol, pitch, permission);
    }

    private static void playSound(Sound sound, float vol, float pitch, String permission) {
        if (sound == null) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (permission == null) {
                player.playSound(player.getLocation(), sound, vol, pitch);
            } else if (player.hasPermission(permission)) {
                player.playSound(player.getLocation(), sound, vol, pitch);
            }
        }
    }
}
