package skillpoints.perks;

import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import skillpoints.api.v1.Perk;
import skillpoints.perks.melee.Strongarm;
import skillpoints.perks.mining.DiamondMiner;
import skillpoints.perks.mining.FortuneMiner;
import skillpoints.perks.mining.XPFarmer;
import skillpoints.perks.smithing.DelicateTouch;
import skillpoints.perks.smithing.StrongerMetals;

import java.util.ArrayList;

public class SkillsRef {

	private static ArrayList<Perk<AttackEntityEvent>> melee = new ArrayList<Perk<AttackEntityEvent>>();
	private static ArrayList<Perk<AnvilRepairEvent>> smithing = new ArrayList<Perk<AnvilRepairEvent>>();
	private static ArrayList<Perk<BlockEvent.BreakEvent>> miningBreak = new ArrayList<Perk<BlockEvent.BreakEvent>>();
	private static ArrayList<Perk<BlockEvent.HarvestDropsEvent>> miningHarvest = new ArrayList<Perk<BlockEvent.HarvestDropsEvent>>();
	//TODO figure out how to combine perk sets with differing events used

	public static ArrayList<Perk<AttackEntityEvent>> getMelee() {
		return melee;
	}

	public static ArrayList<Perk<AnvilRepairEvent>> getSmithing() {
		return smithing;
	}

	public static ArrayList<Perk<BlockEvent.BreakEvent>> getMiningBreak() {
		return miningBreak;
	}

	public static ArrayList<Perk<BlockEvent.HarvestDropsEvent>> getMiningHarvest() {
		return miningHarvest;
	}

	static {
		// Melee
		melee.add(new Strongarm());

		//Smithing
		smithing.add(new StrongerMetals());
		smithing.add(new DelicateTouch());

		//Mining
		miningBreak.add(new XPFarmer());
		miningHarvest.add(new FortuneMiner());
		miningHarvest.add(new DiamondMiner());
	}
}
