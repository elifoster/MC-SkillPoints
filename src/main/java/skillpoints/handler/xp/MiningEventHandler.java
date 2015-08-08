package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import skillpoints.Config;
import skillpoints.api.v1.helpers.MiningHelper;

import java.util.List;

public class MiningEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void onDropHarvestedItems(BlockEvent.BreakEvent event) {
		int xpDropped = event.getExpToDrop();
		ItemStack blockStack = new ItemStack(event.block, event.blockMetadata);
		Block block = event.block;

        if (xpDropped > 0 &&
		  MiningHelper.isAbleToExecuteMining(block, blockStack, event.blockMetadata, event.getPlayer())) {
			addXP(event.getPlayer(), 5);
        }
    }

    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        if (MiningHelper.isAbleToExecuteSmelting("ore", event.smelting)) {
			addXP(event.player, 5);
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
