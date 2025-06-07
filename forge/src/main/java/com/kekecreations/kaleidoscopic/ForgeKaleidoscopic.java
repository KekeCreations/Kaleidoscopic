package com.kekecreations.kaleidoscopic;

import com.kekecreations.kaleidoscopic.core.config.ForgeConfig;
import com.kekecreations.kaleidoscopic.core.platform.ForgePlatformHelper;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Kaleidoscopic.MOD_ID)
public class ForgeKaleidoscopic {
    
    public ForgeKaleidoscopic() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ForgeConfig.SPEC);
        ForgePlatformHelper.TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Kaleidoscopic.init();
        
    }
}