package skillpoints.api.xp;

import net.minecraft.entity.player.EntityPlayer;

public interface XPHandler {
	public String name();

	public int getXP(EntityPlayer player);

	public int save(EntityPlayer player);
}
