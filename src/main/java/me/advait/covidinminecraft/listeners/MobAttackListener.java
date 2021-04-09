package me.advait.covidinminecraft.listeners;

import me.advait.covidinminecraft.util.CoronaUtil;
import me.advait.covidinminecraft.util.Messages;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class MobAttackListener implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity target = event.getEntity();
        if (!(CoronaUtil.hasCorona(target)) && (target instanceof Player)) {
            if (CoronaUtil.hasCorona(target)) {
                return;
            }
            if (CoronaUtil.hasCorona(damager)) {
                int randNoMask = new Random().nextInt(10);
                int randMask = new Random().nextInt(10);
                if (!CoronaUtil.hasMask((Player) target) && randNoMask <= 8) {
                    CoronaUtil.giveCorona(target);
                    Messages.sendMessage(target, "&cYou got attacked by a mob and now have COVID-19!");
                    return;
                } else if (CoronaUtil.hasMask((Player) target) && randMask <= 2) {
                    CoronaUtil.giveCorona(target);
                    Messages.sendMessage(target, "&cYou got attacked by a mob and now have COVID-19!");
                    return;
                }
            }
        }

        if (damager instanceof Player && target instanceof Player) {
            if (CoronaUtil.hasVaccineInHand((Player) damager)) {
                if (!(CoronaUtil.hasCorona(target))) {
                    Messages.sendMessage(damager, "&cThis player does not have coronavirus!");
                    return;
                }
                if (CoronaUtil.hasCorona(target)) {
                    if (CoronaUtil.hasMask((Player) damager)) {
                        int randMask = new Random().nextInt(5);
                        if (randMask == 4) {
                            CoronaUtil.giveCorona(damager);
                            Messages.sendMessage(damager, "&cYou got COVID-19 from injecting someone with the vaccine!");
                        }
                        Messages.sendMessage(damager, "&aYou injected " + target.getName() + " with the vaccine!");
                        CoronaUtil.removeCorona(target);
                        CoronaUtil.removeVaccine((Player) damager);
                        Messages.sendMessage(target, "&aYou were injected with the vaccine! You do not have COVID-19 anymore!");
                        return;
                    } else if (!CoronaUtil.hasMask((Player) damager)) {
                        CoronaUtil.giveCorona(damager);
                        Messages.sendMessage(damager, "&cYou got COVID-19 from injecting someone with the vaccine!");
                    }
                    Messages.sendMessage(damager, "&aYou injected " + target.getName() + " with the vaccine!");
                    CoronaUtil.removeCorona(target);
                    CoronaUtil.removeVaccine((Player) damager);
                    Messages.sendMessage(target, "&aYou were injected with the vaccine! You do not have COVID-19 anymore!");
                    return;
                }
            }
        }

    }
}
