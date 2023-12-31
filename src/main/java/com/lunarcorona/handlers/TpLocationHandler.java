package com.lunarcorona.handlers;

import com.lunarcorona.repo.DataLoader;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class TpLocationHandler {
    static DataLoader loader;

    public static void init(){
        loader = new DataLoader("location.yml");
    }

    public static void show(CommandSender sender){
        loader.getKeys().forEach(key->{
            sender.sendMessage(key + " : " +getTarget(key).toString());
        });
    }

    public static void record(String key, Location location){
        loader.setData(key, List.of(location.getX(), location.getY(), location.getZ()));
    }

    private static List<Double> getTarget(String key){
        return loader.getDoubleList(key);
    }

    public static void delete(String key){
        loader.delete(key);
    }

    public static void tp(String key){
        loader.getDoubleList(key);
    }

    public static void save(){
        loader.save();
    }
}
