package me.joseph.skyblockv3.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GuiItemCreator {

	public static GuiItemCreator guiItemCreator = new GuiItemCreator();

	public static ItemStack itemCreator(Material material, String title, List<String> lore, Boolean enchanted) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(title);
		itemMeta.setLore(lore);
		if (enchanted == true) {
			itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
		}
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemMeta);

		return item;
	}
}
