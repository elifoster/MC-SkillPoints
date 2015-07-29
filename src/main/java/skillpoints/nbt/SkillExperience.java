package skillpoints.nbt;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class SkillExperience implements IExtendedEntityProperties {

    public float archeryXP, blockXP, brewingXP, enchantingXP, farmingXP, fishingXP, lootingXP,
      meleeXP, miningXP, smithingXP, speechXP;
    private static EntityPlayer player;
    public static String PLAYER_NAME = "Player-";
    protected World world;

    public SkillExperience(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
        this.PLAYER_NAME = PLAYER_NAME + player.getCommandSenderName();
        this.archeryXP = 0.0F;
        this.blockXP = 0.0F;
        this.brewingXP = 0.0F;
        this.enchantingXP = 0.0F;
        this.farmingXP = 0.0F;
        this.fishingXP = 0.0F;
        this.lootingXP = 0.0F;
        this.meleeXP = 0.0F;
        this.miningXP = 0.0F;
        this.smithingXP = 0.0F;
        this.speechXP = 0.0F;
    }

    @Override
    public void init(Entity entity, World world) {
        player = (EntityPlayer) entity;
        world = world; //Don't even know why I have this here
    }

    public static final SkillExperience get(EntityPlayer player) {
        return (SkillExperience) player.getExtendedProperties(PLAYER_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound nbt) {
        NBTTagCompound compound = new NBTTagCompound();
        nbt.setTag(PLAYER_NAME, compound);
        compound.setFloat("archeryXP", this.archeryXP);
        compound.setFloat("blockXP", this.blockXP);
        compound.setFloat("brewingXP", this.brewingXP);
        compound.setFloat("enchantingXP", this.enchantingXP);
        compound.setFloat("farmingXP", this.farmingXP);
        compound.setFloat("fishingXP", this.fishingXP);
        compound.setFloat("lootingXP", this.lootingXP);
        compound.setFloat("meleeXP", this.meleeXP);
        compound.setFloat("miningXP", this.miningXP);
        compound.setFloat("smithingXP", this.smithingXP);
        compound.setFloat("speechXP", this.speechXP);
    }

    @Override
    public void loadNBTData(NBTTagCompound nbt) {
        NBTTagCompound compound = new NBTTagCompound();
        nbt.getTag(PLAYER_NAME);
        this.archeryXP = compound.getFloat("archeryXP");
        this.blockXP = compound.getFloat("blockXP");
        this.brewingXP = compound.getFloat("brewingXP");
        this.enchantingXP = compound.getFloat("enchantingXP");
        this.farmingXP = compound.getFloat("farmingXP");
        this.fishingXP = compound.getFloat("fishingXP");
        this.lootingXP = compound.getFloat("lootingXP");
        this.meleeXP = compound.getFloat("meleeXP");
        this.miningXP = compound.getFloat("miningXP");
        this.smithingXP = compound.getFloat("smithingXP");
        this.speechXP = compound.getFloat("speechXP");
    }

    public float getXP(String skill) {
        if (skill.equalsIgnoreCase("archery")) {
            return this.archeryXP;
        }

        if (skill.equalsIgnoreCase("block")) {
            return this.blockXP;
        }

        if (skill.equalsIgnoreCase("brewing")) {
            return this.brewingXP;
        }

        if (skill.equalsIgnoreCase("enchanting")) {
            return this.enchantingXP;
        }

        if (skill.equalsIgnoreCase("farming")) {
            return this.farmingXP;
        }

        if (skill.equalsIgnoreCase("fishing")) {
            return this.fishingXP;
        }

        if (skill.equalsIgnoreCase("looting")) {
            return this.lootingXP;
        }

        if (skill.equalsIgnoreCase("melee")) {
            return this.meleeXP;
        }

        if (skill.equalsIgnoreCase("mining")) {
            return this.miningXP;
        }

        if (skill.equalsIgnoreCase("smithing")) {
            return this.smithingXP;
        }

        if (skill.equalsIgnoreCase("speech")) {
            return this.speechXP;
        }
        return 0.0F;
    }
}
