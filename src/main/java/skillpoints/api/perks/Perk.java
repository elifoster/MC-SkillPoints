package skillpoints.api.perks;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

public interface Perk<E extends Event> {
	/**
	 * Get the name of the perk
	 * @return name
	 */
	public String name();

	/**
	 * Get the description of the perk
	 * @return description
	 */
	public String description();

	/**
	 * Level needed for the perk
	 * @return levelNeeded
	 */
	public int levelNeeded();

	/**
	 * Executes the perk on the specified event
	 * @param e event
	 */
	public void execute(E e);

	/**
	 * Tells if the player has this perk
	 * @param player player to check
	 * @return True if the player has the perk else false
	 */
	public boolean has(EntityPlayer player);

	/**
	 * Adds this perk to the player
	 * @param player player to add perk to
	 * @return addition was successful
	 */
	public boolean add(EntityPlayer player);

	/**
	 * Removes this perk from the player
	 * @param player player to remove perk from
	 * @return removal was successful
	 */
	public boolean remove(EntityPlayer player);

	/**
	 * Saves this perk to the player
	 * @param player player to save perk of
	 */
	public void save(EntityPlayer player);
}
