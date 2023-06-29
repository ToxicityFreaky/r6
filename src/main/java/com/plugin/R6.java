package com.plugin;

import com.plugin.command.ArenaCommand;
import com.plugin.listener.ConnectListener;
import com.plugin.listener.GameListener;
import com.plugin.manager.ArenaManager;
import com.plugin.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class R6 extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));
    }

    public ArenaManager getArenaManager() { return arenaManager; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
