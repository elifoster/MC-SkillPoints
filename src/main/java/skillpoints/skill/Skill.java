package skillpoints.skill;

import cpw.mods.fml.common.eventhandler.Event;

public interface Skill<E extends Event> {
	public int expNeeded();

	public void doSkill(E e);
}
