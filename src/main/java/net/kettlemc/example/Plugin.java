package net.kettlemc.example;

import net.kettlemc.example.config.Configuration;
import net.kettlemc.example.config.Messages;
import net.kettlemc.kcommon.bukkit.ContentManager;
import net.kettlemc.kcommon.language.MessageManager;
import net.kettlemc.klanguage.api.LanguageAPI;
import net.kettlemc.klanguage.bukkit.BukkitLanguageAPI;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    public static final LanguageAPI<Player> LANGUAGE_API = BukkitLanguageAPI.of();
    private static Plugin instance;

    private final ContentManager contentManager = new ContentManager(this);
    private BukkitAudiences adventure;
    private MessageManager messageManager;

    public static Plugin instance() {
        if (instance == null) {
            throw new IllegalStateException("Plugin instance is not initialized yet!");
        }
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        this.getLogger().info("Hello, World!");

        if (!Configuration.load()) {
            this.getLogger().severe("Failed to load config!");
        }

        if (!Messages.load()) {
            this.getLogger().severe("Failed to load messages!");
        }

        this.adventure = BukkitAudiences.create(this);
        this.messageManager = new MessageManager(Messages.PREFIX, LANGUAGE_API, this.adventure());
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Goodbye, World!");
        Configuration.unload();
    }

    public BukkitAudiences adventure() {
        if (this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Deprecated
    public JavaPlugin plugin() {
        return this;
    }

    public ContentManager contentManager() {
        return contentManager;
    }

    public MessageManager messageManager() {
        return messageManager;
    }
}
