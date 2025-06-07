package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RockStairBlock extends StairBlock {
    public RockStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled();
    }
}
