package com.lunarcorona.commands.groupmanager;

import com.lunarcorona.EasyPlayerTools;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IGroupManagerTabCompleter implements TabCompleter {
    private static final OverloadedWorldHolder holder = EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getWorldData(EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getDefaultWorld().getName());

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1){
            return List.of("add","remove");
        } else if (strings.length == 3) {
            List<String> arr = new ArrayList<>();
            holder.getGroupList().forEach(group -> {
                arr.add(group.getName());
            });
            return arr;
        }else{
            return null;
        }
    }
}
