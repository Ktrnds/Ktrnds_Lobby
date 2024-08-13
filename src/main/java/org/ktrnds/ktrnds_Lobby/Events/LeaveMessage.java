package org.ktrnds.ktrnds_Lobby.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {
  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent event) {
    event.setQuitMessage(null);
  }
}
