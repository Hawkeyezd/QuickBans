package com.msbans.quick;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Quick extends JavaPlugin {
	
	
	public void onEnable() {
		
		// MySQL Setup.
	    try {
	        create_tables(); //Runs the function
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    // End of MySQL Setup!
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    Bukkit.getLogger().warning("Could not load stats!");
		}
	}
	
	public void onDisable() {
		
		
	}
	
	//MySQL shit.
	String user = getConfig().getString("mysql.user");
	String pass = getConfig().getString("mysql.pass");
	String url = "jdbc:mysql://" + getConfig().getString("mysql.host") + ":" + getConfig().getString("mysql.port") + "/" + getConfig().getString("mysql.database");
	
	public void SampleFunction() throws SQLException { //Change "SampleFunction" to your own function name (Can be anything, unless it already exists)
		Connection conn = DriverManager.getConnection(url, user, pass); //Creates the connection
		PreparedStatement sampleQueryStatement = conn.prepareStatement("YOUR QUERY"); //Put your query in the quotes
		sampleQueryStatement.executeUpdate(); //Executes the query
		sampleQueryStatement.close(); //Closes the query
		conn.close(); //Closes the connection
	}
	
	public void create_tables() throws SQLException
    {
        Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement sampleQueryStatement = conn.prepareStatement("CREATE TABLE users (p_id int NOT NULL AUTO_INCREMENT KEY)");
        sampleQueryStatement.executeUpdate();
        sampleQueryStatement.close();
        conn.close();
    }
	//No more MySQL shit ;D
	
	public boolean onCommand (CommandSender sender, Command command, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("quickbans") || commandLabel.equalsIgnoreCase("qbans")) {
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "]" + ChatColor.AQUA + "Displaying qbans help!");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "]" + ChatColor.AQUA + "Usage: /<command> <user>");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "]" + ChatColor.AQUA + "/griefing or /gr - Griefing");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "]" + ChatColor.AQUA + "/stealing or /st - Stealing");
			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "QBans" + ChatColor.RESET + ChatColor.GOLD + "]" + ChatColor.AQUA + "/homophobia or /hm - Homophobia");
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
		
		if(commandLabel.equalsIgnoreCase("griefing") || commandLabel.equalsIgnoreCase("gr")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /griefing <name>");
			} 
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbouncer-ban-command") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.griefing"));
				}
			}
		return true;
	}
    
		
		if(commandLabel.equalsIgnoreCase("stealing") || commandLabel.equalsIgnoreCase("st")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /stealing <name>");
			} 
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbouncer-ban-command") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.stealing"));
				}
			}
		return true;
	}
    
		
		if(commandLabel.equalsIgnoreCase("homophobia") || commandLabel.equalsIgnoreCase("hm")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /homophobia <name>");
			} 
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbouncer-ban-command") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.homophobia"));
				}
			}
		return true;
	}
		if(commandLabel.equalsIgnoreCase("racism") || commandLabel.equalsIgnoreCase("rc")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /racism <name>");
			} 
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.racism"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-global-ban-command") + " " + args[0] + " " + getConfig().getString("reason.racism"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbouncer-ban-command") + " " + args[0] + " " + getConfig().getString("reason.racism"));
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.racism"));
				}
			}
		return true;
	}
		if(commandLabel.equalsIgnoreCase("permaban") || commandLabel.equalsIgnoreCase("pb")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /permaban <name>");
			} 
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-local-ban-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-local-ban-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbouncer-ban-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
			}
		return true;
	}
	   if(commandLabel.equalsIgnoreCase("tempban") || commandLabel.equalsIgnoreCase("tban") || commandLabel.equalsIgnoreCase("tb")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Usage: /permaban <name>");
			}  
			if (args.length == 1) {
				if (getConfig().getBoolean("system.mcbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.mcbans-local-ban-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
				if (getConfig().getBoolean("system.msbans") == true) {
				Bukkit.dispatchCommand(sender, getConfig().getString("ban.msbans-local-ban-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
				if (getConfig().getBoolean("system.mcbouncer") == true) {
				sender.sendM
				} else {
					Bukkit.dispatchCommand(sender, getConfig().getString("ban.default-command") + " " + args[0] + " " + getConfig().getString("reason.permaban"));
				}
			}
		   
	   }
   
		return false;

	}
}