package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.FreedomBot;
import java.util.Set;
import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_adminhelp implements CommandExecutor {

    private FreedomBot plugin;

    public Command_adminhelp(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        
        if (plugin.getConfig().getBoolean("freedomserver") == true) {
            if (args.length == 0) {
               sender.sendMessage(ChatColor.RED + "Usage: /adminhelp <message>");
               return true;
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (TFM_AdminList.isSuperAdmin(player)) {
                    String name = ChatColor.RED + sender.getName() + ChatColor.GRAY + ": ";
                    String message = ChatColor.RESET + args[0];
                    player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Admin Help" + ChatColor.DARK_GRAY + "]" + name + message);
                }
            }
        } 
        
        else if (plugin.getConfig().getBoolean("freedomserver") == false) {
            sender.sendMessage(ChatColor.RED + "Error: FreedomServer isn't enabled in the config!");
            return true;
        }



        return true;

    }

}
