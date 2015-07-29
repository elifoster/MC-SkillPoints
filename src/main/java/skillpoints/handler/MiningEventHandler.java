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
            float miningXP = event.getPlayer().getEntityData().getFloat("miningXP");
            for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
                if (OreDictionary.getOreNames()[i].contains("ore")) {
                    miningXP += 0.5F;
                }
            }
            event.getPlayer().getEntityData().setFloat("miningXP", miningXP);
        }
    }

    @SubscribeEvent
    public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        float miningXP = event.player.getEntityData().getFloat("miningXP");
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains("ore")) {
                miningXP += 0.5F;
            }
        }
        event.player.getEntityData().setFloat("miningXP", miningXP);
    }
}
