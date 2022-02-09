package main.java.watchdog.commands.slashcommands;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;

import main.java.watchdog.Watchdog;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class OnlineCommand extends AbstractCommand {

	private Watchdog plugin = Watchdog.getPlugin(Watchdog.class);
	
	@Override
	public void run(SlashCommandEvent event) {
		@SuppressWarnings("unchecked")
		List<Player> players = (List<Player>) plugin.getServer().getOnlinePlayers();
		List<String> playerNames = players.stream().map(player -> player.getName()).collect(Collectors.toList());
		event.reply(String.join(", ", playerNames)).queue();
		
	}

	@Override
	public String getName() {
		return "online";
	}

}
