package net.kettlemc.example;

import net.kettlemc.example.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private final ContentManager contentManager = ContentManager.instance();

    @Override
    public void onEnable() {
        getLogger().info("Hello, World!");
        if (!PluginConfig.load()) {
            getLogger().severe("Failed to load config!");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye, World!");
        PluginConfig.unload();
    }

}
