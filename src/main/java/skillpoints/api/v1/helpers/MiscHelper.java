package skillpoints.api.v1.helpers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * A class for useful utilities that can help with developing general stuff.
 */
public class MiscHelper {

    /**
     * @param orePartialName the OreDict name, or part of the OreDict name that is tested against
     * @param stack the ItemStack being tested against
     * @return true if block is in the oredict entry containing orePartialName
     *
     * Consider refactoring to have better performance when there is a massive OreDictionary, like
     *  with GregTech installed.
     */
    public static boolean isStackInOreDict(String orePartialName, ItemStack stack) {
        for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
            if (OreDictionary.getOreNames()[i].contains(orePartialName)) {
                String name = OreDictionary.getOreName(i);
                if (OreDictionary.getOres(name).contains(stack)) {
                    return true;
                }
            }
        }
        return false;
    }
}
