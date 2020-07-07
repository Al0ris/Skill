package me.joseph.skyblockv3.farming;

import me.joseph.skyblockv3.SkyblockV3;
import me.joseph.skyblockv3.utils.Skill;
import me.joseph.skyblockv3.utils.SkillManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlockListener implements Listener {

	private SkyblockV3 skyblock = SkyblockV3.getPlugin(SkyblockV3.class);

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		Material mat = b.getType();
		if (skyblock.farmingMats.contains(mat)) {
			if (SkillManager.instance.isHighEnoughLevel(p, Skill.FARMING, mat, null) == true) {
				if (mat == Material.WHEAT) {
					Ageable age = (Ageable) b.getBlockData();
					if (age.getAge() == age.getMaximumAge()) {
						SkillManager.instance.gainXp(p, Skill.FARMING, 1);
					}
				} else if (mat == Material.BEETROOTS) {
					Ageable age = (Ageable) b.getBlockData();
					if (age.getAge() == age.getMaximumAge()) {
						SkillManager.instance.gainXp(p, Skill.FARMING, 1);
					}
				} else if (mat == Material.POTATOES) {
					Ageable age = (Ageable) b.getBlockData();
					if (age.getAge() == age.getMaximumAge()) {
						SkillManager.instance.gainXp(p, Skill.FARMING, 2);
					}
				} else if (mat == Material.CARROTS) {
					Ageable age = (Ageable) b.getBlockData();
					if (age.getAge() == age.getMaximumAge()) {
						SkillManager.instance.gainXp(p, Skill.FARMING, 2);
					}
				} else if (mat == Material.MELON) {
					SkillManager.instance.gainXp(p, Skill.FARMING, 3);

				} else if (mat == Material.PUMPKIN) {
					SkillManager.instance.gainXp(p, Skill.FARMING, 3);

				} else if (mat == Material.SUGAR_CANE) {
					SkillManager.instance.gainXp(p, Skill.FARMING, 4);

				} else if (mat == Material.NETHER_WART) {
					Ageable age = (Ageable) b.getBlockData();
					if (age.getAge() == age.getMaximumAge()) {
						SkillManager.instance.gainXp(p, Skill.FARMING, 0);
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
	}
}
