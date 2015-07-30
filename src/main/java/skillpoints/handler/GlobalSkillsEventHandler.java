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
        player.getEntityData().setInteger("archeryXP", 0);
        player.getEntityData().setInteger("blockXP", 0);
        player.getEntityData().setInteger("brewingXP", 0);
        player.getEntityData().setInteger("enchantingXP", 0);
        player.getEntityData().setInteger("farmingXP", 0);
        player.getEntityData().setInteger("fishingXP", 0);
        player.getEntityData().setInteger("lootingXP", 0);
        player.getEntityData().setInteger("meleeXP", 0);
        player.getEntityData().setInteger("miningXP", 0);
        player.getEntityData().setInteger("smithingXP", 0);
        player.getEntityData().setInteger("speechXP", 0);
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
