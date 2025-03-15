package com.kekecreations.kaleidoscopic.common.block;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class RockBlock extends Block {
    public RockBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return true;
    }
}
