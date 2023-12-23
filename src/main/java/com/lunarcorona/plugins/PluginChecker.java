package com.lunarcorona.plugins;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class PluginChecker {
    private final JavaPlugin instance;
    public PluginChecker(JavaPlugin instance) {
        this.instance = instance;
    }

    public boolean checkPlugin(String pluginName){
        return !Arrays.stream(instance.getServer().getPluginManager().getPlugins()).toList().isEmpty();
    }
}
