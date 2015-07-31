package skillpoints.api.v1;

import net.minecraft.entity.player.EntityPlayer;

public interface XPHandler {
	/**
	 * Gets the name of the XP type
	 * @return Name of XP type
	 */
	public String name();

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

	/**
	 * Saves the XP of a player
	 * @param player player to save the xp of
	 */
	public void save(EntityPlayer player);
}
