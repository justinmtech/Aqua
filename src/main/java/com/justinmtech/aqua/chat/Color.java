package com.justinmtech.aqua.chat;

import org.bukkit.ChatColor;

/**
 * Get § with ALT + 2 + 1 (num pad numbers with num lock on)
 * Hex color resource = https://www.color-hex.com/
 */
public class Color {


    /**
     * @param string Plain text or string with '&' color codes
     * @return String (colored)
     */
    public static String apply(String string) {
        if (string == null) return "";
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * @param string Plain text with no color codes
     * @param hex Hex code such as #FFFFF
     * @return String (colored)
     */
    public static String apply(String string, String hex) {
        if (string == null) return "";
        if (hex == null) return string;
        return net.md_5.bungee.api.ChatColor.of(hex) + string;
    }
}
