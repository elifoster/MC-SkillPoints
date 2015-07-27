package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class MeleeCombatEventHandler {
    public float meleeXP = 0.0F;

    @SubscribeEvent
    public void onAttackWithWeapon(LivingAttackEvent event) {
        if (event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getEntity();
            if (player.getHeldItem().getItem() instanceof ItemSword ||
              player.getHeldItem().getItem() instanceof ItemAxe ||
              player.getHeldItem() == null) {
                if (event.entity.isEntityAlive()) {
                    if (player.getHeldItem() == null) {
                        meleeXP += 0.5F;
                    } else if (player.getHeldItem().getItem() instanceof ItemSword) {
                        meleeXP += 1.5F;
                    } else if (player.getHeldItem().getItem() instanceof ItemAxe) {
                        meleeXP += 1.0F;
                    }
                } else if (event.entity.isDead) {
                    if (player.getHeldItem() == null) {
                        meleeXP += 1.0F;
                    } else if (player.getHeldItem().getItem() instanceof ItemSword) {
                        meleeXP += 2.0F;
                    } else if (player.getHeldItem().getItem() instanceof ItemAxe) {
                        meleeXP += 1.5F;
                    }
                }
            }
        }
    }
}
