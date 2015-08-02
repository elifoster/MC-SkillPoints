package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.Config;
import skillpoints.api.v1.Perk;
import skillpoints.perks.SkillsRef;

import java.util.List;

public class MeleeCombatEventHandler extends GeneralXPHandler {

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
			if (event.entity.isEntityAlive()) {
				if (isHand) {
					addXP(player, 5);
				} else if (isSword) {
					addXP(player, 15);
				} else if (isAxe) {
					addXP(player, 10);
				}
			} else if (event.entity.isDead) {
				if (isHand) {
					addXP(player, 10);
				} else if (player.getHeldItem().getItem() instanceof ItemSword) {
					addXP(player, 20);
				} else if (isAxe) {
					addXP(player, 15);
				}
			}
		}
    }

	@Override
	public List<EventBus> buses() {
		return forgeBus;
	}

	@Override
	public int levelReset() {
		// TODO, figure this out
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableMeleeSystem;
	}

	@Override
	public String name() {
		return "melee";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
