package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.skill.Perk;
import skillpoints.skill.SkillsRef;

public class MeleeCombatEventHandler {
    public float meleeXP = 0.0F;

    @SubscribeEvent
    public void onAttackWithWeapon(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;

		for (Perk<AttackEntityEvent> s : SkillsRef.getMelee()) {
			s.doSkill(event);
		}

		boolean isHand = !player.isUsingItem();
		boolean isSword = player.getHeldItem().getItem() instanceof ItemSword;
		boolean isAxe = player.getHeldItem().getItem() instanceof ItemAxe;
		boolean goodItem = isHand || isSword || isAxe;

		if (goodItem) {
			if (event.entity.isEntityAlive()) {
				if (isHand) {
					meleeXP += 0.5F;
				} else if (isSword) {
					meleeXP += 1.5F;
				} else if (isAxe) {
					meleeXP += 1.0F;
				}
			} else if (event.entity.isDead) {
				if (isHand) {
					meleeXP += 1.0F;
				} else if (player.getHeldItem().getItem() instanceof ItemSword) {
					meleeXP += 2.0F;
				} else if (isAxe) {
					meleeXP += 1.5F;
				}
			}
		}
    }
}
