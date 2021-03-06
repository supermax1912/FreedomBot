package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import com.FoxIshDaBest.FreedomBot.FreedomBot;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_opme implements CommandExecutor {

    private FreedomBot plugin;

    public Command_opme(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player) sender;
        if (plugin.getConfig().getBoolean("freedomserver") == true) {
            if (TFM_AdminList.isAdminImpostor(player)) {
                sender.sendMessage(ChatColor.RED + "You are an imposter. Verify!");
                return true;
            } else if (!(player.isOp())) {
                Bukkit.broadcastMessage(ChatColor.AQUA + "FreedomBot - Opping " + sender.getName());
                player.setOp(true);
                sender.sendMessage(BotUtil.YOU_ARE_OP);
            } else if (player.isOp()) {
                sender.sendMessage(ChatColor.RED + "Error: You are already op!");
            }
        } else if (plugin.getConfig().getBoolean("freedomserver") == false) {
            sender.sendMessage(ChatColor.RED + "Error: FreedomServer isn't enabled in the config!");
            return true;
        }

        return true;

    }

}
