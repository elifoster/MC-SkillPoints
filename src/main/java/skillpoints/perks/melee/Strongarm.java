package skillpoints.perks.melee;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import skillpoints.api.v1.Perk;

public class Strongarm implements Perk<AttackEntityEvent> {

	@Override
	public String name() {
		//TODO
		return null;
	}

	@Override
	public String description() {
		//TODO
		return null;
	}

	@Override
	public int levelNeeded() {
		// TODO, decide Exp amounts
		return 0;
	}

	@Override
	public void execute(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		boolean isValidForPerk = player.getHeldItem().getItem() instanceof ItemSword ||
		  player.getHeldItem().getItem() instanceof ItemAxe || !player.isUsingItem();

		if (isValidForPerk && has(player)) {
			event.target.attackEntityFrom(DamageSource.causePlayerDamage(player), 5.0F);
		}
	}

	@Override
	public boolean has(EntityPlayer player) {
		//TODO
		return false;
	}

	@Override
	public boolean add(EntityPlayer player) {
		//TODO
		return false;
	}

	@Override
	public boolean remove(EntityPlayer player) {
		//TODO
		return false;
	}

	@Override
	public void save(EntityPlayer player) {
		//TODO
	}
}
