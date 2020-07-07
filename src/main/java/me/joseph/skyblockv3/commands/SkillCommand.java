package me.joseph.skyblockv3.commands;

import me.joseph.skyblockv3.guis.SkillGui;
import me.joseph.skyblockv3.utils.Skill;
import me.joseph.skyblockv3.utils.SkillManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkillCommand implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			SkillGui.SkillGui().createSkillGui((Player) sender);
		} else if (args.length == 4) {
			if (args[0].equalsIgnoreCase("setlevel")) {
				System.out.println("1");
				if (sender.hasPermission("skills.setlevel")) {
					System.out.println("2");
					if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
						System.out.println("3");
						Player target = Bukkit.getPlayer(args[1]);
						Skill skill = null;
						switch (args[2]) {
							case "farming":
								skill = Skill.FARMING;
								break;
							case "mining":
								skill = Skill.MINING;
								break;
							case "combat":
								skill = Skill.COMBAT;
								break;
							case "woodcutting":
								skill = Skill.WOOD_CUTTING;
								break;
							case "fishing":
								skill = Skill.FISHING;
						}
						int level = Integer.valueOf(args[3]);
						if (skill != null) {
							System.out.println("4");
							SkillManager.instance.setLevel(target, skill, level);
							sender.sendMessage("§b" + target.getDisplayName() + "'s " + skill.name().toLowerCase() + " skill level has been changed to " + level);
						} else {
							sender.sendMessage("§4Invalid skill");
						}
					}
				}
			}
		}

		return false;
	}
}
