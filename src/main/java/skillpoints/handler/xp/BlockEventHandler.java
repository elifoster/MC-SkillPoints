package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import skillpoints.Config;

import java.util.List;

public class BlockEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void handleBlock(LivingAttackEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            if (player.isBlocking()) {
                addXP(player, 1);
            }
        }
    }

	@Override
	public List<EventBus> buses() {
		return forgeBus;
	}

	@Override
	public int levelReset() {
		// TODO, actually decide this
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableBlockingSystem;
	}

	@Override
	public String name() {
		return "blocking";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
