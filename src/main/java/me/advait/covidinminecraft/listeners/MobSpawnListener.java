package me.advait.covidinminecraft.listeners;

import me.advait.covidinminecraft.util.CoronaUtil;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.Random;

public class MobSpawnListener implements Listener {

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            CoronaUtil.giveCorona(event.getEntity());
            return;
        }
        int rand = new Random().nextInt(4);
        if (rand == 3) {
            CoronaUtil.giveCorona(event.getEntity());
        }
    }

}
