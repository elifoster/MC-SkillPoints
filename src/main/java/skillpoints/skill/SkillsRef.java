package skillpoints.skill;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.skill.melee.Strongarm;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class SkillsRef {
	private static ArrayList<Skill<AttackEntityEvent>> melee = new ArrayList<Skill<AttackEntityEvent>>();

	public static ArrayList<Skill<AttackEntityEvent>> getMelee() {
		return melee;
	}

	static {
		melee.add(new Strongarm());
	}
}
