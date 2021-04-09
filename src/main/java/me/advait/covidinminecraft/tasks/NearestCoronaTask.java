package me.advait.covidinminecraft.tasks;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class NearestCoronaTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.getGameMode() == GameMode.CREATIVE) {
                continue;
            } else if (CoronaUtil.hasCorona(player)) {
                continue;
            }
            for (Entity e : getNearbyEntities(player)) {
                int randNoMask = new Random().nextInt(3);
                int randMask = new Random().nextInt(10);
                if (CoronaUtil.hasCorona(e)) {
                    if (!CoronaUtil.hasMask(player) && randNoMask == 2) {
                        CoronaUtil.giveCorona(player);
                        Messages.sendMessage(player, "&cA mob nearby gave you COVID-19!");
                    }
                    if (CoronaUtil.hasMask(player) && randMask == 9) {
                        CoronaUtil.giveCorona(player);
                        Messages.sendMessage(player, "&cA mob nearby gave you COVID-19!");
                    }
                }
            }
        }
    }

    private ArrayList<Entity> getNearbyEntities(Player pl){
        ArrayList<Entity> nearby = new ArrayList<>();
        double range = 3;
        for (Entity e : pl.getNearbyEntities(range, range, range)){
            nearby.add(e);
        }
        return nearby;
    }

}
