package skillpoints.perks.melee;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.perks.Perk;

/**
 * @author Strikingwolf
 */
public class Strongarm implements Perk<AttackEntityEvent> {

	@Override
	public String name() {
		return null;
	}

	@Override
	public String description() {
		return null;
	}

	@Override
	public int levelNeeded() {
		// TODO, decide Exp amounts
		return 0;
	}

	@Override
	public void execute(AttackEntityEvent livingAttackEvent) {
		// TODO, implement Strongarm
	}

	@Override
	public boolean has(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean add(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean remove(EntityPlayer player) {
		return false;
	}

	@Override
	public void save(EntityPlayer player) {}
}
