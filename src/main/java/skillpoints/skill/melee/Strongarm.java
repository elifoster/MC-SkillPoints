package skillpoints.skill.melee;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.skill.Skill;

/**
 * @author Strikingwolf
 */
public class Strongarm implements Skill<AttackEntityEvent> {
	@Override
	public int expNeeded() {
		// TODO, decide Exp amounts
		return 0;
	}

	@Override
	public void doSkill(AttackEntityEvent livingAttackEvent) {
		// TODO, implement Strongarm
	}
}
