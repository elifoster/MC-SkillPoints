package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;

public class FarmingEventHandler {

    public float farmingXP = 0.0F;

    @SubscribeEvent
    public void onHoeUse(UseHoeEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
            farmingXP += 0.25F;
        }
    }

    @SubscribeEvent
    public void onBonemeal(BonemealEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
            farmingXP += 0.5F;
        }
    }

    @SubscribeEvent
    public void harvestCrops(BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null && !event.drops.isEmpty()) {
            for (int i = 0; i < event.drops.size(); i++) {
                if (event.drops.get(i).getItem() instanceof ItemSeeds ||
                  event.drops.get(i).getItem() instanceof ItemFood) {
                    farmingXP += 1.0F;
                }
            }
        }
    }
}
