package net.kettlemc.example;

import io.github.almightysatan.slams.minimessage.AdventureMessage;
import net.kettlemc.example.config.Configuration;
import net.kettlemc.example.config.Messages;
import net.kettlemc.example.loading.Loadable;
import net.kettlemc.kcommon.bukkit.ContentManager;
import net.kettlemc.klanguage.api.LanguageAPI;
import net.kettlemc.klanguage.bukkit.BukkitLanguageAPI;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin implements Loadable {

    public static final LanguageAPI<Player> LANGUAGE_API = BukkitLanguageAPI.of();
    private static Plugin instance;

    private final ContentManager contentManager;
    private final JavaPlugin plugin;
    private BukkitAudiences adventure;

    public Plugin(JavaPlugin plugin) {
        this.plugin = plugin;
        this.contentManager = new ContentManager(plugin);
    }

    public static Plugin instance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        this.plugin.getLogger().info("Hello, World!");

        if (!Configuration.load()) {
            this.plugin.getLogger().severe("Failed to load config!");
        }

        if (!Messages.load()) {
            this.plugin.getLogger().severe("Failed to load messages!");
        }
    }

    @Override
    public void onDisable() {
        this.plugin.getLogger().info("Goodbye, World!");
        Configuration.unload();
    }

    public BukkitAudiences adventure() {
        if (this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    public void sendMessage(CommandSender sender, AdventureMessage message) {
        Audience audience = this.adventure().sender(sender);
        if (sender instanceof Player) {
            Player player = (Player) sender;
            audience.sendMessage(Messages.PREFIX.value().append(message.value(LANGUAGE_API.getEntity(player))));
            return;
        }
        audience.sendMessage(Messages.PREFIX.value().append(message.value()));
    }

    public JavaPlugin plugin() {
        return plugin;
    }

    public ContentManager contentManager() {
        return contentManager;
    }
}
