package com.lunarcorona.commands.tplocation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TpLocationTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        switch (strings.length){
            case 1:
                return List.of("record","show","tp","delete");
            case 2:
                if (strings[0].equals("show") || strings[0].equals("delete") || strings[0].equals("tp")){
                    //此处应返回已记录的传送点列表
                    return null;
                }
                return null;
            default:
                return null;
        }
    }
}
