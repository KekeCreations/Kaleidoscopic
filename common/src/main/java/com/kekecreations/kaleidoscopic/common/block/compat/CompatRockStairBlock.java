package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CompatRockStairBlock extends StairBlock {
    String modID;

    public CompatRockStairBlock(String modID, BlockState baseState, Properties properties) {
        super(baseState, properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
