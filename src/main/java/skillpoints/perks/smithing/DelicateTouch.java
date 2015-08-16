package skillpoints.perks.smithing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import skillpoints.api.v1.Perk;

public class DelicateTouch implements Perk<AnvilRepairEvent> {

    @Override
    public String name() {
        return StatCollector.translateToLocal("perk.smithing.delicatetouch.name");
    }

    @Override
    public String description() {
        return StatCollector.translateToLocal("perk.smithing.delicatetouch.description");
    }

    @Override
    public int levelNeeded() {
        return 40;
    }

    @Override
    public void execute(AnvilRepairEvent event) {
        EntityPlayer player = event.entityPlayer;
        if (has(player)) {
            int level = player.getEntityData().getInteger("smithingLevel");

            if (level == 100) {
                event.breakChance = 0.3F;
            } else if (level >= 75 && level != 100) {
                event.breakChance = 0.5F;
            } else if (level >= 50 && level < 75) {
                event.breakChance = 0.7F;
            } else if (level >= 40 && level < 50) {
                event.breakChance = 0.9F;
            }
        }
    }

    @Override
    public boolean has(EntityPlayer player) {
        // TODO
        return false;
    }

    @Override
    public boolean add(EntityPlayer player) {
        //TODO
        return false;
    }

    @Override
    public boolean remove(EntityPlayer player) {
        //TODO
        return false;
    }

    @Override
    public void save(EntityPlayer player) {
        //TODO
    }
}
