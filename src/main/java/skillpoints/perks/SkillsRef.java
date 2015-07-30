package skillpoints.perks;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.perks.Perk;
import skillpoints.perks.melee.Strongarm;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class SkillsRef {
	private static ArrayList<Perk<AttackEntityEvent>> melee = new ArrayList<Perk<AttackEntityEvent>>();

	public static ArrayList<Perk<AttackEntityEvent>> getMelee() {
		return melee;
	}

	static {
		melee.add(new Strongarm());
	}
}
