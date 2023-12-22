package com.lunarcorona.players;

import com.lunarcorona.LunarTools;
import org.bukkit.command.CommandSender;

public class Handler {
    public static void showAllPlayer(CommandSender commandSender){
        commandSender.sendMessage("当前玩家:");
        LunarTools.instance.getServer().getOnlinePlayers().forEach(player -> commandSender.sendMessage(player.getName()));
    }

    public static void showAllPlayerWithRank(CommandSender commandSender){
        commandSender.sendMessage("当前在线管理:");
        LunarTools.instance.getServer().getOnlinePlayers().stream().filter(player -> player.isOp()).forEach(operator -> commandSender.sendMessage(operator.getName()));
    }
}
