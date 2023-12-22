package com.lunarcorona.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlayerListTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1){
            return List.of("with");
        } else if (strings.length == 2) {
            return List.of("ranks");
        } else if (strings.length == 3) {
            return List.of("admin","player","helper");
        }else{
            return null;
        }
    }
}
