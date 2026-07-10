package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;

public class RockWallBlock extends WallBlock {


    public RockWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled();
    }
}
