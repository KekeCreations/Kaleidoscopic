package com.kekecreations.kaleidoscopic;


import com.kekecreations.kaleidoscopic.core.config.NeoForgeConfig;
import com.kekecreations.kaleidoscopic.core.registry.KNeoForgeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Kaleidoscopic.MOD_ID)
public class KaleidoscopicNeoForge {

    public KaleidoscopicNeoForge(IEventBus eventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfig.SPEC);
        KNeoForgeTabs.register();
        Kaleidoscopic.init();
    }
}