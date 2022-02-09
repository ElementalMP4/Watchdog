package main.java.watchdog.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import main.java.watchdog.Watchdog;

public class ConfigService {
	
	private Watchdog plugin = Watchdog.getPlugin(Watchdog.class);
	private Properties config = new Properties();
	
	public ConfigService() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		File configFile = new File(plugin.getDataFolder(), "config.properties");
		try (FileInputStream fis = new FileInputStream(configFile)){
			config.load(fis);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Couldn't read config file!");
		}	
	}
	
	public String getBotToken() {
		return config.getProperty("token");
	}
	
	public String getChannelID() {
		return config.getProperty("channelID");
	}
	
	public String getJoinMessage() {
		String msg = config.getProperty("joinMessage");
		return msg == null ? "has joined the game" : msg;
	}
	
	public String getLeaveMessage() {
		String msg = config.getProperty("leaveMessage");
		return msg == null ? "has left the game" : msg;
	}

}
