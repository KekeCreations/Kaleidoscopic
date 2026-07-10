package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class CompatRockBlock extends Block {
    String modID;

    public CompatRockBlock(String modID, Properties properties) {
        super(properties);
        this.modID = modID;
    }


    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
