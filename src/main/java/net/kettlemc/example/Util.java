package net.kettlemc.example;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Util {

    public static boolean saveResourceAsFile(@NotNull Class<?> clazz, @NotNull String resource, @NotNull Path output) {

        URL url = clazz.getResource(resource);
        if (url == null) {
            return false;
        }
        return saveResourceAsFile(url, output);
    }

    public static boolean saveResourceAsFile(@NotNull URL resource, @NotNull Path output) {
        try {
            InputStream in = resource.openStream();
            Files.copy(in, output);
            in.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
