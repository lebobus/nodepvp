package me.lebobus.servercore.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.ChatColor;

public class PluginsHider implements Listener {

	private Prefix prefix = new Prefix();
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
	    Player p = event.getPlayer();
	    
	    String msg = event.getMessage();
	    if ((!p.isOp()) && (msg.equalsIgnoreCase("/version") || msg.equalsIgnoreCase("/ver") || msg.equalsIgnoreCase("/?") || msg.equalsIgnoreCase("/bukkit:help") || msg.equalsIgnoreCase("/bukkit:ver") || msg.equalsIgnoreCase("/bukkit:version") || msg.equalsIgnoreCase("/bukkit:?") || msg.equalsIgnoreCase("/about") || msg.equalsIgnoreCase("/icanhasbukkit") || msg.equalsIgnoreCase("/pl") || msg.equalsIgnoreCase("/plugins"))) {
	        event.setCancelled(true);
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&bnodepvp.com &7does not share its plugins."));
	        return;
	    }
    }
	
}


