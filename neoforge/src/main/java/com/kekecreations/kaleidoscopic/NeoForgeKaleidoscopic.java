package com.kekecreations.kaleidoscopic;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Kaleidoscopic.MOD_ID)
public class NeoForgeKaleidoscopic {

    public NeoForgeKaleidoscopic(IEventBus eventBus) {
        Kaleidoscopic.init();

    }
}