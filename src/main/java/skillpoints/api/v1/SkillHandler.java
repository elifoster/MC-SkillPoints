package skillpoints.api.v1;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.List;

public interface SkillHandler extends General {
	/**
	 * List of perks that go with this skill
	 * @return List of Perks
	 */
	public List<Perk> perks();

	/**
	 * EventBuses that this SkillHandler runs off of
	 * @return buses that this SkillHandler will be registered to
	 */
	public List<EventBus> buses();

	/**
	 * Gets the available perks given a Hash of a name of a type of xp to a player's level in that type
	 * @param playerXp Hash from type of xp to player's xp in said type
	 * @return List of available perks
	 */
	public List<Perk> availablePerks(HashMap<String, Integer> playerXp);

	/**
	 * Gets the new perks given an xp group name, and what the level of said group is
	 * @param group Group to get new perks of
	 * @param level level of player in said group
	 * @return list of new perks
	 */
	public List<Perk> newPerks(String group, Integer level);
}
