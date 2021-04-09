package me.advait.covidinminecraft;

import me.advait.covidinminecraft.commands.GiveCoronaCommand;
import me.advait.covidinminecraft.commands.GiveVaccineCommand;
import me.advait.covidinminecraft.commands.RemoveCoronaCommand;
import me.advait.covidinminecraft.listeners.*;
import me.advait.covidinminecraft.tasks.CoronaEffectsTask;
import me.advait.covidinminecraft.tasks.CoronaHealthDeprivationTask;
import me.advait.covidinminecraft.tasks.NearestCoronaTask;
import me.advait.covidinminecraft.util.CraftingManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class COVIDInMinecraft extends JavaPlugin {

    private static COVIDInMinecraft instance;
    public static COVIDInMinecraft getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        registerEvents();
        runTasks();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerCommands() {
        getCommand("givecorona").setExecutor(new GiveCoronaCommand());
        getCommand("givevaccine").setExecutor(new GiveVaccineCommand());
        getCommand("removecorona").setExecutor(new RemoveCoronaCommand());
        CraftingManager.addAllRecipes();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ItemConsumptionListener(), this);
        getServer().getPluginManager().registerEvents(new MobAttackListener(), this);
        getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    private void runTasks() {
        getServer().getScheduler().scheduleSyncRepeatingTask(getInstance(), new CoronaEffectsTask(), 100, 5);
        getServer().getScheduler().scheduleSyncRepeatingTask(getInstance(), new CoronaHealthDeprivationTask(), 0, 20 * 10);
        getServer().getScheduler().scheduleSyncRepeatingTask(getInstance(), new NearestCoronaTask(), 100, 20 * 3);
    }

}
