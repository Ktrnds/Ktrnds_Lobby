package org.ktrnds.ktrnds_Lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class SetSpawn implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      if (sender.hasPermission("ktrnds.lobby.command.setspawn") || sender.isOp()) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Ktrnds_Lobby");
        Location location = ((Player) sender).getLocation();

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        Objects.requireNonNull(plugin).getConfig().set("spawnLocation.x", x);
        Objects.requireNonNull(plugin).getConfig().set("spawnLocation.y", y);
        Objects.requireNonNull(plugin).getConfig().set("spawnLocation.z", z);
      } else {
        sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
      }
    } else {
      sender.sendMessage("You are not a player");
    }

    return true;
  }
}
