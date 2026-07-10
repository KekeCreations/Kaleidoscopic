package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.WallBlock;

public class CompatRockWallBlock extends WallBlock {

    String modID;

    public CompatRockWallBlock(String modID, Properties properties) {
        super(properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
