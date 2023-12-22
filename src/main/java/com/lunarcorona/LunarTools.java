package com.lunarcorona;


import com.lunarcorona.commands.PlayerList;
import com.lunarcorona.commands.PlayerListTabCompleter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LunarTools extends JavaPlugin {
    public static LunarTools instance;
    @Override
    public void onEnable() {
        instance = this;
        //reg all the commands
        PluginCommand commands = getCommand("playerlist");
        commands.setTabCompleter(new PlayerListTabCompleter());
        commands.setExecutor(new PlayerList());

    }

    @Override
    public void onDisable() {

    }


}