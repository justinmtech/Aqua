package com.justinmtech.aqua.chat;

import org.bukkit.ChatColor;

/**
 * Get § with ALT + 2 + 1 (num pad numbers with num lock on)
 * Hex color resource = https://www.color-hex.com/
 */
public class ColorUtils {

    /**
     * @param string Plain text or string with '&' color codes
     * @return String (colored)
     */
    public static String apply(String string) {
        if (string == null) return "";
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
