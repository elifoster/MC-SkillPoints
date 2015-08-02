package skillpoints.api.v1;

import net.minecraft.entity.player.EntityPlayer;

public interface General {
	/**
	 * Get the name of this object
	 * @return name
	 */
	public String name();

	/**
	 * Get the description of this object
	 * @return description
	 */
	public String description();

	/**
	 * Saves this object to the player
	 * @param player player to save to
	 */
	public void save(EntityPlayer player);
}
