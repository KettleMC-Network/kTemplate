package net.kettlemc.example.config;

import io.github.almightysatan.jaskl.Config;
import io.github.almightysatan.jaskl.entries.StringConfigEntry;
import io.github.almightysatan.jaskl.hocon.HoconConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PluginConfig {

    private static final Path CONFIG_PATH = Paths.get("plugins", "Plugin", "config.conf");
    private static final Config CONFIG = HoconConfig.of(CONFIG_PATH.toFile(), "Config for example values");

    public static final StringConfigEntry PREFIX = StringConfigEntry.of(CONFIG, "messages.prefix", "The prefix to use.", "[Prefix] ");

    private PluginConfig() {
    }

    public static boolean load() {
        try {
            CONFIG.load();
            CONFIG.write();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void unload() {
        CONFIG.close();
    }

    public static boolean write() {
        try {
            CONFIG.write();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
