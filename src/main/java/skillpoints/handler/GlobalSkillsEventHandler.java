package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import skillpoints.nbt.SkillExperience;

public class GlobalSkillsEventHandler {

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer &&
          SkillExperience.get((EntityPlayer) event.entity) == null) {
            event.entity.registerExtendedProperties(SkillExperience.PLAYER_NAME,
              new SkillExperience((EntityPlayer) event.entity));
        }
    }
}
