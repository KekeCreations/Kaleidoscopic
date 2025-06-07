package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.LadderBlock;

public class DyedLadderBlock extends LadderBlock {
    public DyedLadderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedLaddersEnabled();
    }
}
