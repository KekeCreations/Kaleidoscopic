package com.kekecreations.kaleidoscopic.client;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = Kaleidoscopic.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colour : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(KBlocks.DYED_LADDERS.get(colour).get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KBlocks.DYED_DOORS.get(colour).get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KBlocks.DYED_TRAPDOORS.get(colour).get(), RenderType.cutout());
        }
    }
}
