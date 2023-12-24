package com.lunarcorona.commands.groupmanager;

import com.lunarcorona.EasyPlayerTools;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class IGroupManager implements CommandExecutor {
    private static final OverloadedWorldHolder holder = EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getWorldData(EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getDefaultWorld().getName());

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length != 3 && strings.length != 2){
            commandSender.sendMessage("你必须输入三个字段->add name group");
            return false;
        }
        if (strings[0].equals("add")){
            holder.getUser(strings[1]).setGroup(holder.getGroup(strings[2]));
            return true;
        }
        if (strings[0].equals("remove")){
            holder.getUser(strings[1]).setGroup(holder.getDefaultGroup());
            return true;
        }
        return false;
    }
}
