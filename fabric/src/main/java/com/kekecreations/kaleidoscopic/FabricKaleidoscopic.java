package com.kekecreations.kaleidoscopic;

import com.kekecreations.kaleidoscopic.core.config.FabricConfig;
import com.kekecreations.kaleidoscopic.core.registry.KFabricTabs;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class FabricKaleidoscopic implements ModInitializer {

    //Config stuff
    public static FabricConfig config;
    public static FabricConfig getConfig() {
        return config;
    }
    public static void setConfig(FabricConfig config) {
        FabricKaleidoscopic.config = config;
    }

    @Override
    public void onInitialize() {
        config();
        Kaleidoscopic.init();
        KFabricTabs.register();
    }


    public void config() {
        PayloadTypeRegistry.clientboundPlay().register(FabricConfig.PACKET_ID, FabricConfig.PACKET_CODEC);

        ResourceManagerHelper.get(PackType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public Identifier getFabricId() {
                        return Kaleidoscopic.id("config");
                    }
                    @Override
                    public void onResourceManagerReload(ResourceManager manager) {
                        config = FabricConfig.load();
                    }
                });

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
            ServerPlayNetworking.send(player, config);
            if (FabricConfig.lastError != null) {
                player.sendSystemMessage(Component.literal("[Kaleidoscopic]: ")
                        .append(FabricConfig.lastError).withStyle(ChatFormatting.RED), false);
            }
        });
    }
}
