package com.kekecreations.kaleidoscopic;

import com.kekecreations.kaleidoscopic.core.config.FabricConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class FabricKaleidoscopic implements ModInitializer {

    public static final ResourceLocation SYNC_CONFIG_PACKET = ResourceLocation.tryBuild(Kaleidoscopic.MOD_ID, "sync_config");
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
    }


    public void config() {
        ResourceManagerHelper.get(PackType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public ResourceLocation getFabricId() {
                        return ResourceLocation.tryBuild(Kaleidoscopic.MOD_ID, "config");
                    }

                    @Override
                    public void onResourceManagerReload(ResourceManager manager) {
                        config = FabricConfig.load();
                    }
                });

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
            var buf = PacketByteBufs.create();
            config.writeToClient(buf);
            ServerPlayNetworking.send(player, SYNC_CONFIG_PACKET, buf);
            if (FabricConfig.lastError != null) {
                player.displayClientMessage(Component.literal("[Kaleidoscopic]: ")
                                .append(FabricConfig.lastError).withStyle(ChatFormatting.RED),
                        false);
            }
        });
    }
}
