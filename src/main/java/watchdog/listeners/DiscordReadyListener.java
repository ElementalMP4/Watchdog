package main.java.watchdog.listeners;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import main.java.watchdog.Watchdog;
import main.java.watchdog.commands.Command;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class DiscordReadyListener implements EventListener {

	private Watchdog plugin = Watchdog.getPlugin(Watchdog.class);
	
	@Override
	public void onEvent(GenericEvent event) {
		if (event instanceof ReadyEvent) {
			plugin.getLogger().log(Level.INFO, "Logged in as "
					+ event.getJDA().getSelfUser().getName() + "#" + event.getJDA().getSelfUser().getDiscriminator());
			List<Command> commands = Arrays.asList(Command.values());
			
			for (Command command : commands) {
				event.getJDA().upsertCommand(command.getName(), command.getDescription());
				plugin.getLogger().log(Level.INFO, "Upserted SlashCommand "+ command.getName());
			}
		}
	}
}