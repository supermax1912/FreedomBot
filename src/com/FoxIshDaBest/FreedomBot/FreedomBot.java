package com.FoxIshDaBest.FreedomBot;

// FreedomBot Imports
import com.FoxIshDaBest.FreedomBot.Commands.Command_adminhelp;
import com.FoxIshDaBest.FreedomBot.Commands.Command_freedombot;
import com.FoxIshDaBest.FreedomBot.Commands.Command_opme;
import com.FoxIshDaBest.FreedomBot.Listener.BotListener;

// Java Imports
import java.util.logging.Level;

// Bukkit Imports
import org.bukkit.Server;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FreedomBot extends JavaPlugin {

    public static FreedomBot plugin;
    public static YamlConfiguration config;
    public static Server server;

    @Override
    public void onLoad() {
        plugin = this;
        this.saveDefaultConfig();

    }

    @Override
    public void onEnable() {
        final PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new BotListener(), plugin);
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been successfully enabled!", plugin.getDescription().getVersion());
        getConfig().options().copyDefaults(true);
        saveConfig();
    this.getCommand("freedombot").setExecutor(new Command_freedombot(plugin));
    this.getCommand("opme").setExecutor(new Command_opme(plugin));
    this.getCommand("adminhelp").setExecutor(new Command_adminhelp(plugin));
    
    }

    @Override
    public void onDisable() {
        plugin.getLogger().log(Level.INFO, "FreedomBot v{0} has been disabled!", plugin.getDescription().getVersion());

    }

}
