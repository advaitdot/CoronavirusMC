package me.advait.covidinminecraft.util;

import me.advait.covidinminecraft.COVIDInMinecraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class CraftingManager {

    private static void createMaskRecipe() {
        ItemStack mask = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta maskMeta = (SkullMeta) mask.getItemMeta();
        maskMeta.setOwningPlayer(Bukkit.getOfflinePlayer("Canadian_Shooter"));
        maskMeta.setDisplayName(Messages.color("&6Mask"));
        mask.setItemMeta(maskMeta);

        NamespacedKey namespacedKey = new NamespacedKey(COVIDInMinecraft.getInstance(), "mask_key");
        ShapedRecipe maskRecipe = new ShapedRecipe(namespacedKey, mask);
        maskRecipe.shape("*&*", "&&&", "*&*");
        maskRecipe.setIngredient('*', Material.IRON_INGOT);
        maskRecipe.setIngredient('&', Material.PINK_WOOL);
        Bukkit.getServer().addRecipe(maskRecipe);
    }

    private static void createVaccineRecipe() {
        ItemStack vaccine = new ItemStack(Material.COOKIE, 1);
        ItemMeta vaccineMeta = vaccine.getItemMeta();
        vaccineMeta.setDisplayName(Messages.color("&6COVID-19 Vaccine"));
        vaccine.setItemMeta(vaccineMeta);

        NamespacedKey namespacedKey = new NamespacedKey(COVIDInMinecraft.getInstance(), "vaccine_key");
        ShapedRecipe vaccineRecipe = new ShapedRecipe(namespacedKey, vaccine);
        vaccineRecipe.shape("%$%", "%$%", " % ");
        vaccineRecipe.setIngredient('%', Material.GLASS);
        vaccineRecipe.setIngredient('$', Material.DIAMOND);
        Bukkit.getServer().addRecipe(vaccineRecipe);
    }

    public static void addAllRecipes() {
        createMaskRecipe();
        createVaccineRecipe();
    }

}
