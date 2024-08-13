package org.ktrnds.ktrnds_Lobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class TeleportToSpawnLocation implements Listener {
  Plugin plugin = Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("Ktrnds_Lobby"));

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    Location spawnLocation = player.getWorld().getSpawnLocation();

    double x = plugin.getConfig().getDouble("spawnLocation.x");
    double y = plugin.getConfig().getDouble("spawnLocation.y");
    double z = plugin.getConfig().getDouble("spawnLocation.z");

    if (x == 0 && y == 0 && z == 0) {
      plugin.getConfig().set("spawnLocation.x", spawnLocation.getX());
      plugin.getConfig().set("spawnLocation.y", spawnLocation.getY());
      plugin.getConfig().set("spawnLocation.z", spawnLocation.getZ());

      player.teleport(spawnLocation);

      return;
    }

    Location location = new Location(player.getWorld(), x, y, z);

    player.teleport(location);
  }
}
