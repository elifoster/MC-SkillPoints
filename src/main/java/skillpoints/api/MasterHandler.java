package skillpoints.api;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.api.skill.Skill;
import skillpoints.api.skill.SkillHandler;
import skillpoints.api.xp.PlayerXP;
import skillpoints.api.xp.XPHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Strikingwolf
 */
public class MasterHandler {
	protected ArrayList<XPHandler> xpHandlers = new ArrayList<XPHandler>();
	protected ArrayList<SkillHandler> skillHandlers = new ArrayList<SkillHandler>();

	public boolean addXPHandler(XPHandler xpHandler) {
		return xpHandlers.add(xpHandler);
	}

	public void addXPHandler(int idx, XPHandler xpHandler) {
		xpHandlers.add(idx, xpHandler);
	}

	public boolean addSkillHandler(SkillHandler skillHandler) {
		skillHandler.bus().register(skillHandler);
		return skillHandlers.add(skillHandler);
	}

	public void addSkillHandler(int idx, SkillHandler skillHandler) {
		skillHandler.bus().register(skillHandler);
		skillHandlers.add(idx, skillHandler);
	}

	public void save(EntityPlayer player) {
		for (SkillHandler skillHandler : skillHandlers) {
			skillHandler.save(player);
		}

		for (XPHandler xpHandler : xpHandlers) {
			xpHandler.save(player);
		}
	}

	public void save(List<EntityPlayer> players) {
		for (EntityPlayer player : players) {
			this.save(player);
		}
	}

	public HashMap<String, List<Skill>> availableSkills(EntityPlayer player) {
		HashMap<String, List<Skill>> skills = new HashMap<String, List<Skill>>();
		PlayerXP playerXP = new PlayerXP(player, xpHandlers);

		for (SkillHandler skillHandler : skillHandlers) {
			String name = skillHandler.name();

			List<Skill> before = skills.get(name);
			List<Skill> now = (List<Skill>) skillHandler.availableSkills(playerXP);

			if (before == null) {
				skills.put(name, now);
			} else {
				before.addAll(now);
				skills.put(name, before);
			}
		}
		
		return skills;
	}

	// TODO things?
}
