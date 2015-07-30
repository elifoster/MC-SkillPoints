package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import skillpoints.api.MasterHandler;

public class WorldShutdownHandler {
	@SubscribeEvent
	public void onShutdown(WorldEvent.Unload unload) {
		MasterHandler.INSTANCE.save(unload.world.playerEntities);
	}
}
