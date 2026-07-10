package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.RedstoneLampBlock;

public class CompatLampBlock extends RedstoneLampBlock {
    String modID;

    public CompatLampBlock(String modID, Properties properties) {
        super(properties);
        this.modID = modID;
    }


    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedLampsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
