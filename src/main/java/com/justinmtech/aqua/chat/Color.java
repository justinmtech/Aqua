package com.justinmtech.aqua.chat;

import org.bukkit.ChatColor;

public class Color {

    public static String apply(String string) {
        if (string == null) return "";
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String apply(String hex, String string) {
        if (string == null) return "";
        if (hex == null) return string;
        return net.md_5.bungee.api.ChatColor.of(hex) + string;
    }
}
