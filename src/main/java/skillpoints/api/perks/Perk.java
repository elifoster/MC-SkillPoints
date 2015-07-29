package skillpoints.api.perks;

import cpw.mods.fml.common.eventhandler.Event;

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
}
