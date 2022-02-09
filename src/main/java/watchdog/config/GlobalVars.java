package main.java.watchdog.config;

import java.util.List;

import org.bukkit.Server;

import main.java.watchdog.commands.slashcommands.AbstractCommand;
import net.dv8tion.jda.api.JDA;

public class GlobalVars {
	private static JDA jda;
	private static Server server;
	private static ConfigService config;
	private static List<AbstractCommand> slashCommands;
	
	public static void setJDA(JDA newJda) { 
		jda = newJda;
	}
	
	public static void setServer(Server newServer) { 
		server = newServer;
	}
	
	public static void setConfig(ConfigService newConfig) { 
		config = newConfig;
	}
	
	public static void setSlashCommands(List<AbstractCommand> commands) {
		slashCommands = commands;
	}
	
	public static JDA getJDA() {
		return jda;
	}
	
	public static Server getServer() {
		return server;
	}
	
	public static ConfigService getConfig() {
		return config;
	}
	
	public static List<AbstractCommand> getSlashCommands() {
		return slashCommands;
	}
}
