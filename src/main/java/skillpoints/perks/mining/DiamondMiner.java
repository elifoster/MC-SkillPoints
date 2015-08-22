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

public class DiamondMiner implements Perk<BlockEvent.HarvestDropsEvent> {

    @Override
    public int levelNeeded() {
       return 75;
    }

    @Override
    public void execute(BlockEvent.HarvestDropsEvent event) {
        ItemStack blockStack = new ItemStack(event.block, event.blockMetadata);
        Block block = event.block;

        if (event.dropChance > 0.0F && event.harvester != null && event.harvester instanceof EntityPlayer &&
          MiningHelper.canExecuteMining(block, blockStack, event.blockMetadata, event.harvester) &&
          has(event.harvester) && MiscHelper.isStackInOreDict("oreDiamond", blockStack) && !event.isSilkTouching) {
            for (ItemStack i : event.drops) {
                if (OreDictionary.getOres("gemDiamond").contains(i)) {
                    int random = (int) (Math.random() * 5 + 1);
                    event.drops.add(random, i);

                    int damage = event.harvester.getHeldItem().getItemDamage();
                    event.harvester.getHeldItem().setItemDamage(damage - 2);
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
