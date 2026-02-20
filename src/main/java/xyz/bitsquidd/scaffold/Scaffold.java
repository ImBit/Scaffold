package xyz.bitsquidd.scaffold;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Scaffold extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hooray, the plugin is enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

}
