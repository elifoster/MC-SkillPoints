package skillpoints.api.v1.helpers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * A class for useful utilities that can help with developing perks related to the Mining skill.
 */
public class MiningHelper {

    /**
     * @param block target block
     * @param blockStack target block's ItemStack
     * @param meta metadata of block
     * @param player player who is performing the action that called this method
     * @return true if everything that is required to execute is true, else false
     */
    public static boolean canExecuteMining(Block block, ItemStack blockStack, int meta, EntityPlayer player) {
        if (player != null && block.canHarvestBlock(player, meta) && player.getHeldItem() != null &&
          player.getHeldItem().getItem() instanceof ItemPickaxe) {
            return MiscHelper.isStackInOreDict("ore", blockStack);
        }
        return false;
    }
}
