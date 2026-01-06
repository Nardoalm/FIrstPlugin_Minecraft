package me.nardodev;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PrimeiroPlugin extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + this.getClass().getSimpleName() + " iniciado com sucesso!");
    }
}
