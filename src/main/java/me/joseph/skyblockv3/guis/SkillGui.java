package me.joseph.skyblockv3.guis;

import me.joseph.skyblockv3.utils.GuiItemCreator;
import me.joseph.skyblockv3.utils.Skill;
import me.joseph.skyblockv3.utils.SkillManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SkillGui {

	private static SkillGui skillGui = new SkillGui();

	public static SkillGui SkillGui() {
		return skillGui;
	}

	private Inventory inventory;

	public void createSkillGui(Player p) {
		String title = "§bSkills Menu";

		inventory = Bukkit.createInventory(null, 3 * 9, title);

		ItemStack glass = GuiItemCreator.itemCreator(Material.GREEN_STAINED_GLASS_PANE, " ", null, false);

		ItemStack farming = GuiItemCreator.itemCreator(Material.SUGAR_CANE, "§aFarming Skill", null, false);

		ItemStack mining = GuiItemCreator.itemCreator(Material.DIAMOND_ORE, "§1Mining Skill", null, false);

		ItemStack woodcutting = GuiItemCreator.itemCreator(Material.OAK_LOG, "§6Woodcutting Skill", null, false);

		ItemStack combat = GuiItemCreator.itemCreator(Material.IRON_SWORD, "§4Combat Skill", null, false);

		ItemStack fishing = GuiItemCreator.itemCreator(Material.COD, "§dFishing Skill", null, false);

		inventory.setItem(9, farming);
		inventory.setItem(11, mining);
		inventory.setItem(13, woodcutting);
		inventory.setItem(15, combat);
		inventory.setItem(17, fishing);

		for (int i = 0; i < inventory.getSize(); i++) {
			if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
				inventory.setItem(i, glass);
			}
		}

		p.openInventory(inventory);
	}

	public void createFarmingGui(Player p) {
		String title = "§bFarming Skill";
		inventory = Bukkit.createInventory(null, 3 * 9, title);

		ItemStack glass = GuiItemCreator.itemCreator(Material.GREEN_STAINED_GLASS_PANE, " ", null, false);

		int level = SkillManager.instance.getLevel(p, Skill.FARMING);
		ItemStack wheat;
		ItemStack beetroot;
		ItemStack potato;
		ItemStack carrot;
		ItemStack melon;
		ItemStack pumpkin;
		ItemStack sugarCane;
		ItemStack netherWart;
		if (level >= 0) {
			wheat = GuiItemCreator.itemCreator(Material.WHEAT, "§eWheat", null, true);
		} else {
			wheat = GuiItemCreator.itemCreator(Material.WHEAT, "§eWheat", null, false);
		}

		if (level >= 1) {
			beetroot = GuiItemCreator.itemCreator(Material.BEETROOT, "§eBeetroot", null, true);
		} else {
			beetroot = GuiItemCreator.itemCreator(Material.BEETROOT, "§eBeetroot", null, false);
		}

		if (level >= 2) {
			potato = GuiItemCreator.itemCreator(Material.POTATO, "§ePotato", null, true);
		} else {
			potato = GuiItemCreator.itemCreator(Material.POTATO, "§ePotato", null, false);
		}

		if (level >= 3) {
			carrot = GuiItemCreator.itemCreator(Material.CARROT, "§eCarrot", null, true);
		} else {
			carrot = GuiItemCreator.itemCreator(Material.CARROT, "§eCarrot", null, false);
		}

		if (level >= 4) {
			melon = GuiItemCreator.itemCreator(Material.MELON, "§eMelon", null, true);
		} else {
			melon = GuiItemCreator.itemCreator(Material.MELON, "§eMelon", null, false);
		}

		if (level >= 5) {
			pumpkin = GuiItemCreator.itemCreator(Material.PUMPKIN, "§ePumpkin", null, true);
		} else {
			pumpkin = GuiItemCreator.itemCreator(Material.PUMPKIN, "§ePumpkin", null, false);
		}

		if (level >= 6) {
			sugarCane = GuiItemCreator.itemCreator(Material.SUGAR_CANE, "§eSugar Cane", null, true);
		} else {
			sugarCane = GuiItemCreator.itemCreator(Material.SUGAR_CANE, "§eSugar Cane", null, false);
		}

		if (level >= 7) {
			netherWart = GuiItemCreator.itemCreator(Material.NETHER_WART, "§eNether Wart", null, true);
		} else {
			netherWart = GuiItemCreator.itemCreator(Material.NETHER_WART, "§eNether Wart", null, false);
		}

		inventory.setItem(10, wheat);
		inventory.setItem(11, beetroot);
		inventory.setItem(12, potato);
		inventory.setItem(13, carrot);
		inventory.setItem(14, melon);
		inventory.setItem(15, pumpkin);
		inventory.setItem(16, sugarCane);
		inventory.setItem(22, netherWart);

		for (int i = 0; i < inventory.getSize(); i++) {
			if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
				inventory.setItem(i, glass);
			}
		}

		p.openInventory(inventory);
	}
}
