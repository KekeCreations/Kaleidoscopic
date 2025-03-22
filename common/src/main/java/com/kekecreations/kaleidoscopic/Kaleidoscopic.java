package com.kekecreations.kaleidoscopic;


import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kaleidoscopic {

    public static final String MOD_ID = "kaleidoscopic";
    public static final String MOD_NAME = "Kaleidoscopic";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        KBlocks.loadClass();
    }


    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}