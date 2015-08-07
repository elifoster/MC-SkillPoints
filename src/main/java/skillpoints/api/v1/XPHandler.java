package skillpoints.api.v1;

import net.minecraft.entity.player.EntityPlayer;

public interface XPHandler extends General {
	/**
	 * Gets a player's xp for this type
	 * @param player player to get xp of
	 * @return xp
	 */
	public int xp(EntityPlayer player);

	/**
	 * Gets a player's level for this type
	 * @param player player to get level of
	 * @return level
	 */
	public int level(EntityPlayer player);
}
