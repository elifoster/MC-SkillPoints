package skillpoints.perks.smithing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import skillpoints.api.perks.Perk;

public class StrongerMetals implements Perk<AnvilRepairEvent> {

    @Override
    public String name() {
        //TODO
        return null;
    }

    @Override
    public String description() {
        //TODO
        return null;
    }

    @Override
    public int levelNeeded() {
        //TODO
        return 0;
    }

    @Override
    public void execute(AnvilRepairEvent event) {
        EntityPlayer player = event.entityPlayer;
        if (has(player)) {
            int cost = event.output.getRepairCost();
            int i = (int) ((double) cost * 5D / 100D);
            cost -= i;
            event.output.setRepairCost(cost);
        }
    }

    @Override
    public boolean has(EntityPlayer player) {
        //TODO
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
