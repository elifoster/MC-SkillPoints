package skillpoints;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.api.API;
import skillpoints.api.APIBase;
import skillpoints.api.v1.APIv1;
import skillpoints.apiimpl.APISelector;
import skillpoints.handler.BlockEventHandler;
import skillpoints.handler.BrewingEventHandler;
import skillpoints.handler.EnchantingEventHandler;
import skillpoints.handler.FarmingEventHandler;
import skillpoints.handler.FishingEventHandler;
import skillpoints.handler.GlobalSkillsEventHandler;
import skillpoints.handler.LootingEventHandler;
import skillpoints.handler.MeleeCombatEventHandler;
import skillpoints.handler.MiningEventHandler;
import skillpoints.handler.SmithingEventHandler;
import skillpoints.handler.SpeechEventHandler;
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
			return (APIv1) API.getAPI(1);
		} catch (ClassCastException e) {
			Logger.error("The Skill Points API is broken");
			throw e;
		}
	}

	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event);
		APISelector.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GlobalSkillsEventHandler());
        if (Config.enableMeleeSystem) {
            MinecraftForge.EVENT_BUS.register(new MeleeCombatEventHandler());
        }

		new ArcheryCombatEventHandler();

        if (Config.enableFishingSystem) {
            MinecraftForge.EVENT_BUS.register(new FishingEventHandler());
        }

        if (Config.enableMiningSystem) {
            MinecraftForge.EVENT_BUS.register(new MiningEventHandler());
        }

        if (Config.enableEnchantingSystem) {
            MinecraftForge.EVENT_BUS.register(new EnchantingEventHandler());
        }

        if (Config.enableSmithingSystem) {
            MinecraftForge.EVENT_BUS.register(new SmithingEventHandler());
        }

        if (Config.enableFarmingSystem) {
            MinecraftForge.EVENT_BUS.register(new FarmingEventHandler());
        }

        if (Config.enableLootingSystem) {
            MinecraftForge.EVENT_BUS.register(new LootingEventHandler());
        }

        if (Config.enableSpeechSystem) {
            MinecraftForge.EVENT_BUS.register(new SpeechEventHandler());
        }

        if (Config.enableBrewingSystem) {
            MinecraftForge.EVENT_BUS.register(new BrewingEventHandler());
        }

        if (Config.enableBlockingSystem) {
            MinecraftForge.EVENT_BUS.register(new BlockEventHandler());
        }
    }
}
