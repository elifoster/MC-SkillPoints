package skillpoints.api.skill;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import skillpoints.api.xp.PlayerXP;

import java.util.List;

public interface SkillHandler<E extends Event> {
	public String name();

	public List<Skill<E>> skills();

	public EventBus bus();

	@SubscribeEvent
	public boolean executeSkill(E event);

	public List<Skill<E>> availableSkills(PlayerXP playerXP);

	public void save(EntityPlayer player);
}
