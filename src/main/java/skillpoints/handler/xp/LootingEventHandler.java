package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import skillpoints.Config;

import java.util.List;

public class LootingEventHandler extends GeneralXPHandler {
	@Override
	public List<EventBus> buses() {
		return empty;
	}

	@Override
	public int levelReset() {
		// TODO, figure this out
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableLootingSystem;
	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
