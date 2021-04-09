package me.advait.covidinminecraft.listeners;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        CoronaUtil.removeCorona(event.getEntity());
        Messages.sendActionBar(event.getEntity(), " ");
    }

}
