package skillpoints;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.handler.ArcheryCombatEventHandler;
import skillpoints.handler.BlockEventHandler;
import skillpoints.handler.BrewingEventHandler;
import skillpoints.handler.EnchantingEventHandler;
import skillpoints.handler.FarmingEventHandler;
import skillpoints.handler.FishingEventHandler;
import skillpoints.handler.LootingEventHandler;
import skillpoints.handler.MeleeCombatEventHandler;
import skillpoints.handler.MiningEventHandler;
import skillpoints.handler.SmithingEventHandler;
import skillpoints.handler.SpeechEventHandler;

@Mod(modid = SkillPointsMod.MODID, name = SkillPointsMod.NAME, version = SkillPointsMod.VERSION)
public class SkillPointsMod {
    public static final String MODID = "skillpoints";
    public static final String NAME = "Skill Points";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        if (Config.enableMeleeSystem) {
            MinecraftForge.EVENT_BUS.register(new MeleeCombatEventHandler());
        }

        if (Config.enableArcherySystem) {
            MinecraftForge.EVENT_BUS.register(new ArcheryCombatEventHandler());
        }

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
