package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.LadderBlock;

public class CompatDyedLadderBlock extends LadderBlock {
    String modID;

    public CompatDyedLadderBlock(String modID, Properties properties) {
        super(properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedLaddersEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
