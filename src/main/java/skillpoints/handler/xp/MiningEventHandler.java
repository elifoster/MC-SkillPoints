package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;
import skillpoints.Config;

import java.util.List;

public class MiningEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void onDropHarvestedItems(BlockEvent.BreakEvent event) {
        if (event.getExpToDrop() > 0 &&
          event.block.canHarvestBlock(event.getPlayer(), event.blockMetadata) &&
          event.getPlayer().getHeldItem().getItem() instanceof ItemPickaxe) {
            for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
                if (OreDictionary.getOreNames()[i].contains("ore")) {
                    addXP(event.getPlayer(), 5);
                }
            }
        }
    }

    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains("ore")) {
                addXP(event.player, 5);
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
		return Config.enableMiningSystem;
	}

	@Override
	public String name() {
		return "mining";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
