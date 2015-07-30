package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;

public class FarmingEventHandler {

    @SubscribeEvent
    public void onHoeUse(UseHoeEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
            float farmingXP = event.entityPlayer.getEntityData().getFloat("farmingXP");
            farmingXP += 0.25F;
            event.entityPlayer.getEntityData().setFloat("farmingXP", farmingXP);
        }
    }

    @SubscribeEvent
    public void onBonemeal(BonemealEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
            float farmingXP = event.entityPlayer.getEntityData().getFloat("farmingXP");
            farmingXP += 0.5F;
            event.entityPlayer.getEntityData().setFloat("farmingXP", farmingXP);
        }
    }

    @SubscribeEvent
    public void harvestCrops(BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null && !event.drops.isEmpty() && event.harvester instanceof EntityPlayer) {
            for (int i = 0; i < event.drops.size(); i++) {
                if (event.drops.get(i).getItem() instanceof ItemSeeds ||
                  event.drops.get(i).getItem() instanceof ItemFood) {
                    float farmingXP = event.harvester.getEntityData().getFloat("farmingXP");
                    farmingXP += 1.0F;
                    event.harvester.getEntityData().setFloat("farmingXP", farmingXP);
                }
            }
        }
    }
}
