package skillpoints.perks.mining;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;
import skillpoints.api.v1.Perk;
import skillpoints.api.v1.helpers.MiningHelper;
import skillpoints.api.v1.helpers.MiscHelper;

import java.util.Random;

public class DiamondMiner implements Perk<BlockEvent.BreakEvent> {

    @Override
    public int levelNeeded() {
       return 75;
    }

    @Override
    public void execute(BlockEvent.BreakEvent event) {
        int xpDropped = event.getExpToDrop();
        ItemStack blockStack = new ItemStack(event.block, event.blockMetadata);
        Block block = event.block;

        if (xpDropped > 0 && MiningHelper.canExecuteMining(block, blockStack, event.blockMetadata, event.getPlayer()) &&
          has(event.getPlayer()) && MiscHelper.isStackInOreDict("oreDiamond", blockStack)) {
            ItemStack stackItem = new ItemStack(event.block.getItemDropped(event.blockMetadata, new Random(), 0));
            if (OreDictionary.getOres("gemDiamond").contains(stackItem)) {
                int quantity = block.quantityDroppedWithBonus(event.blockMetadata, new Random());
                quantity += quantity;

                EntityItem entityItem = new EntityItem(event.world, event.x, event.y, event.z, stackItem);

                int damage = event.getPlayer().getHeldItem().getItemDamage();
                event.getPlayer().getHeldItem().setItemDamage(damage - 2);

                for (int i = 0; i < quantity; i++) {
                    event.world.spawnEntityInWorld(entityItem);
                }
            }
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
        return StatCollector.translateToLocal("perk.mining.diamondminer.name");
    }

    @Override
    public String description() {
        return StatCollector.translateToLocal("perk.mining.diamondminer.description");
    }

    @Override
    public void save(EntityPlayer player) {
        //TODO
    }
}
