package skillpoints.api.v1;

import net.minecraft.entity.player.EntityPlayer;

public interface Perk<T> extends General {
	/**
	 * Level needed for the perk
	 * @return levelNeeded
	 */
	public int levelNeeded();

	/**
	 * Executes the perk given a certain object of type T
	 * @param t object passed in
	 */
	public void execute(T t);

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
}
