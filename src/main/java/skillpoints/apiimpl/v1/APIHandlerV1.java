package skillpoints.apiimpl.v1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import skillpoints.Config;
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

public class APIHandlerV1 implements APIv1 {
	protected final int version;
	protected final APIStatus status;

	protected ArrayList<XPHandler> xpHandlers = new ArrayList<XPHandler>();
	protected HashMap<String, XPHandler> xpHandlersHash = new HashMap<String, XPHandler>();
	protected ArrayList<SkillHandler> skillHandlers = new ArrayList<SkillHandler>();
	protected HashMap<String, SkillHandler> skillHandlersHash = new HashMap<String, SkillHandler>();

	public APIHandlerV1(int version, APIStatus status) {
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
	public boolean addSkillHandler(SkillHandler skillHandler) {
		skillHandlersHash.put(skillHandler.name(), skillHandler);
		IterableUtil.registerAll(skillHandler.buses(), skillHandler);
		return skillHandlers.add(skillHandler);
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
		String toSend = "";
		HashMap<String, List<Perk>> theNewPerks = newPerks(player, xpHandler);
		for (String name : theNewPerks.keySet()) {
			List<Perk> perks = theNewPerks.get(name);
			toSend += "\n" + name;
			for (Perk perk : perks) {
				toSend += "\n- " + perk.name();
			}
		}

		if (Config.enableGlobalLevelupNotifications) {
			World world = player.getEntityWorld();
			for (EntityPlayer ePlayer : (List<EntityPlayer>) world.playerEntities) {
				if (ePlayer.getUniqueID() != player.getUniqueID()) {
					ePlayer.addChatMessage(new ChatComponentTranslation("message.levelupglobal", new Object[]{player.getDisplayName(), xpHandler.name()}));
					ePlayer.addChatMessage(new ChatComponentText(toSend));
				}
			}
		}

		player.addChatMessage(new ChatComponentTranslation("message.levelupclient", new Object[] {xpHandler.name()}));
		player.addChatMessage(new ChatComponentText(toSend));

		//TODO: Figure out a way to use ChatComponentTranslation with toSend
	}

	@Override
	public List<XPHandler> xpHandlers() {
		return xpHandlers;
	}

	@Override
	public List<SkillHandler> skillHandlers() {
		return skillHandlers;
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
