package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.SkillPointsMod;
import skillpoints.api.v1.XPHandler;
import skillpoints.util.IterableUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class GeneralXPHandler implements XPHandler {
	protected static final List<EventBus> empty = new ArrayList<EventBus>();
	protected static final List<EventBus> forgeBus = new ArrayList<EventBus>();
	static {
		forgeBus.add(MinecraftForge.EVENT_BUS);
	}

	public GeneralXPHandler() {
		if (enabled()) {
			SkillPointsMod.getAPI().addXPHandler(this);
			IterableUtil.registerAll(this.buses(), this);
		}
	}

	public abstract List<EventBus> buses();

	public abstract int levelReset();

	public abstract boolean enabled();

	public void addXP(EntityPlayer player, int amount) {
		int xp = xp(player);
		setXP(player, xp + amount);
	}

	public void removeXP(EntityPlayer player, int amount) {
		int xp = xp(player);
		setXP(player, xp - amount);
	}

	private void setXP(EntityPlayer player, int amount) {
		player.getEntityData().setInteger(name() + SkillPointsMod.XP_DATA + SkillPointsMod.MODID, amount);
	}

	@Override
	public int xp(EntityPlayer player) {
		return player.getEntityData().getInteger(name() + SkillPointsMod.XP_DATA + SkillPointsMod.MODID);
	}

	@Override
	public int level(EntityPlayer player) {
		return Math.floorDiv(xp(player), levelReset());
	}

	@Override
	public void save(EntityPlayer player) {
		player.getEntityData().setInteger(name() + SkillPointsMod.XP_DATA + SkillPointsMod.MODID, xp(player));
		player.getEntityData().setInteger(name() + SkillPointsMod.LEVEL_DATA + SkillPointsMod.MODID, level(player));
	}
}
