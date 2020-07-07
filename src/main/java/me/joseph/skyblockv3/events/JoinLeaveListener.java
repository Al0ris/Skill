package me.joseph.skyblockv3.events;

import me.joseph.skyblockv3.SkyblockV3;
import me.joseph.skyblockv3.utils.SkillManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

	private final SkyblockV3 skyblock = SkyblockV3.getPlugin(SkyblockV3.class);

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		SkillManager.instance.setupXP(p);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		skyblock.saveXp(e.getPlayer());
	}
}
