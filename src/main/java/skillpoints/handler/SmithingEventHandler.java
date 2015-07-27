package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;

public class SmithingEventHandler {

    public float smithingXP;

    @SubscribeEvent
    public void onItemRepaired(AnvilRepairEvent event) {
        if (event.getResult() == Event.Result.ALLOW && event.output != null) {
            smithingXP += 0.5F;
        }
    }
}
