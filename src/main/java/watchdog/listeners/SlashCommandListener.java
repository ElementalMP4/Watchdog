package main.java.watchdog.listeners;

import java.util.Arrays;

import main.java.watchdog.commands.Command;
import main.java.watchdog.commands.slashcommands.AbstractCommand;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class SlashCommandListener implements EventListener {

	@Override
	public void onEvent(GenericEvent event) {
		if (event instanceof SlashCommandEvent) {
			SlashCommandEvent commandEvent = (SlashCommandEvent) event;
			Command command = Arrays.asList(Command.values())
					.stream()
					.filter(cmd -> cmd.getName().equals(commandEvent.getName()))
					.findFirst()
					.orElse(null);
			AbstractCommand slashCommand = command.getCommand();
			slashCommand.run(commandEvent);
		}
	}
}