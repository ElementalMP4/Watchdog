package main.java.watchdog.listeners;

import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import main.java.watchdog.config.GlobalVars;

public class MinecraftEventListener implements Listener {
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		String name = event.getPlayer().getName();
		String message = event.getMessage();
		String channelID = GlobalVars.getConfig().getChannelID();
		if (channelID == null) GlobalVars.getServer().getLogger().log(Level.SEVERE, "No channel ID provided!");
		else GlobalVars.getJDA().getTextChannelById(channelID).sendMessage("**" + name + ": **" + message).queue();
	}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String channelID = GlobalVars.getConfig().getChannelID();
		String joinMessage = GlobalVars.getConfig().getJoinMessage(); 
		if (channelID == null) GlobalVars.getServer().getLogger().log(Level.SEVERE, "No channel ID provided!");
		else GlobalVars.getJDA().getTextChannelById(channelID).sendMessage("`" + player.getName() + "` **" + joinMessage + "**").queue();
    }
	
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		String channelID = GlobalVars.getConfig().getChannelID();
		String leaveMessage = GlobalVars.getConfig().getLeaveMessage(); 
		if (channelID == null) GlobalVars.getServer().getLogger().log(Level.SEVERE, "No channel ID provided!");
		else GlobalVars.getJDA().getTextChannelById(channelID).sendMessage("`" + player.getName() + "` **" + leaveMessage + "**").queue();
    }
}
