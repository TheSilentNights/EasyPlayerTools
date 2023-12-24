package com.lunarcorona.commands.economy;

import com.lunarcorona.EasyPlayerTools;
import com.lunarcorona.handlers.PlayerEconomyHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PlayerEconomy implements CommandExecutor {
    boolean useVault = EasyPlayerTools.checker.checkPlugin("essentials");
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!useVault){
            commandSender.sendMessage("&1你的服务器并没有添加vault,该命令无法使用喵~");
            return true;
        }
        if (strings.length == 0){
            return false;
        }
        if (strings[0].equals("name")){
            PlayerEconomyHandler.showPlayerEconomyWithName(commandSender,strings[1]);
            return true;
        }
        return false;
    }
}
