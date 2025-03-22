package com.kekecreations.kaleidoscopic.client;

import com.kekecreations.kaleidoscopic.FabricKaleidoscopic;
import com.kekecreations.kaleidoscopic.core.config.FabricConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class FabricKaleidoscopicClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {


        ClientPlayNetworking.registerGlobalReceiver(FabricConfig.PACKET_ID, (config, context) -> {
            FabricKaleidoscopic.setConfig(config);
        });
    }
}
