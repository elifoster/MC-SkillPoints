package skillpoints.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class GlobalSkillsEventHandler {

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer &&
          !event.entity.getEntityData().getBoolean("hasSkillPointsThings")) {
            setDefaultExperienceFloats((EntityPlayer) event.entity);
            setDefaultLevelInts((EntityPlayer) event.entity);
            event.entity.getEntityData().setBoolean("hasSkillPointsThings", true);
        }
    }

    public void setDefaultExperienceFloats(EntityPlayer player) {
        player.getEntityData().setFloat("archeryXP", 0.0F);
        player.getEntityData().setFloat("blockXP", 0.0F);
        player.getEntityData().setFloat("brewingXP", 0.0F);
        player.getEntityData().setFloat("enchantingXP", 0.0F);
        player.getEntityData().setFloat("farmingXP", 0.0F);
        player.getEntityData().setFloat("fishingXP", 0.0F);
        player.getEntityData().setFloat("lootingXP", 0.0F);
        player.getEntityData().setFloat("meleeXP", 0.0F);
        player.getEntityData().setFloat("miningXP", 0.0F);
        player.getEntityData().setFloat("smithingXP", 0.0F);
        player.getEntityData().setFloat("speechXP", 0.0F);
    }

    public void setDefaultLevelInts(EntityPlayer player) {
        player.getEntityData().setInteger("archeryLevel", 0);
        player.getEntityData().setInteger("blockLevel", 0);
        player.getEntityData().setInteger("brewingLevel", 0);
        player.getEntityData().setInteger("enchantingLevel", 0);
        player.getEntityData().setInteger("farmingLevel", 0);
        player.getEntityData().setInteger("fishingLevel", 0);
        player.getEntityData().setInteger("lootingLevel", 0);
        player.getEntityData().setInteger("meleeLevel", 0);
        player.getEntityData().setInteger("miningLevel", 0);
        player.getEntityData().setInteger("smithingLevel", 0);
        player.getEntityData().setInteger("speechLevel", 0);
    }
}
