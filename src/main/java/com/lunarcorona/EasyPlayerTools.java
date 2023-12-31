package com.lunarcorona;


import com.lunarcorona.commands.groupmanager.IGroupManager;
import com.lunarcorona.commands.groupmanager.IGroupManagerTabCompleter;
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
        PluginCommand commands = getCommand("lplayerlist");
        commands.setTabCompleter(new PlayerListTabCompleter());
        commands.setExecutor(new PlayerList());

        PluginCommand iGroupManager =getCommand("lGroupManager");
        iGroupManager.setExecutor(new IGroupManager());
        iGroupManager.setTabCompleter(new IGroupManagerTabCompleter());
    }

    @Override
    public void onDisable() {
        instance = null;
        checker = null;
    }


}