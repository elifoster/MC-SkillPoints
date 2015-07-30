package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class BlockEventHandler {

    @SubscribeEvent
    public void handleBlock(LivingAttackEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            int blockXP = player.getEntityData().getInteger("blockXP");
            if (player.isBlocking()) {
                blockXP += 1;
            }
            player.getEntityData().setInteger("blockXP", blockXP);
        }
    }
}
