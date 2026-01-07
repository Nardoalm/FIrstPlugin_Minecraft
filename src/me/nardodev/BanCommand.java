package me.nardodev;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage("ARGS LENGTH = " + args.length);

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Uso: /banc <jogador>");
            return true;
        }

        String targetName = args[0];
        String motivo = "Uso de trapaças";

        Bukkit.getBanList(BanList.Type.NAME)
                .addBan(targetName, motivo, null, sender.getName());

        Player target = Bukkit.getPlayerExact(targetName);
        if (target != null) {
            target.kickPlayer(ChatColor.RED + "Você foi banido.\nMotivo: " + motivo);
        }

        sender.sendMessage(ChatColor.GREEN + "Jogador banido com sucesso.");
        return true;
    }
}
