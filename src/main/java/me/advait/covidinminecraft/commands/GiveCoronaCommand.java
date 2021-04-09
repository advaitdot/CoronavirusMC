package me.advait.covidinminecraft.commands;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCoronaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            Messages.sendMessage(sender, "&cUsage: /givecorona [player]");
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
        if (CoronaUtil.hasCorona(target)) {
            Messages.sendMessage(player, "&cThis player already has the coronavirus!");
            return true;
        }

        CoronaUtil.giveCorona(target);
        Messages.sendMessage(player, "&aSuccessfully gave " + target.getName() + " coronavirus!");
        Messages.sendMessage(target, "&aYou now have coronavirus.");

        return true;
    }
}
