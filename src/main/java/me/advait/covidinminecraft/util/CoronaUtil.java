package me.advait.covidinminecraft.util;

import me.advait.covidinminecraft.COVIDInMinecraft;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class CoronaUtil {

    private static ArrayList<Entity> coronaCarriers = new ArrayList<>();

    public static void giveCorona(Entity entity) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        coronaCarriers.add(entity);
        if (entity instanceof Player) {
            Player p = (Player) entity;
            Bukkit.broadcastMessage(Messages.color("&c" + p.getName() + " got COVID-19!"));
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 100, 1);
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(COVIDInMinecraft.getInstance(),
                    () -> {
                Messages.sendActionBar(p, "&6You have COVID-19!");
                if (!hasCorona(p)) {
                    Messages.sendActionBar(p, " ");
                    return;
                }
                    }, 0, 5);
        }
    }

    public static boolean hasCorona(Entity entity) {
        return coronaCarriers.contains(entity);
    }

    public static void removeCorona(Entity entity) {
        if (!hasCorona(entity)) {
            return;
        }
        coronaCarriers.remove(entity);
        LivingEntity e = (LivingEntity) entity;
        e.removePotionEffect(PotionEffectType.WEAKNESS);
        e.removePotionEffect(PotionEffectType.SLOW);
    }

    public static boolean hasMask(Player player) {
        ItemStack helm = player.getInventory().getHelmet();
        if (helm == null) {
            return false;
        }
        if (helm.getItemMeta().getDisplayName().contains("Mask") && helm.getType() == Material.PLAYER_HEAD) {
            return true;
        }
        return false;
    }


    public static void giveVaccine(Player player) {
        ItemStack vaccine = new ItemStack(Material.COOKIE);
        ItemMeta itemMeta = vaccine.getItemMeta();
        itemMeta.setDisplayName(Messages.color("&6COVID-19 Vaccine"));
        vaccine.setItemMeta(itemMeta);
        player.getInventory().addItem(vaccine);
    }

    public static boolean hasVaccineInHand(Player player) {
        if (player.getInventory().getItemInMainHand().getType() == Material.COOKIE && player.getInventory().getItemInMainHand().hasItemMeta()) {
            return true;
        }
        return false;
    }

    public static void removeVaccine(Player player) {
        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
    }

}
