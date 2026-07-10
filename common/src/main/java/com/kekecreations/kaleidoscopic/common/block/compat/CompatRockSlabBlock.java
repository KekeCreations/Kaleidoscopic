package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.SlabBlock;

public class CompatRockSlabBlock extends SlabBlock {

    String modID;

    public CompatRockSlabBlock(String modID, Properties properties) {
        super(properties);
        this.modID = modID;
    }


    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
