package com.justinmtech.aqua.chat;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Simplified messages
 */
public class MessageUtils {

    /**
     * Send player an ActionBar message.
     * @param player Player
     * @param text Plain text or legacy text color codes (§, &)
     */
    public static void sendActionBar(Player player, String text) {
        if (player == null) return;
        if (text == null) text = "";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(text));
    }

    /**
     * @param player Player
     * @param message Message to send in chat
     * @param command Command to execute when clicked
     * @param hoverText Text to display when hovered over
     */
    public static void sendCommandMessage(@NotNull Player player, @NotNull String message, @NotNull String command, @NotNull String hoverText) {
        TextComponent component = new TextComponent(message);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverText)));
        player.spigot().sendMessage(component);
    }
}
