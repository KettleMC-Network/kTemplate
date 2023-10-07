package net.kettlemc.example;

import net.kettlemc.example.config.Configuration;
import net.kettlemc.example.config.Messages;
import net.kettlemc.klanguage.api.LanguageAPI;
import net.kettlemc.klanguage.bukkit.BukkitLanguageAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    public static final LanguageAPI<Player> LANGUAGE_API = BukkitLanguageAPI.of();
    private final ContentManager contentManager = new ContentManager(this);

    @Override
    public void onEnable() {
        getLogger().info("Hello, World!");

        if (!Configuration.load()) {
            getLogger().severe("Failed to load config!");
        }

        if (!Messages.load()) {
            getLogger().severe("Failed to load messages!");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye, World!");
        Configuration.unload();
    }

}
