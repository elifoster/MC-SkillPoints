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
     */
    public static boolean isStackInOreDict(String orePartialName, ItemStack stack) {
        for (int i : OreDictionary.getOreIDs(stack)) {
            String str = OreDictionary.getOreName(i);
            if (str.toLowerCase().contains(orePartialName)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
