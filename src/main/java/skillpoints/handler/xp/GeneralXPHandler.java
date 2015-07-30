package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import skillpoints.SkillPointsMod;
import skillpoints.api.xp.XPHandler;

/**
 * @author Strikingwolf
 */
public abstract class GeneralXPHandler<E> implements XPHandler {
	@SubscribeEvent
	public abstract void handle(E event);

	public abstract int levelReset();

	public void addXP(EntityPlayer player, int amount) {
		int xp = xp(player);
		player.getEntityData().setInteger(name() + SkillPointsMod.XP_DATA + SkillPointsMod.MODID, xp + amount);
	}

	public void removeXP(EntityPlayer player, int amount) {
		int xp = xp(player);
		player.getEntityData().setInteger(name() + SkillPointsMod.XP_DATA + SkillPointsMod.MODID, xp - amount);
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
