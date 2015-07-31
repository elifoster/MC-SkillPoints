package skillpoints.apiimpl.v1;

import net.minecraft.entity.player.EntityPlayer;
import skillpoints.api.API;
import skillpoints.api.APIBase;
import skillpoints.api.APIStatus;
import skillpoints.api.v1.APIv1;
import skillpoints.api.v1.Perk;
import skillpoints.api.v1.SkillHandler;
import skillpoints.api.v1.XPHandler;
import skillpoints.util.IterableUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Strikingwolf
 */
public class APIimplv1 implements APIv1 {
	protected final int version;
	protected final APIStatus status;

	protected ArrayList<XPHandler> xpHandlers = new ArrayList<XPHandler>();
	protected HashMap<String, XPHandler> xpHandlersHash = new HashMap<String, XPHandler>();
	protected ArrayList<SkillHandler> skillHandlers = new ArrayList<SkillHandler>();
	protected HashMap<String, SkillHandler> skillHandlersHash = new HashMap<String, SkillHandler>();

	public APIimplv1(int version, APIStatus status) {
		this.version = version;
		this.status = status;
	}

	@Override
	public APIBase getAPI(int maxVersion) {
		if (maxVersion == version && status == APIStatus.OK) {
			return this;
		} else {
			return API.getAPI(maxVersion);
		}
	}

	@Override
	public APIStatus getStatus() {
		return status;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public boolean addXPHandler(XPHandler xpHandler) {
		xpHandlersHash.put(xpHandler.name(), xpHandler);
		return xpHandlers.add(xpHandler);
	}

	@Override
	public void addXPHandler(int idx, XPHandler xpHandler) {
		xpHandlersHash.put(xpHandler.name(), xpHandler);
		xpHandlers.add(idx, xpHandler);
	}

	@Override
	public boolean addSkillHandler(SkillHandler skillHandler) {
		skillHandlersHash.put(skillHandler.name(), skillHandler);
		IterableUtil.registerAll(skillHandler.buses(), skillHandler);
		return skillHandlers.add(skillHandler);
	}

	@Override
	public void addSkillHandler(int idx, SkillHandler skillHandler) {
		skillHandlersHash.put(skillHandler.name(), skillHandler);
		IterableUtil.registerAll(skillHandler.buses(), skillHandler);
		skillHandlers.add(idx, skillHandler);
	}

	@Override
	public void save(EntityPlayer player) {
		for (SkillHandler skillHandler : skillHandlers) {
			skillHandler.save(player);
		}

		for (XPHandler xpHandler : xpHandlers) {
			xpHandler.save(player);
		}
	}

	@Override
	public void save(List<EntityPlayer> players) {
		for (EntityPlayer player : players) {
			this.save(player);
		}
	}

	@Override
	public HashMap<String, List<Perk>> availablePerks(EntityPlayer player) {
		HashMap<String, List<Perk>> perks = new HashMap<String, List<Perk>>();
		HashMap<String, Integer> xp = new HashMap<String, Integer>();

		for (XPHandler xpHandler : xpHandlers) {
			xp.put(xpHandler.name(), xpHandler.level(player));
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

	@Override
	public HashMap<String, List<Perk>> newPerks(EntityPlayer player, XPHandler xpHandler) {
		HashMap<String, List<Perk>> perks = new HashMap<String, List<Perk>>();
		String xpName = xpHandler.name();
		int level = xpHandler.level(player);

		for (SkillHandler skillHandler : skillHandlers) {
			String name = skillHandler.name();

			List<Perk> before = perks.get(name);
			List<Perk> now = (List<Perk>) skillHandler.newPerks(xpName, level);

			if (before == null) {
				perks.put(name, now);
			} else {
				before.addAll(now);
				perks.put(name, before);
			}
		}

		return perks;
	}

	@Override
	public void levelUp(EntityPlayer player, XPHandler xpHandler) {
		// TODO add a config option for global or not
		String toSend = player.getDisplayName() + " has leveled up in xp group " + xpHandler.name() + " and has earned the following perks";
		HashMap<String, List<Perk>> theNewPerks = newPerks(player, xpHandler);
		for (String name : theNewPerks.keySet()) {
			List<Perk> perks = theNewPerks.get(name);
			toSend += "\n" + name;
			for (Perk perk : perks) {
				toSend += "\n- " + perk.name();
			}
		}
		// TODO actually send the toSend variable to the player
	}

	@Override
	public XPHandler getXPHandler(int idx) {
		return xpHandlers.get(idx);
	}


	@Override
	public SkillHandler getSkillHandler(int idx) {
		return skillHandlers.get(idx);
	}

	@Override
	public XPHandler getXPHandler(String name) {
		return xpHandlersHash.get(name);
	}

	@Override
	public SkillHandler getSkillHandler(String name) {
		return skillHandlersHash.get(name);
	}
}
