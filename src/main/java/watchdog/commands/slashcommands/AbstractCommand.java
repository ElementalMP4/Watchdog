package main.java.watchdog.commands.slashcommands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public abstract class AbstractCommand {
	public abstract void run(SlashCommandEvent event);
	public abstract String getName();
}
