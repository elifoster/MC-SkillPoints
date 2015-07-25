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

    public float archeryXP = 0.0F;

    @SubscribeEvent
    public void handleAttackWithBow(LivingAttackEvent event) {
        if (event.source.isProjectile() && event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getEntity();
            if (player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() instanceof ItemBow) {
                    //float archeryLevelLast = archeryXP;

                    if (event.entity.isEntityAlive()) {
                        if (event.entity instanceof EntityAnimal) {
                            archeryXP += 0.5F;
                        } else if (event.entity instanceof EntityMob ||
                          event.entity instanceof EntityCreature) {
                            archeryXP += 1.0F;
                        } else if (event.entity instanceof EntityPlayer) {
                            archeryXP += 1.5F;
                        } else if (event.entity instanceof EntityEnderman) {
                            archeryXP += 5.0F;
                        }
                    } else if (event.entity.isDead) {
                        if (event.entity instanceof EntityAnimal) {
                            archeryXP += 0.5F;
                        } else if (event.entity instanceof EntityMob ||
                          event.entity instanceof EntityCreature) {
                            archeryXP += 1.5F;
                        } else if (event.entity instanceof EntityPlayer) {
                            archeryXP += 2.0F;
                        } else if (event.entity instanceof EntityEnderman) {
                            archeryXP += 7.0F;
                        } else if (event.entity instanceof EntityWither ||
                          event.entity instanceof EntityDragon) {
                            archeryXP += archeryXP;
                        }
                    }
                }
            }
        }
    }
}
