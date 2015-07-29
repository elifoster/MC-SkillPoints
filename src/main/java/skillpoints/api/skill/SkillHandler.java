package skillpoints.api.skill;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.List;

public interface SkillHandler<E extends Event> {
	/**
	 * Name of the skill
	 * @return name
	 */
	public String name();

	/**
	 * List of perks that go with this skill
	 * @return List of Perks
	 */
	public List<Perk<E>> skills();

	/**
	 * EventBus that this SkillHandler runs off of
	 * @return bus that this SkillHandler will be registered to
	 */
	public EventBus bus();

	@SubscribeEvent
	/**
	 * Execute possible perks on a certain event
	 * @param event event that has happened
	 * @return whether or not a skill was executed
	 */
	public boolean executePerks(E event);

	/**
	 * Gets the available perks given a Hash of a name of a type of xp to a player's xp in that type
	 * @param playerXp Hash from type of xp to player's xp in said type
	 * @return List of available perks
	 */
	public List<Perk<E>> availablePerks(HashMap<String, Integer> playerXp);

	public void save(EntityPlayer player);
}