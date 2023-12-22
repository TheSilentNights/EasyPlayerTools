package com.lunarcorona.commands;

import com.lunarcorona.LunarTools;
import com.lunarcorona.players.Handler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerList implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings[0].equals("")){
            Handler.showAllPlayer(commandSender);
            return true;
        }
        if (strings[0].equals("with")){
            if (strings[1].equals("ranks")){
                Handler.showAllPlayerWithRank(commandSender);
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }
}
