package skillpoints.skill.melee;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.perks.Perk;

/**
 * @author Strikingwolf
 */
public class Strongarm implements Perk<AttackEntityEvent> {

	@Override
	public int levelNeeded() {
		// TODO, decide Exp amounts
		return 0;
	}

	@Override
	public void execute(AttackEntityEvent livingAttackEvent) {
		// TODO, implement Strongarm
	}
}
