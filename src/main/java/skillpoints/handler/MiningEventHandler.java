package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;

public class MiningEventHandler {

    @SubscribeEvent
    public void onDropHarvestedItems(BlockEvent.BreakEvent event) {
        if (event.getExpToDrop() > 0 &&
          event.block.canHarvestBlock(event.getPlayer(), event.blockMetadata) &&
          event.getPlayer().getHeldItem().getItem() instanceof ItemPickaxe) {
            int miningXP = event.getPlayer().getEntityData().getInteger("miningXP");
            for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
                if (OreDictionary.getOreNames()[i].contains("ore")) {
                    miningXP += 5;
                }
            }
            event.getPlayer().getEntityData().setInteger("miningXP", miningXP);
        }
    }

    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        int miningXP = event.player.getEntityData().getInteger("miningXP");
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains("ore")) {
                miningXP += 5;
            }
        }
        event.player.getEntityData().setInteger("miningXP", miningXP);
    }
}
