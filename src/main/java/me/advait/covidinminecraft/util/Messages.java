package me.advait.covidinminecraft.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public final class Messages {

    public static final String MUST_BE_PLAYER_ERROR = color("&cYou must be a player to do this!");

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String stripColor(String message) {
        return ChatColor.stripColor(message);
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(color(message));
    }

    public static void sendMessage(CommandSender commandSender, String message) {
        commandSender.sendMessage(color(message));
    }

    public static void sendMessage(ConsoleCommandSender consoleCommandSender, String message) {
        consoleCommandSender.sendMessage(color(message));
    }

    public static void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color(message)));
    }

}
