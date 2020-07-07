package me.joseph.skyblockv3.utils;

public enum Skill {

	FARMING(7), MINING(7), WOOD_CUTTING(5), COMBAT(8), FISHING(8);

	private final int maxLevel;

	Skill(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

}
