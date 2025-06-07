package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.jinxedlib.common.block.CommonDoorBlock;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class DyedDoorBlock extends CommonDoorBlock {


    public DyedDoorBlock(BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedDoorsEnabled();
    }


}
