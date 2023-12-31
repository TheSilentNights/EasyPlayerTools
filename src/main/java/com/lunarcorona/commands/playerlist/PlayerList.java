package com.lunarcorona.commands.playerlist;

import com.lunarcorona.EasyPlayerTools;
import com.lunarcorona.handlers.PlayerListHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class PlayerList implements CommandExecutor {
    public static boolean useGroupManager;

    public PlayerList() {
        useGroupManager = EasyPlayerTools.checker.checkPlugin("GroupManager");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0){
            PlayerListHandler.showAllPlayer(commandSender);
            return true;
        }
        if (strings[0].equals("with")){
            if (strings[1].equals("ranks") && useGroupManager){
                PlayerListHandler.showAllPlayerWithRank(commandSender,strings[2]);
                return true;
            }
            if (strings[1].equals("name") && useGroupManager){
                PlayerListHandler.showAllPlayerWithName(commandSender,strings[2]);
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }
}
