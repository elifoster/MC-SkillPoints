package skillpoints.api.xp;

import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.List;

/**
 * @author Strikingwolf
 */
public class PlayerXP {
	public HashMap<String, Integer> playerXP = new HashMap<String, Integer>();

	public PlayerXP(EntityPlayer player, List<XPHandler> xpHandlers) {
		for (XPHandler xpHandler : xpHandlers) {
			playerXP.put(xpHandler.name(), xpHandler.getXP(player));
		}
	}
}
