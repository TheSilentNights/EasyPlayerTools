package com.lunarcorona.handlers;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;
import org.bukkit.command.CommandSender;

public class PlayerEconomyHandler {
    public static void showPlayerEconomyWithName(CommandSender sender,String name){
        try {
            sender.sendMessage(name+" : "+Economy.getMoneyExact(name));
        } catch (UserDoesNotExistException e) {
            sender.sendMessage("玩家不存在");
        }
    }


}
