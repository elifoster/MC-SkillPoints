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
    public static boolean isAbleToExecuteMining(Block block, ItemStack blockStack, int meta, EntityPlayer player) {
        if (block.canHarvestBlock(player, meta) && player.getHeldItem() != null &&
          player.getHeldItem().getItem() instanceof ItemPickaxe) {
            for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
                if (OreDictionary.getOreNames()[i].contains("ore")) {
                    String name = OreDictionary.getOreName(i);
                    if (OreDictionary.getOres(name).contains(blockStack)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param orePartialName The OreDict name, or part of the OreDict name that is tested against
     * @param smeltedStack The item being smelted
     * @return true if everything that is required to execute is true, else false
     */
    public static boolean isAbleToExecuteSmelting(String orePartialName, ItemStack smeltedStack) {
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains(orePartialName)) {
                String name = OreDictionary.getOreName(i);
                if (OreDictionary.getOres(name).contains(smeltedStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param orePartialName
     * @param block
     * @return
     */
    public static boolean isBlockInOreDict(String orePartialName, ItemStack block) {
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains(orePartialName)) {
                String name = OreDictionary.getOreName(i);
                if (OreDictionary.getOres(name).contains(block)) {
                    return true;
                }
            }
        }
        return false;
    }
}
