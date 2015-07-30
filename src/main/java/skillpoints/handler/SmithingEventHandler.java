package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;

public class SmithingEventHandler {

    @SubscribeEvent
    public void onItemRepaired(AnvilRepairEvent event) {
        if (event.getResult() == Event.Result.ALLOW && event.output != null) {
            int smithingXP = event.entityPlayer.getEntityData().getInteger("smithingXP");
            smithingXP += 5;
            event.entityPlayer.getEntityData().setInteger("smithingXP", smithingXP);
        }
    }
}
