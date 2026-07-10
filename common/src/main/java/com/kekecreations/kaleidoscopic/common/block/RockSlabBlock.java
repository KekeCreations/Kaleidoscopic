package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

public class RockSlabBlock extends SlabBlock {
    public RockSlabBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled();
    }
}
