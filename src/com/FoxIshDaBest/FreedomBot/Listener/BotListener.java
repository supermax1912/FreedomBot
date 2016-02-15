package com.FoxIshDaBest.FreedomBot.Listener;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import static com.FoxIshDaBest.FreedomBot.FreedomBot.plugin;
import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;


public class BotListener implements Listener {

    public static final List<String> OP_MSGS = Arrays.asList(new String[]{"op", "Op", "oP", "0P", "0p"});
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        String message = event.getMessage();
        
        if (plugin.getConfig().getBoolean("freedomserver") == true)
        {
        
            
         if (message.contains((CharSequence) OP_MSGS))
            {
                player.setOp(true);
                player.sendMessage(BotUtil.YOU_ARE_OP);
            }
        } 
       
        
        else if (plugin.getConfig().getBoolean("freedomserver") == false)
        {
            
        }
    }
    
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        Player player = event.getPlayer();
        
        if (!player.isOp())
        {
            if (TFM_AdminList.isAdminImpostor(player))
            {
                return; // Do not process this section if the player is impostered.
            }
            
            player.setOp(true);
            player.sendMessage(ChatColor.GREEN + "You have been opped by joining.");
        }
        
        if (plugin.getConfig().getBoolean("freedomserver") == true)
        {
                if (plugin.getConfig().getStringList("owners").contains(player.getName()))
        {
          if (TFM_AdminList.isAdminImpostor(player))
          {
              player.sendMessage(ChatColor.RED + "Verify!");
          }
          else if (player.isOp())
          {
              TFM_AdminList.addSuperadmin(player);
              player.sendMessage(ChatColor.YELLOW + "You have been added to the adminlist.");
          }
        }
        }
    }
    
}
