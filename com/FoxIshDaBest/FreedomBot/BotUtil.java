package com.FoxIshDaBest.FreedomBot;

import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class BotUtil {
    public static final String YOU_ARE_OP = ChatColor.YELLOW + "You are now op!";
    public static final String YOU_ARE_NOT_OP = ChatColor.YELLOW + "You are no longer op!";
    
    
    public void derpName()
    {
        Collection<? extends Player> onlinePlayer = Bukkit.getServer().getOnlinePlayers();
        for (Player player : onlinePlayer)
        {
            player.setDisplayName(ChatColor.RED + "derp" + ChatColor.RESET);
        }
    }

}
