package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.perks.Perk;
import skillpoints.perks.SkillsRef;

public class MeleeCombatEventHandler {

    @SubscribeEvent
    public void onAttackWithWeapon(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;

		for (Perk<AttackEntityEvent> s : SkillsRef.getMelee()) {
			s.execute(event);
		}

		boolean isHand = !player.isUsingItem();
		boolean isSword = player.getHeldItem().getItem() instanceof ItemSword;
		boolean isAxe = player.getHeldItem().getItem() instanceof ItemAxe;
		boolean goodItem = isHand || isSword || isAxe;

		if (goodItem) {
			int meleeXP = player.getEntityData().getInteger("meleeXP");
			if (event.entity.isEntityAlive()) {
				if (isHand) {
					meleeXP += 5;
				} else if (isSword) {
					meleeXP += 15;
				} else if (isAxe) {
					meleeXP += 10;
				}
			} else if (event.entity.isDead) {
				if (isHand) {
					meleeXP += 10;
				} else if (player.getHeldItem().getItem() instanceof ItemSword) {
					meleeXP += 20;
				} else if (isAxe) {
					meleeXP += 15;
				}
			}

			player.getEntityData().setInteger("meleeXP", meleeXP);
		}
    }
}
