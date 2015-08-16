package skillpoints.perks.mining;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.world.BlockEvent;
import skillpoints.api.v1.Perk;
import skillpoints.api.v1.helpers.MiningHelper;

public class XPFarmer implements Perk<BlockEvent.BreakEvent> {

    @Override
    public int levelNeeded() {
        //TODO
        return 0;
    }

    @Override
    public void execute(BlockEvent.BreakEvent event) {
        int xpDropped = event.getExpToDrop();
        ItemStack blockStack = new ItemStack(event.block, event.blockMetadata);
        Block block = event.block;

        if (xpDropped > 0 && MiningHelper.canExecuteMining(block, blockStack, event.blockMetadata, event.getPlayer()) &&
          has(event.getPlayer())) {
            int newXPValue = xpDropped + (xpDropped / 2);
            event.setExpToDrop(newXPValue);
        }
    }

    @Override
    public boolean has(EntityPlayer player) {
        //TODO
        return false;
    }

    @Override
    public boolean add(EntityPlayer player) {
        //TODO
        return false;
    }

    @Override
    public boolean remove(EntityPlayer player) {
        //TODO
        return false;
    }

    @Override
    public String name() {
        return StatCollector.translateToLocal("perk.mining.xpfarmer.name");
    }

    @Override
    public String description() {
        return StatCollector.translateToLocal("perk.mining.xpfarmer.description");
    }

    @Override
    public void save(EntityPlayer player) {
        //TODO
    }
}
