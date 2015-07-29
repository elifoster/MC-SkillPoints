package skillpoints.perks;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.perk.melee.Strongarm;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class PerkRef {
	private static ArrayList<IPerk<AttackEntityEvent>> melee = new ArrayList<IPerk<AttackEntityEvent>>();

	public static ArrayList<IPerk<AttackEntityEvent>> getMelee() {
		return melee;
	}

	static {
		melee.add(new Strongarm());
	}
}
