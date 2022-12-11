package com.justinmtech.aqua.chat;

import org.bukkit.ChatColor;

public class Color {
    //Notes
    //Get § - ALT + 2 + 1 (num pad with num lock on)
    //Hex colors - https://www.color-hex.com/

    public static String apply(String string) {
        if (string == null) return "";
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String apply(String string, String hex) {
        if (string == null) return "";
        if (hex == null) return string;
        return net.md_5.bungee.api.ChatColor.of(hex) + string;
    }
}
