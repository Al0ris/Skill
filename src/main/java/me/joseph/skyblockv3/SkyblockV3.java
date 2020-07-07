package me.joseph.skyblockv3;

import me.joseph.skyblockv3.commands.SkillCommand;
import me.joseph.skyblockv3.events.InventoryClickListener;
import me.joseph.skyblockv3.events.JoinLeaveListener;
import me.joseph.skyblockv3.farming.BreakBlockListener;
import me.joseph.skyblockv3.utils.Skill;
import me.joseph.skyblockv3.utils.SkillManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class SkyblockV3 extends JavaPlugin {

	public Map<UUID, Integer> farming = new HashMap<>();
	public Map<UUID, Integer> mining = new HashMap<>();
	public Map<UUID, Integer> combat = new HashMap<>();
	public Map<UUID, Integer> wood_cutting = new HashMap<>();
	public Map<UUID, Integer> fishing = new HashMap<>();

	public List<Material> farmingMats = new ArrayList<>();
	public List<Material> miningMats = new ArrayList<>();
	public List<Material> woodcuttingMats = new ArrayList<>();
	public List<EntityType> combatMobs = new ArrayList<>();

	@Override
	public void onEnable() {
		// Plugin startup logic
		createDataFolder();
		SkillManager.instance.createYml();

		registerCommands();
		registerEvents();

		addMats();

		Bukkit.getConsoleSender().sendMessage("§dStatus§7: §2ENABLED");
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinLeaveListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new BreakBlockListener(), this);
	}
	public void registerCommands() {
		getCommand("skills").setExecutor(new SkillCommand());
	}

	public void saveXp(Player p) {
		SkillManager.instance.saveXp(p, Skill.FARMING);
		SkillManager.instance.saveXp(p, Skill.COMBAT);
		SkillManager.instance.saveXp(p, Skill.MINING);
		SkillManager.instance.saveXp(p, Skill.WOOD_CUTTING);
		SkillManager.instance.saveXp(p, Skill.FISHING);
	}

	private void createDataFolder() {
		if (!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
	}

	private void addMats() {
		//Farming
		farmingMats.add(Material.WHEAT);
		farmingMats.add(Material.BEETROOTS);
		farmingMats.add(Material.POTATOES);
		farmingMats.add(Material.CARROTS);
		farmingMats.add(Material.MELON);
		farmingMats.add(Material.PUMPKIN);
		farmingMats.add(Material.SUGAR_CANE);
		farmingMats.add(Material.NETHER_WART);
		//Mining
		miningMats.add(Material.COBBLESTONE);
		miningMats.add(Material.COAL_ORE);
		miningMats.add(Material.IRON_ORE);
		miningMats.add(Material.LAPIS_ORE);
		miningMats.add(Material.REDSTONE_ORE);
		miningMats.add(Material.GOLD_ORE);
		miningMats.add(Material.DIAMOND_ORE);
		miningMats.add(Material.EMERALD_ORE);
		//Woodcutting
		woodcuttingMats.add(Material.OAK_LOG);
		woodcuttingMats.add(Material.DARK_OAK_LOG);
		woodcuttingMats.add(Material.ACACIA_LOG);
		woodcuttingMats.add(Material.BIRCH_LOG);
		woodcuttingMats.add(Material.JUNGLE_LOG);
		woodcuttingMats.add(Material.SPRUCE_LOG);
		//Combat
		combatMobs.add(EntityType.ZOMBIE);
		combatMobs.add(EntityType.SKELETON);
		combatMobs.add(EntityType.SPIDER);
		combatMobs.add(EntityType.CREEPER);
		combatMobs.add(EntityType.SLIME);
		combatMobs.add(EntityType.MAGMA_CUBE);
		combatMobs.add(EntityType.BLAZE);
	}
}
