package me.advait.covidinminecraft.tasks;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoronaHealthDeprivationTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (CoronaUtil.hasCorona(player)) {
                player.damage(1);
                if (player.getHealth() <= 0) {
                    Bukkit.broadcastMessage(Messages.color("&c" + player.getName() + " lost their life from COVID-19!"));
                }
            }
        }
    }

}
