package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class BlockEventHandler {

    public float blockXP = 0.0F;

    @SubscribeEvent
    public void handleBlock(LivingAttackEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            if (player.isBlocking()) {
                blockXP += 1.0F;
            }
        }
    }
}
