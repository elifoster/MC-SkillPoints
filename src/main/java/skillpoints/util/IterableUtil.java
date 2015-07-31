package skillpoints.util;

import cpw.mods.fml.common.eventhandler.EventBus;

public class IterableUtil {
	public static void registerAll(Iterable<EventBus> buses, Object o) {
		for (EventBus bus : buses) {
			bus.register(o);
		}
	}
}
