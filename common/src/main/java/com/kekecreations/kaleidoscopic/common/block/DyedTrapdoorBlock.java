package com.kekecreations.kaleidoscopic.common.block;

import com.kekecreations.jinxedlib.common.block.CommonTrapDoorBlock;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class DyedTrapdoorBlock extends CommonTrapDoorBlock {


    public DyedTrapdoorBlock(BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedTrapdoorsEnabled();
    }


}
