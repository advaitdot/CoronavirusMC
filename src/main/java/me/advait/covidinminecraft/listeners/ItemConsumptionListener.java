package me.advait.covidinminecraft.listeners;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Random;

public class ItemConsumptionListener implements Listener {

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        int randRaw = new Random().nextInt(3);
        Material food = event.getItem().getType();
        if (CoronaUtil.hasCorona(event.getPlayer())) {
            return;
        }
        if (food == Material.PORKCHOP || food == Material.COD || food == Material.SALMON || food == Material.BEEF || food == Material.CHICKEN || food == Material.RABBIT || food == Material.MUTTON) {
            Messages.sendMessage(event.getPlayer(), "&cCareful, raw food may have coronavirus!");
            if (randRaw == 2) {
                CoronaUtil.giveCorona(event.getPlayer());
                Messages.sendMessage(event.getPlayer(), "&cYou got COVID-19 from eating raw food!");
                return;
            }
        }
    }


}
