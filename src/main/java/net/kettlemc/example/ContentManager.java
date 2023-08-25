package net.kettlemc.example;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ContentManager {

    private static ContentManager instance;
    private static JavaPlugin plugin;

    private ContentManager() {
        instance = this;
        plugin = JavaPlugin.getPlugin(Plugin.class);
    }

    public static ContentManager instance() {
        return instance;
    }

    public void registerCommand(String name, CommandExecutor executor) {
        PluginCommand command = plugin.getCommand(name);
        if (command != null) {
            command.setExecutor(executor);
        }
    }

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

}
