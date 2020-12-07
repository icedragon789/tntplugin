package com.bplaczek;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Test extends JavaPlugin {

    private static Test instance;

    private static Test getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info("boom plugin enabled");
        PluginManager pm = getServer().getPluginManager();
        TestListener listener = new TestListener(this);

        pm.registerEvents(listener, this);

        //set boom as a command
        this.getCommand("boom").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        getLogger().info("boom plugin disabled");
    }
}

