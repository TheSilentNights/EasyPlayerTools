package com.lunarcorona.commands;

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

public class PlayerListTabCompleter implements TabCompleter {
    OverloadedWorldHolder holder = EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getWorldData(EasyPlayerTools.getPlugin(GroupManager.class).getWorldsHolder().getDefaultWorld().getName());

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) {
            return List.of("with");
        } else if (strings.length == 2) {
            return List.of("rank","name");
        } else if (strings.length == 3) {
            List<String> list = new ArrayList<>();
            holder.getGroupList().forEach(group -> list.add(group.getName()));
            return list;
        } else {
            return null;
        }
    }
}
