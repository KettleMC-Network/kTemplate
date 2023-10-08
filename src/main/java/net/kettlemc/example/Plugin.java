package net.kettlemc.example;

import io.github.almightysatan.slams.minimessage.AdventureMessage;
import net.kettlemc.example.config.Configuration;
import net.kettlemc.example.config.Messages;
import net.kettlemc.klanguage.api.LanguageAPI;
import net.kettlemc.klanguage.bukkit.BukkitLanguageAPI;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    public static final LanguageAPI<Player> LANGUAGE_API = BukkitLanguageAPI.of();
    private static Plugin instance;
    private final ContentManager contentManager = new ContentManager(this);
    private BukkitAudiences adventure;

    public static Plugin instance() {
        return instance;
    }

    public BukkitAudiences adventure() {
        if (this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {

        instance = this;

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

    public void sendMessage(CommandSender sender, AdventureMessage message) {
        Audience audience = this.adventure().sender(sender);
        if (sender instanceof Player) {
            Player player = (Player) sender;
            audience.sendMessage(Messages.PREFIX.value().append(message.value(LANGUAGE_API.getEntity(player))));
            return;
        }
        audience.sendMessage(Messages.PREFIX.value().append(message.value()));
    }

}
