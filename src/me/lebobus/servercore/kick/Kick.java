package me.lebobus.servercore.kick;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lebobus.servercore.utils.Prefix;

public class Kick implements CommandExecutor {

     public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!sender.hasPermission("core.kick")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1 || args.length < 1) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/kick &7[&bplayer&7]"));
                    return true;
            }
            
            
            OfflinePlayer target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
            	if (target == null) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is not online&7."));
            		return true;
            	}
            	
            	if (target.isOnline()) {
            		((Player) target).kickPlayer(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You have been &bkicked&7."));
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has kicked&b "+target.getName()+"&7."));
            		return true;
            	}

            }
            
            
            
		}
	return true;
     }
}