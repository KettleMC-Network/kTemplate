package net.kettlemc.example;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class ContentManager {

    private final @NotNull JavaPlugin plugin;

    public ContentManager(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers a command with the given name and executor.
     *
     * @param name     The name of the command.
     * @param executor The executor of the command (the class the command is registered in).
     */
    public void registerCommand(@NotNull String name, @NotNull CommandExecutor executor) {
        PluginCommand command = plugin.getCommand(name);
        if (command != null) {
            command.setExecutor(executor);
        }
    }

    /**
     * Registers a listener.
     *
     * @param listener The listener to register.
     */
    public void registerListener(@NotNull Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

}
