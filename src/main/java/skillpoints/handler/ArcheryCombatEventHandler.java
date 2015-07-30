package skillpoints.handler;

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

public class ArcheryCombatEventHandler {

    @SubscribeEvent
    public void handleAttackWithBow(LivingAttackEvent event) {
        if (event.source.isProjectile() && event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getEntity();
            if (player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() instanceof ItemBow) {
                    int archeryXP = player.getEntityData().getInteger("archeryXP");
                    if (event.entity.isEntityAlive()) {
                        if (event.entity instanceof EntityAnimal) {
                            archeryXP += 5;
                        } else if (event.entity instanceof EntityMob ||
                          event.entity instanceof EntityCreature) {
                            archeryXP += 10;
                            System.out.println(String.valueOf(archeryXP)); // TESTING
                        } else if (event.entity instanceof EntityPlayer) {
                            archeryXP += 15;
                        } else if (event.entity instanceof EntityEnderman) {
                            archeryXP += 5;
                        }
                    } else if (event.entity.isDead) {
                        if (event.entity instanceof EntityAnimal) {
                            archeryXP += 5;
                        } else if (event.entity instanceof EntityMob ||
                          event.entity instanceof EntityCreature) {
                            archeryXP += 15;
                        } else if (event.entity instanceof EntityPlayer) {
                            archeryXP += 20;
                        } else if (event.entity instanceof EntityEnderman) {
                            archeryXP += 70;
                        } else if (event.entity instanceof EntityWither ||
                          event.entity instanceof EntityDragon) {
                            archeryXP += archeryXP;
                        }
                    }

                    player.getEntityData().setInteger("archeryXP", archeryXP);
                }
            }
        }
    }
}
