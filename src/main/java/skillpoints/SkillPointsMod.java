package skillpoints;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.api.API;
import skillpoints.api.APIBase;
import skillpoints.api.APIStatus;
import skillpoints.api.v1.APIv1;
import skillpoints.apiimpl.APISelector;
import skillpoints.handler.WorldShutdownHandler;
import skillpoints.handler.xp.BlockEventHandler;
import skillpoints.handler.xp.BrewingEventHandler;
import skillpoints.handler.xp.EnchantingEventHandler;
import skillpoints.handler.xp.FarmingEventHandler;
import skillpoints.handler.xp.FishingEventHandler;
import skillpoints.handler.xp.LootingEventHandler;
import skillpoints.handler.xp.MeleeCombatEventHandler;
import skillpoints.handler.xp.MiningEventHandler;
import skillpoints.handler.xp.SmithingEventHandler;
import skillpoints.handler.xp.SpeechEventHandler;
import skillpoints.handler.xp.ArcheryCombatEventHandler;
import skillpoints.util.Logger;

@Mod(modid = SkillPointsMod.MODID, name = SkillPointsMod.NAME, version = SkillPointsMod.VERSION)
public class SkillPointsMod {
    public static final String MODID = "skillpoints";
    public static final String NAME = "Skill Points";
    public static final String VERSION = "1.0.0";
	public static final String LEVEL_DATA = "LEVEL";
	public static final String XP_DATA = "XP";

	public static APIv1 getAPI() {
		try {
			APIBase api = API.getAPI(1);
			if (api.getStatus() == APIStatus.OK && api.getVersion() == 1)
				return (APIv1) api;
			else {
				ClassCastException c = new ClassCastException();
				c.fillInStackTrace();
				throw c;
			}
		} catch (ClassCastException e) {
			Logger.error("The Skill Points API is broken");
			throw e;
		}
	}

	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new Config());
		APISelector.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new WorldShutdownHandler());

        new MeleeCombatEventHandler();
		new ArcheryCombatEventHandler();
        new FishingEventHandler();
        new MiningEventHandler();
        new EnchantingEventHandler();
        new SmithingEventHandler();
        new FarmingEventHandler();
        new LootingEventHandler();
        new SpeechEventHandler();
        new BrewingEventHandler();
        new BlockEventHandler();
    }
}
