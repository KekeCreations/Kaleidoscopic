package com.kekecreations.kaleidoscopic;

import com.kekecreations.kaleidoscopic.core.config.ForgeConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Kaleidoscopic.MOD_ID)
public class ForgeKaleidoscopic {
    
    public ForgeKaleidoscopic() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ForgeConfig.SPEC);
        Kaleidoscopic.init();
        
    }
}