package skillpoints.api.skill;

import cpw.mods.fml.common.eventhandler.Event;

public interface Perk<E extends Event> {
	public int expNeeded();

	public void execute(E e);
}
