package com.lunarcorona.commands.tplocation;

import com.lunarcorona.handlers.TpLocationHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpLocation implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        switch (strings[0]){
            case "record":
                //编写记录存储逻辑
                if (commandSender instanceof Player){
                    TpLocationHandler.record(strings[1],((Player)commandSender).getLocation());
                }else{
                    return false;
                }
                return true;
            case "show":
                //编写展示逻辑
                TpLocationHandler.show(commandSender);
                return true;
            case "tp":
                //编写传送逻辑
                return true;
            case "delete":
                //编写删除逻辑
                TpLocationHandler.delete(strings[1]);
                return true;
            default:
                return false;
        }
    }
}
