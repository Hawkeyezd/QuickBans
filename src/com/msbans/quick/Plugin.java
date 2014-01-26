package com.msbans.quickbans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents((Listener) this, this);
		
        getConfig().options().copyDefaults(true);
        saveConfig();
	}
	
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if (e.getPlayer().getName() == "Hawkeyezd") {
			Player p = e.getPlayer();
			p.sendMessage(ChatColor.BOLD + "[" + ChatColor.GREEN + "*" + ChatColor.WHITE + "] " + ChatColor.AQUA + "This server runs QuickBans!" + ChatColor.RESET);
			Bukkit.broadcast(ChatColor.AQUA + p.getName() + " is QuickBans Staff!", "quickbans.view");
		}
		
    }
	
	public boolean onCommand (CommandSender sender, Command command, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("quickbans") || commandLabel.equalsIgnoreCase("qbans")) {
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "] " + ChatColor.AQUA + "Displaying qbans help!");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "] " + ChatColor.AQUA + "Usage: /<command> <user>");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "] " + ChatColor.AQUA + "/griefing or /gr - Griefing");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "] " + ChatColor.AQUA + "/stealing or /st - Stealing");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "] " + ChatColor.AQUA + "/homophobia or /hm - Homophobia");
			return true;
		}
		
		if (commandLabel.equalsIgnoreCase("ub")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /ub <name>");
			}
			if (args.length == 1) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-unban-command") + " " + args[0]);
			}
		 return true;
		}
		
		if (commandLabel.equalsIgnoreCase("griefing ") || commandLabel.equalsIgnoreCase("gr")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /griefing <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("stealing") || commandLabel.equalsIgnoreCase("st")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /stealing <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("racism") || commandLabel.equalsIgnoreCase("rc")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /racism <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.racism"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.racism"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.racism"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.racism"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("homophobia") || commandLabel.equalsIgnoreCase("hm")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /homophobia <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("swastikas") || commandLabel.equalsIgnoreCase("sw")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /swastikas <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("flyhack") || commandLabel.equalsIgnoreCase("fh")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /flyhack <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.flyhack"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.flyhack"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.flyhack"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.flyhack"));
			}
			
		}
		if (commandLabel.equalsIgnoreCase("xray") || commandLabel.equalsIgnoreCase("xr")) {
			
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /xray <name>");
			}
			
			if (getConfig().getString("system.using") == "default") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.xray"));
			}
			if (getConfig().getString("system.using") == "msbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.msbans-global") + " " + args[0] + " " + getConfig().getString("reason.xray"));
			}
			if (getConfig().getString("system.using") == "mcbans") {
			Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbans-global") + " " + args[0] + " " + getConfig().getString("reason.xray"));
			}
			if (getConfig().getString("system.using") == "mcbouncer") {
				Bukkit.dispatchCommand(sender, getConfig().getString("command.mcbouncer-ban") + " " + args[0] + " " + getConfig().getString("reason.xray"));
			}
			
		}
		
		
		return true;
	}

}
