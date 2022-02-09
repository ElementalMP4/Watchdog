package main.java.watchdog;

import java.util.logging.Level;

import javax.security.auth.login.LoginException;

import org.bukkit.plugin.java.JavaPlugin;

import main.java.watchdog.config.ConfigService;
import main.java.watchdog.config.GlobalVars;
import main.java.watchdog.listeners.DiscordMessageListener;
import main.java.watchdog.listeners.DiscordReadyListener;
import main.java.watchdog.listeners.MinecraftEventListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Watchdog extends JavaPlugin {
	
    @Override
    public void onEnable() {
    	GlobalVars.setConfig(new ConfigService());
    	GlobalVars.setServer(getServer());
    	getServer().getPluginManager().registerEvents(new MinecraftEventListener(), this);
    	loadJDA();
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Watchdog Stopped");
    }
    
    private void loadJDA() {
        try {
        	String token = GlobalVars.getConfig().getBotToken();
        	if (token == null) getLogger().log(Level.SEVERE, "No bot token provided!");
        	else {
        		JDABuilder builder = JDABuilder.createDefault(token);
                
                builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
                builder.setBulkDeleteSplittingEnabled(false);
                builder.setActivity(Activity.playing("Minecraft"));
                builder.addEventListeners(new DiscordMessageListener(), new DiscordReadyListener());
    			
                GlobalVars.setJDA(builder.build());	
        	}
		} catch (LoginException e) {
			getLogger().severe(e.getMessage());
		}
    }
}