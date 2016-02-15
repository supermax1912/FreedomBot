package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.FreedomBot;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_freedombot implements CommandExecutor {

    private FreedomBot plugin;

    public Command_freedombot(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        
        sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v1.2" + ChatColor.DARK_GRAY + "-----");
        sender.sendMessage(ChatColor.YELLOW + "You are running " + ChatColor.GOLD + ChatColor.BOLD + "FreedomBot v1.3!");
        sender.sendMessage(ChatColor.YELLOW + "FreedomBot is a FreeOp server bot that makes admin's jobs easier.");
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Commands: " + ChatColor.YELLOW + "/freedombot, /opme, /adminhelp");
        sender.sendMessage(ChatColor.YELLOW + "More features coming soon!");
        sender.sendMessage(ChatColor.YELLOW + "Want to help with the development of the FreedomBot?");
        sender.sendMessage(ChatColor.YELLOW + "Go to https://github.com/RainbowFreedomDev/FreedomBot!");
        sender.sendMessage(ChatColor.DARK_GRAY + "-----" + ChatColor.DARK_RED + "FreedomBot v1.2" + ChatColor.DARK_GRAY + "-----");

        return true;

    }
    
}
