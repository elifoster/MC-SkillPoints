package skillpoints;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraftforge.common.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Config {

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

    public static void load(FMLPreInitializationEvent event) {
        File configurationDir = ReflectionHelper.getPrivateValue(FMLPreInitializationEvent.class, event, 2);
        File oldConfigFile = new File(configurationDir, "skillpoints.cfg");
        if (oldConfigFile.exists()) {
            try {
                FileUtils.copyFile(new File(configurationDir, "skillpoints.cfg"), new File(configurationDir, "skillpoints-try.cfg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            oldConfigFile.delete();
        }
        Configuration config = new Configuration(new File(configurationDir, "FlaxbeardsSteamPower.cfg"));
        config.load();

        // Enable systems
        enableArcherySystem = config.get("Feature", "Enable archery system", true).getBoolean(true);
        enableBlockingSystem = config.get("Feature", "Enable blocking system", true).getBoolean(true);
        enableBrewingSystem = config.get("Feature", "Enable brewing system", true).getBoolean(true);
        enableEnchantingSystem = config.get("Feature", "Enable enchanting system", true).getBoolean(true);
        enableFarmingSystem = config.get("Feature", "Enable farming system", true).getBoolean(true);
        enableFishingSystem = config.get("Feature", "Enable fishing system", true).getBoolean(true);
        enableLootingSystem = config.get("Feature", "Enable looting system", true).getBoolean(true);
        enableMeleeSystem = config.get("Feature", "Enable melee system", true).getBoolean(true);
        enableMiningSystem = config.get("Feature", "Enable mining sytem", true).getBoolean(true);
        enableSmithingSystem = config.get("Feature", "Enable smithing system", true).getBoolean(true);
        enableSpeechSystem = config.get("Feature", "Enable speech system", true).getBoolean(true);
    }
}
