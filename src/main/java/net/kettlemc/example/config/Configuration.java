package net.kettlemc.example.config;

import io.github.almightysatan.jaskl.Config;
import io.github.almightysatan.jaskl.entries.StringConfigEntry;
import io.github.almightysatan.jaskl.hocon.HoconConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuration {

    public static final Path CONFIG_DIRECTORY = Paths.get("plugins", "Plugin");
    private static final Config CONFIG = HoconConfig.of(CONFIG_DIRECTORY.resolve("config.conf").toFile(), "Config for example values");

    public static final StringConfigEntry PERMISSION_LAYOUT = StringConfigEntry.of(CONFIG, "settings.permission-prefix", "The default permission layout", "system.%s");

    private Configuration() {
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
