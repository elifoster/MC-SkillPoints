package skillpoints;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SkillPointsMod.MODID, name = SkillPointsMod.NAME, version = SkillPointsMod.VERSION)
public class SkillPointsMod {
    public static final String MODID = "skillpoints";
    public static final String NAME = "Skill Points";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event);
    }
}
