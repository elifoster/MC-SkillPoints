package skillpoints.perks.melee;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.skill.IPerk;

/**
 * @author Strikingwolf
 */
public class Strongarm implements IPerk<AttackEntityEvent> {
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
