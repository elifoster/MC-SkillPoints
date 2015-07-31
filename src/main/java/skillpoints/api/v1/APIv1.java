package skillpoints.api.v1;

import net.minecraft.entity.player.EntityPlayer;
import skillpoints.api.APIBase;

import java.util.HashMap;
import java.util.List;

public interface APIv1 extends APIBase {
	/**
	 * Adds an XPHandler to the MasterHandler, this allows SkillPoints to use your xpHandler
	 * @param xpHandler the XPHandler to add
	 * @return True if xpHandler was added else false
	 */
	public boolean addXPHandler(XPHandler xpHandler);

	/**
	 * Adds a SkillHandler to the MasterHandler, this allows SkillPoints to use your skillHandler
	 * @param skillHandler the SkillHandler to add
	 * @return True if skillHandler was added else false
	 */
	public boolean addSkillHandler(SkillHandler skillHandler);

	/**
	 * Saves the current state of the player
	 * @param player player to save the state of
	 */
	public void save(EntityPlayer player);

	/**
	 * Saves all the players states
	 * @param players players to save
	 */
	public void save(List<EntityPlayer> players);

	/**
	 * Gets the available perks for a player
	 * @param player Player to get the perks of
	 * @return Hash from group name to list of available perks
	 */
	public HashMap<String, List<Perk>> availablePerks(EntityPlayer player);

	/**
	 * Gets the new perks for a player given the xpHandler that was updated
	 * @param player Player to get new perks for
	 * @param xpHandler XPHandler that updated
	 * @return Hash from Skill group to list of Perks gained
	 */
	public HashMap<String, List<Perk>> newPerks(EntityPlayer player, XPHandler xpHandler);

	/**
	 * Should be called by XPHandlers when a player levels up
	 * @param player player that has leveled up
	 * @param xpHandler group that the player has leveled up in
	 */
	public void levelUp(EntityPlayer player, XPHandler xpHandler);

	/**
	 * Gets the list of all the xpHandlers
	 * @return xpHandlers registered to this API
	 */
	public List<XPHandler> xpHandlers();

	/**
	 * Gets the list of all the skillHandlers
	 * @return skillHandlers registered to this API
	 */
	public List<SkillHandler> skillHandlers();

	/**
	 * Gets the xpHandler with the specified name
	 * @param name name of xpHandler to get
	 * @return xpHandler with specified name
	 */
	public XPHandler getXPHandler(String name);

	/**
	 * Gets the skillHandler with the specified name
	 * @param name name of skillHandler to get
	 * @return skillHandler with specified name
	 */
	public SkillHandler getSkillHandler(String name);
}
