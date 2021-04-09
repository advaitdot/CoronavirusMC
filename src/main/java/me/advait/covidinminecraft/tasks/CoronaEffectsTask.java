package me.advait.covidinminecraft.tasks;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CoronaEffectsTask implements Runnable {

    @Override
    public void run() {
        for (World world : Bukkit.getServer().getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (CoronaUtil.hasCorona(entity)) {
                    entity.getWorld().spawnParticle(Particle.REDSTONE, entity.getLocation().clone().add(0, 2, 0), 4, new Particle.DustOptions(Color.RED, 1.5F));
                    if (entity instanceof Player) {
                        Player player = (Player) entity;
                        player.addPotionEffect(new PotionEffect(
                                PotionEffectType.WEAKNESS, 10000000, 1, false, false, false));
                        player.addPotionEffect(new PotionEffect(
                                PotionEffectType.SLOW, 10000000, 2, false, false, false));
                    }
                }
            }
        }
    }
}
