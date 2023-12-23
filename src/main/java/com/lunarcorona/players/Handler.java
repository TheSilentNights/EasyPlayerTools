package com.lunarcorona.players;

import com.lunarcorona.EasyPlayerTools;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.User;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.bukkit.command.CommandSender;

import java.util.Comparator;

public class Handler {
    public static void showAllPlayer(CommandSender commandSender){
        commandSender.sendMessage("当前玩家:");
        EasyPlayerTools.instance.getServer().getOnlinePlayers().forEach(player -> commandSender.sendMessage(player.getName()));
    }

    public static void showAllPlayerWithRank(CommandSender commandSender){
        OverloadedWorldHolder holder = EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getWorldData(EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getDefaultWorld().getName());
        holder.getUserList().stream().sorted(Comparator.comparing(User::getGroupName)).forEach(user -> {
            commandSender.sendMessage(user.getName()+" : "+user.getGroupName());
        });
    }}
