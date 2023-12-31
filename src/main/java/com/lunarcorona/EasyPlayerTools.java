package com.lunarcorona;


import com.lunarcorona.commands.groupmanager.IGroupManager;
import com.lunarcorona.commands.groupmanager.IGroupManagerTabCompleter;
import com.lunarcorona.commands.playerlist.PlayerList;
import com.lunarcorona.commands.playerlist.PlayerListTabCompleter;
import com.lunarcorona.commands.tplocation.TpLocation;
import com.lunarcorona.commands.tplocation.TpLocationTabCompleter;
import com.lunarcorona.handlers.TpLocationHandler;
import com.lunarcorona.plugins.PluginChecker;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;


public class EasyPlayerTools extends JavaPlugin {
    public static EasyPlayerTools instance;
    public static PluginChecker checker;
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()){
            saveDefaultConfig();
        }
        instance = this;
        checker = new PluginChecker(instance);
        TpLocationHandler.init();

        //reg all the commands
        PluginCommand commands = getCommand("lplayerlist");
        commands.setTabCompleter(new PlayerListTabCompleter());
        commands.setExecutor(new PlayerList());

        PluginCommand iGroupManager =getCommand("lPlayerGroupManager");
        iGroupManager.setExecutor(new IGroupManager());
        iGroupManager.setTabCompleter(new IGroupManagerTabCompleter());

        PluginCommand lTpLocation = getCommand("lTpLocation");
        lTpLocation.setExecutor(new TpLocation());
        lTpLocation.setTabCompleter(new TpLocationTabCompleter());
    }

    @Override
    public void onDisable() {
        instance = null;
        checker = null;
        TpLocationHandler.save();
    }


}