package main.java.watchdog.commands;

import main.java.watchdog.commands.slashcommands.AbstractCommand;
import main.java.watchdog.commands.slashcommands.OnlineCommand;
import main.java.watchdog.commands.slashcommands.PingCommand;

public enum Command {
	PING("ping", "Get the API latency of the bot", new PingCommand()),
	ONLNIE("online", "Get a list of online players", new OnlineCommand());
	
	private String name;
	private AbstractCommand command;
	private String description;
	
	private Command(String name, String description, AbstractCommand command) {
		this.name = name;
		this.description = description;
		this.command = command;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public AbstractCommand getCommand()
	{
		return this.command;
	}

}
