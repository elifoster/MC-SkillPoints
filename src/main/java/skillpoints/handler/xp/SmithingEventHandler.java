package skillpoints.handler.xp;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import skillpoints.Config;
import skillpoints.api.v1.Perk;
import skillpoints.perks.SkillsRef;

import java.util.List;

public class SmithingEventHandler extends GeneralXPHandler {

    @SubscribeEvent
    public void onItemRepaired(AnvilRepairEvent event) {
		// TODO, move this into a skill group
        for (Perk<AnvilRepairEvent> s : SkillsRef.getSmithing()) {
            s.execute(event);
        }

        if (event.getResult() == Event.Result.ALLOW && event.output != null) {
            addXP(event.entityPlayer, 5);
        }
    }

	@Override
	public List<EventBus> buses() {
		return forgeBus;
	}

	@Override
	public int levelReset() {
		// TODO, figure this out
		return 20;
	}

	@Override
	public boolean enabled() {
		return Config.enableSmithingSystem;
	}

	@Override
	public String name() {
		return "smithing";
	}

	@Override
	public String description() {
		// TODO
		return "";
	}
}
