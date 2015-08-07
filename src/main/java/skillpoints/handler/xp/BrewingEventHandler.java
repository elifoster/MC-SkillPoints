package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import skillpoints.Config;

import java.util.ArrayList;
import java.util.List;

public class BrewingEventHandler extends GeneralXPHandler {
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
		return Config.enableBrewingSystem;
	}

	@Override
	public String name() {
		return "brewing";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}

	//TODO: Figure out how to do this.
}
