package com.lunarcorona;


import com.lunarcorona.commands.economy.PlayerEconomy;
import com.lunarcorona.commands.playerlist.PlayerList;
import com.lunarcorona.commands.playerlist.PlayerListTabCompleter;
import com.lunarcorona.plugins.PluginChecker;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;


public class EasyPlayerTools extends JavaPlugin {
    public static EasyPlayerTools instance;
    public static PluginChecker checker;
    @Override
    public void onEnable() {
        instance = this;
        checker = new PluginChecker(instance);

        //reg all the commands
        PluginCommand commands = getCommand("playerlist");
        commands.setTabCompleter(new PlayerListTabCompleter());
        commands.setExecutor(new PlayerList());

        PluginCommand playerEconomy = getCommand("playerEconomy");
        playerEconomy.setExecutor(new PlayerEconomy());
    }

    @Override
    public void onDisable() {

    }


}