package me.joseph.skyblockv3.events;

import me.joseph.skyblockv3.guis.SkillGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {


	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getClickedInventory() != null) {
			if (e.getView().getTitle().contains("Skills Menu")) {
				e.setCancelled(true);
				if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
					if (e.getCurrentItem().getType() == Material.SUGAR_CANE) {
						SkillGui.SkillGui().createFarmingGui((Player) e.getWhoClicked());
					}
				}
			} else if (e.getView().getTitle().contains("Farming Skill")) {
				e.setCancelled(true);
			}
		}
	}
}
