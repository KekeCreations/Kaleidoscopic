package com.kekecreations.kaleidoscopic;


import com.kekecreations.kaleidoscopic.core.config.NeoForgeConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Kaleidoscopic.MOD_ID)
public class NeoForgeKaleidoscopic {

    public NeoForgeKaleidoscopic(IEventBus eventBus, ModContainer modContainer) {

        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfig.SPEC);
        Kaleidoscopic.init();

    }
}