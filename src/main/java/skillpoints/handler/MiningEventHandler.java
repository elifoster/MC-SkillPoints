package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.event.world.BlockEvent;

public class MiningEventHandler {

    public float miningXP = 0.0F;

    @SubscribeEvent
    public void onDropHarvestedItems(BlockEvent.BreakEvent event) {
        if (event.getExpToDrop() > 0 &&
          event.block.canHarvestBlock(event.getPlayer(), event.blockMetadata) &&
          event.getPlayer().getHeldItem().getItem() instanceof ItemPickaxe) {
            miningXP += 0.5F;
        }
    }

    //TODO: Get 0.5 miningXP for each ingot smelted. May have to use ASM for this.
}
