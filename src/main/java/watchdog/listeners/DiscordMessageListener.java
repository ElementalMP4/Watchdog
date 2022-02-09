package main.java.watchdog.listeners;

import java.util.logging.Level;

import main.java.watchdog.config.GlobalVars;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.md_5.bungee.api.ChatColor;

public class DiscordMessageListener implements EventListener {
	
	@Override
	public void onEvent(GenericEvent event) {
		if (event instanceof MessageReceivedEvent) {
			MessageReceivedEvent message = (MessageReceivedEvent) event;
			
			if (message.getAuthor().getId().equals(message.getJDA().getSelfUser().getId())) return;
			
			String channelID = GlobalVars.getConfig().getChannelID();
			if (channelID == null) GlobalVars.getServer().getLogger().log(Level.SEVERE, "No message logging channel provided!");
			else {
				if (message.getChannel().getId().equals(channelID)) {
					GlobalVars.getServer().broadcastMessage(
							ChatColor.BLUE + "[Discord] " + ChatColor.WHITE +
							"<" + message.getAuthor().getName() + "> " + message.getMessage().getContentStripped());
				}	
			}
		}
	}

}
