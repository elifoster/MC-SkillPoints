package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import skillpoints.SkillPointsMod;

public class WorldShutdownHandler {
	@SubscribeEvent
	public void onShutdown(WorldEvent.Unload unload) {
		SkillPointsMod.getAPI().save(unload.world.playerEntities);
	}
}
