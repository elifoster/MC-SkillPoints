package skillpoints;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import skillpoints.handler.SkillPointEventHandler;

import java.lang.annotation.Annotation;

@Mod(modid = SkillPointsMod.MODID, version = SkillPointsMod.VERSION)
public class SkillPointsMod {
    public static final String MODID = "skillpoints";
    public static final String VERSION = "1.0.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SkillPointEventHandler());
    }
}
