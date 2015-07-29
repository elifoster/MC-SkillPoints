package skillpoints.perks;

import cpw.mods.fml.common.eventhandler.Event;

public interface IPerk<E extends Event> {
	public int expNeeded();

	public void doSkill(E e);
}
