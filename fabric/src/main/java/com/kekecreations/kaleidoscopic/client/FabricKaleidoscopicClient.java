package com.kekecreations.kaleidoscopic.client;

import com.kekecreations.kaleidoscopic.FabricKaleidoscopic;
import com.kekecreations.kaleidoscopic.core.config.FabricConfig;
import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;

public class FabricKaleidoscopicClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        registerBlockLayers();


        ClientPlayNetworking.registerGlobalReceiver(FabricConfig.PACKET_ID, (config, context) -> {
            FabricKaleidoscopic.setConfig(config);
        });
    }

    public static void registerBlockLayers() {
        for (DyeColor colour : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(KBlocks.DYED_LADDERS.get(colour).get(), RenderType.cutout());
        }
    }
}
