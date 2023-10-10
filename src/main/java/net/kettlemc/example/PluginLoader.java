package net.kettlemc.example;


import net.kettlemc.example.loading.Loadable;

public class PluginLoader extends org.bukkit.plugin.java.JavaPlugin {

    Loadable plugin;

    @Override
    public void onLoad() {
        this.plugin = new Plugin(this);
        plugin.onLoad();
    }

    @Override
    public void onEnable() {
        plugin.onEnable();
    }

    @Override
    public void onDisable() {
        plugin.onDisable();
    }


}
