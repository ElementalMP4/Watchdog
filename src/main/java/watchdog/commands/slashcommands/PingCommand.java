package main.java.watchdog.commands.slashcommands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class PingCommand extends AbstractCommand {

	@Override
	public void run(SlashCommandEvent event) {
		event.reply("Pong! " + event.getJDA().getGatewayPing() + "ms latency").queue();
		
	}

	@Override
	public String getName() {
		return "ping";
	}

}
