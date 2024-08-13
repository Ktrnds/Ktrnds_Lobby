package org.ktrnds.ktrnds_Lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.ktrnds.ktrnds_Lobby.Commands.SetSpawn;
import org.ktrnds.ktrnds_Lobby.Events.LeaveMessage;
import org.ktrnds.ktrnds_Lobby.Events.TeleportToSpawnLocation;
import org.ktrnds.ktrnds_Lobby.Events.WelcomeMessage;

import java.util.Objects;

public final class Ktrnds_Lobby extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    saveDefaultConfig();

    // 起動したときコンソールに出力する
    this.getLogger().info("プラグインを起動しました");

    Objects.requireNonNull(this.getCommand("setspawn")).setExecutor(new SetSpawn());

    Bukkit.getPluginManager().registerEvents(new TeleportToSpawnLocation(), this);
    Bukkit.getPluginManager().registerEvents(new LeaveMessage(), this);
    Bukkit.getPluginManager().registerEvents(new WelcomeMessage(), this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    saveConfig();
  }
}
