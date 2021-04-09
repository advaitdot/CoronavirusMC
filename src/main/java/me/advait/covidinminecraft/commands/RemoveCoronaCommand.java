package me.advait.covidinminecraft.commands;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCoronaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            Messages.sendMessage(sender, "&cUsage: /removecorona [player]");
            return true;
        } else if (!(sender instanceof Player)) {
            Messages.sendMessage(sender, Messages.MUST_BE_PLAYER_ERROR);
            return true;
        }

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            Messages.sendMessage(player, "&cThis player is not online!");
            return true;
        }
        if (!CoronaUtil.hasCorona(target)) {
            Messages.sendMessage(player, "&cThis player does not have the coronavirus!");
            return true;
        }

        CoronaUtil.removeCorona(target);
        Messages.sendMessage(player, "&aSuccessfully revoked " + target.getName() + " of coronavirus!");
        Messages.sendMessage(target, "&aYou no longer have the coronavirus.");

        return true;
    }
}
