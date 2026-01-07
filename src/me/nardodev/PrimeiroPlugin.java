package me.nardodev;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PrimeiroPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin iniciado");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!command.getName().equalsIgnoreCase("banc")) {
            return false;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Uso correto: /banc <jogador>");
            return true;
        }

        String alvo = args[0];
        String motivo = "Uso de trapaças";

        Bukkit.getBanList(BanList.Type.NAME)
                .addBan(alvo, motivo, null, sender.getName());

        Player p = Bukkit.getPlayerExact(alvo);
        if (p != null) {
            p.kickPlayer(ChatColor.RED + "Você foi banido.\nMotivo: " + motivo);
        }

        sender.sendMessage(ChatColor.GREEN + "Jogador " + alvo + " banido com sucesso.");
        return true;
    }
}
