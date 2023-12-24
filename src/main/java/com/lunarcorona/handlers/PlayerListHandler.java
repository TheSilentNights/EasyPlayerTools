package com.lunarcorona.handlers;

import com.lunarcorona.EasyPlayerTools;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.bukkit.command.CommandSender;

public class PlayerListHandler {
    private static final OverloadedWorldHolder holder = EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getWorldData(EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getDefaultWorld().getName());

    public static void showAllPlayer(CommandSender commandSender) {
        commandSender.sendMessage("当前玩家:");
        EasyPlayerTools.instance.getServer().getOnlinePlayers().forEach(player -> commandSender.sendMessage(player.getName()));
    }

    public static void showAllPlayerWithRank(CommandSender commandSender, String rank) {
        holder.getUserList().stream().filter(user -> user.getGroupName().equals(rank)).forEach(user -> {
            commandSender.sendMessage(user.getLastName() + " : " + user.getGroupName());
        });
    }

    public static void showAllPlayerWithName(CommandSender commandSender,String name){
        commandSender.sendMessage(holder.getUser(name).getLastName()+" : "+holder.getUser(name).getGroupName());
    }
}


