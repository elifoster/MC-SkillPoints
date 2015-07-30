package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class ArcheryCombatEventHandler extends GeneralXPHandler<LivingAttackEvent> {
	@Override
	public void handle(LivingAttackEvent event) {
		if (event.source.isProjectile() && event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (player.getHeldItem() != null) {
				if (player.getHeldItem().getItem() instanceof ItemBow) {
					int archeryXP = xp(player);
					int toAdd = 0;
					if (event.entity.isEntityAlive()) {
						if (event.entity instanceof EntityAnimal) {
							toAdd = 5;
						} else if (event.entity instanceof EntityMob ||
							event.entity instanceof EntityCreature) {
							toAdd = 10;
							System.out.println(String.valueOf(archeryXP)); // TESTING
						} else if (event.entity instanceof EntityPlayer) {
							toAdd = 15;
						} else if (event.entity instanceof EntityEnderman) {
							toAdd = 5;
						}
					} else if (event.entity.isDead) {
						if (event.entity instanceof EntityAnimal) {
							toAdd = 5;
						} else if (event.entity instanceof EntityMob ||
							event.entity instanceof EntityCreature) {
							toAdd = 15;
						} else if (event.entity instanceof EntityPlayer) {
							toAdd = 20;
						} else if (event.entity instanceof EntityEnderman) {
							toAdd = 70;
						} else if (event.entity instanceof EntityWither ||
							event.entity instanceof EntityDragon) {
							toAdd = archeryXP;
						}
					}

					addXP(player, toAdd);
				}
			}
		}
	}

	@Override
	public int levelReset() {
		// TODO, actually decide on this
		return 20;
	}

	@Override
	public String name() {
		return "archery";
	}
}
