package skillpoints;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
	public static Configuration config;

	public static boolean enableArcherySystem;
	public static boolean enableBlockingSystem;
	public static boolean enableBrewingSystem;
	public static boolean enableEnchantingSystem;
	public static boolean enableFarmingSystem;
	public static boolean enableFishingSystem;
	public static boolean enableLootingSystem;
	public static boolean enableMeleeSystem;
	public static boolean enableMiningSystem;
	public static boolean enableSmithingSystem;
	public static boolean enableSpeechSystem;

	public static boolean enableGlobalLevelupNotifications;

	// Categories
	private static final String FEATURES = "Features";
	private static final String TWEAKS = "Tweaks";

	public static void init(File configFile) {
		//create configuration object from the given file
		if (config == null)
		{
			config = new Configuration(configFile);
			loadConfig();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(SkillPointsMod.MODID))
		{
			loadConfig();
		}
	}

	private static void loadConfig() {
		enableArcherySystem = config.getBoolean("archerySystem", FEATURES, true, "Enable archery system");
		enableBlockingSystem = config.getBoolean("blockingSystem", FEATURES, true, "Enable blocking system");
		enableBrewingSystem = config.getBoolean("brewingSystem", FEATURES, true, "Enable brewing system");
		enableEnchantingSystem = config.getBoolean("enchantingSystem", FEATURES, true, "Enable enchanting system");
		enableFarmingSystem = config.getBoolean("farmingSystem", FEATURES, true, "Enable farming system");
		enableFishingSystem = config.getBoolean("fishingSystem", FEATURES, true, "Enable fishing system");
		enableLootingSystem = config.getBoolean("lootingSystem", FEATURES, true, "Enable looting system");
		enableMeleeSystem = config.getBoolean("meleeSystem", FEATURES, true, "Enable melee system");
		enableMiningSystem = config.getBoolean("miningSystem", FEATURES, true, "Enable mining system");
		enableSmithingSystem = config.getBoolean("smithingSystem", FEATURES, true, "Enable smithing system");
		enableSpeechSystem = config.getBoolean("speechSystem", FEATURES, true, "Enable speech system");
		enableGlobalLevelupNotifications = config.getBoolean("globalLevelupNotifications", TWEAKS, true, "Enable global level up notifications");


		if (config.hasChanged())
		{
			config.save();
		}
	}
}
