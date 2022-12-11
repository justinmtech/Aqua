package com.justinmtech.aqua.chat;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String hexColor(String hex, String string) {
        return net.md_5.bungee.api.ChatColor.of(hex) + string;
    }
}
