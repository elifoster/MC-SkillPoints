package skillpoints.api.perks;

import cpw.mods.fml.common.eventhandler.Event;

public interface Perk<E extends Event> {

	public int levelNeeded();

	public void execute(E e);
}
