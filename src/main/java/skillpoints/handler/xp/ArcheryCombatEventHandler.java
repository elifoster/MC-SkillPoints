package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import skillpoints.Config;

import java.util.ArrayList;
import java.util.List;

public class ArcheryCombatEventHandler extends GeneralXPHandler {
	@SubscribeEvent
	public void archeryAttack(LivingAttackEvent event) {
		if (!event.entity.worldObj.isRemote) {
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

						System.out.println(String.valueOf(archeryXP)); // TESTING
						addXP(player, toAdd);
						System.out.println(String.valueOf(xp(player))); // TESTING
						save(player);
					}
				}
			}
		}
	}

	@Override
	public List<EventBus> buses() {
		List<EventBus> buses = new ArrayList<EventBus>();
		buses.add(MinecraftForge.EVENT_BUS);
		return buses;
	}

	@Override
	public int levelReset() {
		// TODO, actually decide on this
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableArcherySystem;
	}

	@Override
	public String name() {
		return "archery";
	}
}
