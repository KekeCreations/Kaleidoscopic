package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class KBlocks {


    static {

    }


    public static Supplier<Block> register(String name, boolean hasItem, Supplier<Block> blockSupplier) {
        return JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, hasItem, blockSupplier);
    }

    public static void loadClass() {}
}
