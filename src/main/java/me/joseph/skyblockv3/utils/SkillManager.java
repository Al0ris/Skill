package me.joseph.skyblockv3.utils;

import me.joseph.skyblockv3.SkyblockV3;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SkillManager {

	public static SkillManager instance = new SkillManager();

	private File file;
	private YamlConfiguration config;

	private final SkyblockV3 skyblock = SkyblockV3.getPlugin(SkyblockV3.class);

	public void createYml() {
		File folder = skyblock.getDataFolder();

		file = new File(folder + "/skills.yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		config = YamlConfiguration.loadConfiguration(file);
	}

	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setXp(Player player, Skill skill, int xp) {
		switch (skill) {
			case FARMING:
				skyblock.farming.put(player.getUniqueId(), xp);
				break;
			case MINING:
				skyblock.mining.put(player.getUniqueId(), xp);
				break;
			case COMBAT:
				skyblock.combat.put(player.getUniqueId(), xp);
				break;
			case WOOD_CUTTING:
				skyblock.wood_cutting.put(player.getUniqueId(), xp);
				break;
			case FISHING:
				skyblock.fishing.put(player.getUniqueId(), xp);
		}
	}

	public int getXp(Player player, Skill skill) {
		int xp = 0;
		switch (skill) {
			case FARMING:
				xp = skyblock.farming.get(player.getUniqueId());
				break;
			case MINING:
				xp = skyblock.mining.get(player.getUniqueId());
				break;
			case COMBAT:
				xp = skyblock.combat.get(player.getUniqueId());
				break;
			case WOOD_CUTTING:
				xp = skyblock.wood_cutting.get(player.getUniqueId());
				break;
			case FISHING:
				xp = skyblock.fishing.get(player.getUniqueId());
		}

		return xp;
	}

	public void setLevel(Player player, Skill skill, int level) {
		if (level > skill.getMaxLevel()) {
			level = skill.getMaxLevel();
		}
		double xp;

		if (level == 0) {
			xp = 0;
		} else {
			xp = 5000;
		}
		for (int i = 1; i < level; i++) {
			xp *= 2.5;
		}
		xp = (int) Math.round(xp);
		int value = (int) xp;
		config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
		save();
		switch (skill) {
			case FARMING:
				skyblock.farming.put(player.getUniqueId(), value);
				break;
			case MINING:
				skyblock.mining.put(player.getUniqueId(), value);
				break;
			case COMBAT:
				skyblock.combat.put(player.getUniqueId(), value);
				break;
			case WOOD_CUTTING:
				skyblock.wood_cutting.put(player.getUniqueId(), value);
				break;
			case FISHING:
				skyblock.fishing.put(player.getUniqueId(), value);
		}
	}

	public int getLevel(Player player, Skill skill) {
		int level = 0;
		int xp = 0;
		switch (skill) {
			case FARMING:
				xp = skyblock.farming.get(player.getUniqueId());
				break;
			case COMBAT:
				xp = skyblock.combat.get(player.getUniqueId());
				break;
			case MINING:
				xp = skyblock.mining.get(player.getUniqueId());
				break;
			case WOOD_CUTTING:
				xp = skyblock.wood_cutting.get(player.getUniqueId());
				break;
			case FISHING:
				xp = skyblock.fishing.get(player.getUniqueId());
		}

		for(int i = xp; i >= 5000; i++) {
			i /= 2.5;
			level ++;
		}

		if(level > skill.getMaxLevel()) {
			level = skill.getMaxLevel();
		}
		return level;
	}

	public void setupXP(Player player) {
		for(Skill skill : Skill.values()) {
			if(!config.contains(player.getUniqueId().toString() + "." + skill.name().toLowerCase())) {
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), 0);
			}
			if (!skyblock.farming.containsKey(player.getUniqueId())) {
				skyblock.farming.put(player.getUniqueId(), 0);
			}
			if (!skyblock.mining.containsKey(player.getUniqueId())) {
				skyblock.mining.put(player.getUniqueId(), 0);
			}
			if (!skyblock.combat.containsKey(player.getUniqueId())) {
				skyblock.combat.put(player.getUniqueId(), 0);
			}
			if (!skyblock.wood_cutting.containsKey(player.getUniqueId())) {
				skyblock.wood_cutting.put(player.getUniqueId(), 0);
			}
			if (!skyblock.fishing.containsKey(player.getUniqueId())) {
				skyblock.fishing.put(player.getUniqueId(), 0);
			}
		}
		save();
	}

	public void saveXp(Player player, Skill skill) {
		int xp;
		switch(skill) {
			case FARMING:
				xp = skyblock.farming.get(player.getUniqueId());
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
				break;
			case MINING:
				xp = skyblock.mining.get(player.getUniqueId());
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
				break;
			case COMBAT:
				xp = skyblock.combat.get(player.getUniqueId());
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
				break;
			case WOOD_CUTTING:
				xp = skyblock.wood_cutting.get(player.getUniqueId());
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
				break;
			case FISHING:
				xp = skyblock.fishing.get(player.getUniqueId());
				config.set(player.getUniqueId().toString() + "." + skill.name().toLowerCase(), xp);
		}
		save();
	}

	public void gainXp(Player player, Skill skill, int xp) {
		switch (skill) {
			case FARMING:
				skyblock.farming.put(player.getUniqueId(), skyblock.farming.get(player.getUniqueId()) + xp);
				break;
			case MINING:
				skyblock.mining.put(player.getUniqueId(), skyblock.mining.get(player.getUniqueId()) + xp);
				break;
			case COMBAT:
				skyblock.combat.put(player.getUniqueId(), skyblock.combat.get(player.getUniqueId()) + xp);
				break;
			case WOOD_CUTTING:
				skyblock.wood_cutting.put(player.getUniqueId(), skyblock.wood_cutting.get(player.getUniqueId()) + xp);
				break;
			case FISHING:
				skyblock.fishing.put(player.getUniqueId(), skyblock.fishing.get(player.getUniqueId()) + xp);
		}
	}

	public boolean isHighEnoughLevel(Player p, Skill skill, Material mat, EntityType ent) {
		int level = getLevel(p, skill);
		if (skill == Skill.FARMING) {
			if (mat == Material.WHEAT) {
				return true;
			} else if (mat == Material.BEETROOTS) {
				if (level >= 1) {
					return true;
				}
			} else if (mat == Material.POTATOES) {
				if (level >= 2) {
					return true;
				}
			} else if (mat == Material.CARROTS) {
				if (level >= 3) {
					return true;
				}
			} else if (mat == Material.MELON) {
				if (level >= 4) {
					return true;
				}
			} else if (mat == Material.PUMPKIN) {
				if (level >= 5) {
					return true;
				}
			} else if (mat == Material.SUGAR_CANE) {
				if (level >= 6) {
					return true;
				}
			} else if (mat == Material.NETHER_WART) {
				if (level >= 7) {
					return true;
				}
			} else {
				Bukkit.getConsoleSender().sendMessage("§4isHighEnoughLevel had an invalid material input");
				return true;
			}
		} else if (skill == Skill.MINING) {
			if (mat == Material.COBBLESTONE) {
				return true;
			} else if (mat == Material.COAL_ORE) {
				if (level >= 1) {
					return true;
				}
			} else if (mat == Material.IRON_ORE) {
				if (level >= 2) {
					return true;
				}
			} else if (mat == Material.LAPIS_ORE) {
				if (level >= 3) {
					return true;
				}
			} else if (mat == Material.REDSTONE_ORE) {
				if (level >= 4) {
					return true;
				}
			} else if (mat == Material.GOLD_ORE) {
				if (level >= 5) {
					return true;
				}
			} else if (mat == Material.DIAMOND_ORE) {
				if (level >= 6) {
					return true;
				}
			} else if (mat == Material.EMERALD_ORE) {
				if (level >= 7) {
					return true;
				}
			} else {
				Bukkit.getConsoleSender().sendMessage("§4isHighEnoughLevel had an invalid material input");
				return true;
			}
		} else if (skill == Skill.WOOD_CUTTING) {
			if (mat == Material.OAK_LOG) {
				return true;
			} else if (mat == Material.DARK_OAK_LOG) {
				if (level >= 1) {
					return true;
				}
			} else if (mat == Material.ACACIA_LOG) {
				if (level >= 2) {
					return true;
				}
			} else if (mat == Material.BIRCH_LOG) {
				if (level >= 3) {
					return true;
				}
			} else if (mat == Material.JUNGLE_LOG) {
				if (level >= 4) {
					return true;
				}
			} else if (mat == Material.SPRUCE_LOG) {
				if (level >= 5) {
					return true;
				}
			}
		}
		return false;
	}
}
