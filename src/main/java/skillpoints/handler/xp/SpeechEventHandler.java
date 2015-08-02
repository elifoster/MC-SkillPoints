package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import skillpoints.Config;

import java.util.List;

public class SpeechEventHandler extends GeneralXPHandler {
	// TODO, implement speech

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
		return Config.enableSpeechSystem;
	}

	@Override
	public String name() {
		return "speech";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
