package com.justinmtech.aqua.chat;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Message {

    public static void sendActionBar(Player player, String text) {
        if (player == null) return;
        if (text == null) text = "";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(text));
    }
}
