package skillpoints.perks;

import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.perks.Perk;
import skillpoints.perks.melee.Strongarm;
import skillpoints.perks.smithing.DelicateTouch;
import skillpoints.perks.smithing.StrongerMetals;

import java.util.ArrayList;

public class SkillsRef {
	private static ArrayList<Perk<AttackEntityEvent>> melee = new ArrayList<Perk<AttackEntityEvent>>();
	private static ArrayList<Perk<AnvilRepairEvent>> smithing = new ArrayList<Perk<AnvilRepairEvent>>();

	public static ArrayList<Perk<AttackEntityEvent>> getMelee() {
		return melee;
	}

	public static ArrayList<Perk<AnvilRepairEvent>> getSmithing() {
		return smithing;
	}

	static {
		// Melee
		melee.add(new Strongarm());

		//Mining
		smithing.add(new StrongerMetals());
		smithing.add(new DelicateTouch());
	}
}
