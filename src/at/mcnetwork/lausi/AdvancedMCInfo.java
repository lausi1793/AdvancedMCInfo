package at.mcnetwork.lausi;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancedMcInfo extends JavaPlugin {
	
	String version;
	String name;
	
	public void onEnable() {
		version = getDescription().getVersion();
		name = getDescription().getName();
		this.reloadConfig();
		loadConfig();
		Logger.getLogger("Minecraft").info("[" + name + "] Version: " + version + " Plugin has been activated successfully.");
	}
	
	public void onDisable() {
		this.saveConfig();
		Logger.getLogger("Minecraft").info("[" + name + "] Version: " + version + " Plugin was disabled successfully.");
	}
	
	private void loadConfig() {
		FileConfiguration cfg = this.getConfig();
		cfg.options().copyDefaults(true);
		this.saveConfig();
		Logger.getLogger("Minecraft").info("[" + name + "] Version: " + version+ " Successfully reloaded config.yml");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = null;
	    if ((sender instanceof Player)) {
	      p = (Player)sender;
	    }
	
	if (cmd.getName().equalsIgnoreCase("ami"))
    {
      if (p != null)
      {
        p.sendMessage("§e==========[ AdvancedMcInfo Help Version: " + ChatColor.YELLOW + version + " §e]==========");
        p.sendMessage(ChatColor.GREEN + "Hy " + p.getDisplayName() + ChatColor.GREEN + "! Here are all the commands of AdvancedMcInfo");
        p.sendMessage("§9/help AdvancedMcInfo §aShows you all the commands that are available.\n");

        p.sendMessage("§5Version: " + ChatColor.DARK_PURPLE + version);
        p.sendMessage("§5Created by: " + ChatColor.DARK_PURPLE + "lausi1793");
        p.sendMessage("§e==========[ AdvancedMcInfo Help Version: " + ChatColor.YELLOW + version + " §e]==========");

        return true;
      }else{
      sender.sendMessage("This command is not supported for the console.");
      }
    }
    
    if (cmd.getName().equalsIgnoreCase("forum"))
    {
      if (p != null)
      {
        p.sendMessage(getConfig().getString("AdvancedMcInfo.forum").replaceAll("&", "§"));

        return true;
      }
    }
      
      if (cmd.getName().equalsIgnoreCase("website"))
	    {
	      if (p != null)
	      {
	        p.sendMessage(getConfig().getString("AdvancedMcInfo.website").replaceAll("&", "§"));

	        return true;
	      }
	    }
      if (cmd.getName().equalsIgnoreCase("ts3"))
	    {
	      if (p != null)
	      {
	        p.sendMessage(getConfig().getString("AdvancedMcInfo.ts3").replaceAll("&", "§"));

	        return true;
	      }
	    }
      if (cmd.getName().equalsIgnoreCase("skype"))
	    {
	      if (p != null)
	      {
	        p.sendMessage(getConfig().getString("AdvancedMcInfo.skype").replaceAll("&", "§"));

	        return true;
	      }
	    }
      if (cmd.getName().equalsIgnoreCase("vote"))
	    {
	      if (p != null)
	      {
	        p.sendMessage(getConfig().getString("AdvancedMcInfo.vote").replaceAll("&", "§"));

	        return true;
	      }
	    }
      if (cmd.getName().equalsIgnoreCase("ip"))
	    {
	      if (p != null)
	      {
	        p.sendMessage(getConfig().getString("AdvancedMcInfo.MinecraftServerIP").replaceAll("&", "§"));

	        return true;
	      }
	    }
      if (cmd.getName().equalsIgnoreCase("amireload")) {
	      if (p != null) {
	        if (p.hasPermission("advancedmcinfo.reload")) {
	          reloadConfig();
	          p.sendMessage(ChatColor.GREEN + "Reloaded " + getDescription().getName() + " config.yml!");
	          return true;
	        }
	      }
	      else {
	        sender.sendMessage("This command is not supported for the console.");
	      }
	      return true;
	    }
      return false;
	  }

}
