package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import skillpoints.Config;

import java.util.List;

public class FarmingEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void onHoeUse(UseHoeEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
			addXP(event.entityPlayer, 250);
        }
    }

    @SubscribeEvent
    public void onBonemeal(BonemealEvent event) {
        if (event.getResult() == Event.Result.ALLOW) {
            addXP(event.entityPlayer, 500);
        }
    }

    @SubscribeEvent
    public void harvestCrops(BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null && !event.drops.isEmpty() && event.harvester instanceof EntityPlayer) {
            for (int i = 0; i < event.drops.size(); i++) {
                if (event.drops.get(i).getItem() instanceof ItemSeeds ||
                  event.drops.get(i).getItem() instanceof ItemFood) {
                    addXP(event.harvester, 100);
                }
            }
        }
    }

	@Override
	public List<EventBus> buses() {
		return forgeBus;
	}

	@Override
	public int levelReset() {
		// TODO, figure this out
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableFarmingSystem;
	}

	@Override
	public String name() {
		return "farming";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
