package com.lunarcorona.repo;

import com.lunarcorona.EasyPlayerTools;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DataLoader {
    private String targetFile;
    private File rootPath;
    private YamlConfiguration configuration;

    public DataLoader(String targetFile) {
        this.targetFile = targetFile;
        this.rootPath = EasyPlayerTools.instance.getDataFolder();
        init();
    }

    public void init(){
        File file = new File(rootPath,targetFile);
        if (file.exists()){
            configuration = YamlConfiguration.loadConfiguration(file);
        }else{
            try{
                file.createNewFile();
                configuration = YamlConfiguration.loadConfiguration(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(){
        try {
            configuration.save(new File(rootPath,targetFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(String kay ,Object data){
        configuration.set(kay,data);
    }

    public Set<String> getKeys(){
        return configuration.getKeys(false);
    }

    public List<String> getStringList(String key){
        return configuration.getStringList(key);
    }

    public List<Double> getDoubleList(String key){
        return configuration.getDoubleList(key);
    }

    public int getInt(String key){
        return configuration.getInt(key);
    }

    public String getString(String key){
        return configuration.getString(key);
    }

    public void delete(String key){
        YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(new File(rootPath, targetFile));
        getKeys().stream().filter(keyval->!keyval.equals(key)).forEach(solvedKey->{
            newConfig.set(solvedKey,configuration.get(solvedKey));
        });
        configuration = newConfig;
    }
}
