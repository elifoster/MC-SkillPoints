package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import skillpoints.Config;
import skillpoints.api.v1.Perk;
import skillpoints.api.v1.helpers.MiningHelper;
import skillpoints.api.v1.helpers.MiscHelper;
import skillpoints.perks.SkillsRef;

import java.util.List;

public class MiningEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void onBlockBroken(BlockEvent.BreakEvent event) {
		for (Perk<BlockEvent.BreakEvent> s : SkillsRef.getMiningBreak()) {
			s.execute(event);
		}
    }

	@SubscribeEvent
	public void onDropsHarvested(BlockEvent.HarvestDropsEvent event) {
		for (Perk<BlockEvent.HarvestDropsEvent> s : SkillsRef.getMiningHarvest()) {
			s.execute(event);
		}

		ItemStack blockStack = new ItemStack(event.block, event.blockMetadata);
		Block block = event.block;

		if (event.dropChance > 0 && event.harvester != null && event.harvester instanceof EntityPlayer &&
		  MiningHelper.canExecuteMining(block, blockStack, event.blockMetadata, event.harvester)) {
			addXP(event.harvester, 5);
		}
	}

    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        if (MiscHelper.isStackInOreDict("ore", event.smelting)) {
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
