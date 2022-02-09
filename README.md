# Watchdog

A bukkit plugin to connect Discord to your Minecraft Server!

NOTE: Only tested on Paper 1.18

# How to use Watchdog

1) Either build the project yourself using `maven`, or download the latest build from the releases tab.
2) [Create a Discord Bot Account](https://discordpy.readthedocs.io/en/stable/discord.html)
3) Install the plugin on your server and add the config file (see below for details)

## Config File

The config file is located in `plugins/Watchdog/config.properties`
Your config requires these bare minimum values:

```
token=your_discord_bot_token
channelID=communication_channel_ID
```
And can contain these optional values:
```
joinMessage=your_join_message
leaveMessage=your_leave_message
```

## Slash Commands

The bot component currently has two commands:

/ping - get the bot's response time
/online - view online players