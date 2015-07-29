package skillpoints.api;

import net.minecraft.entity.player.EntityPlayer;
import skillpoints.api.perks.Perk;
import skillpoints.api.skill.SkillHandler;
import skillpoints.api.xp.XPHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Strikingwolf
 */
public class MasterHandler {
	public static MasterHandler INSTANCE = new MasterHandler();

	protected ArrayList<XPHandler> xpHandlers = new ArrayList<XPHandler>();
	protected ArrayList<SkillHandler> skillHandlers = new ArrayList<SkillHandler>();

	/**
	 * Adds an XPHandler to the MasterHandler, this allows SkillPoints to use your xpHandler
	 * @param xpHandler the XPHandler to add
	 * @return True if xpHandler was added else false
	 */
	public boolean addXPHandler(XPHandler xpHandler) {
		return xpHandlers.add(xpHandler);
	}

	/**
	 * Adds an XPHandler to the MasterHandler, this allows SkillPoints to use your xpHandler
	 * @param idx index to add the XPHandler at
	 * @param xpHandler the XPHandler to add
	 */
	public void addXPHandler(int idx, XPHandler xpHandler) {
		xpHandlers.add(idx, xpHandler);
	}

	/**
	 * Adds a SkillHandler to the MasterHandler, this allows SkillPoints to use your skillHandler
	 * @param skillHandler the SkillHandler to add
	 * @return True if skillHandler was added else false
	 */
	public boolean addSkillHandler(SkillHandler skillHandler) {
		skillHandler.bus().register(skillHandler);
		return skillHandlers.add(skillHandler);
	}

	/**
	 * Adds a SkillHandler to the MasterHandler, this allows SkillPoints to use your skillHandler
	 * @param idx index to add the SkillHandler at
	 * @param skillHandler the SkillHandler to add
	 */
	public void addSkillHandler(int idx, SkillHandler skillHandler) {
		skillHandler.bus().register(skillHandler);
		skillHandlers.add(idx, skillHandler);
	}

	/**
	 * Saves the current state of the player
	 * @param player player to save the state of
	 */
	public void save(EntityPlayer player) {
		for (SkillHandler skillHandler : skillHandlers) {
			skillHandler.save(player);
		}

		for (XPHandler xpHandler : xpHandlers) {
			xpHandler.save(player);
		}
	}

	/**
	 * Saves all the players states
	 * @param players players to save
	 */
	public void save(List<EntityPlayer> players) {
		for (EntityPlayer player : players) {
			this.save(player);
		}
	}

	/**
	 * Gets the available perks for a player
	 * @param player Player to get the perks of
	 * @return Hash from group name to list of available perks
	 */
	public HashMap<String, List<Perk>> availablePerks(EntityPlayer player) {
		HashMap<String, List<Perk>> perks = new HashMap<String, List<Perk>>();
		HashMap<String, Integer> xp = new HashMap<String, Integer>();

		for (XPHandler xpHandler : xpHandlers) {
			xp.put(xpHandler.name(), xpHandler.xp(player));
		}

		for (SkillHandler skillHandler : skillHandlers) {
			String name = skillHandler.name();

			List<Perk> before = perks.get(name);
			List<Perk> now = (List<Perk>) skillHandler.availablePerks(xp);

			if (before == null) {
				perks.put(name, now);
			} else {
				before.addAll(now);
				perks.put(name, before);
			}
		}

		return perks;
	}

	// TODO things?
}
