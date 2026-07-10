package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.jinxedlib.common.block.CommonTrapDoorBlock;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CompatDyedTrapdoorBlock extends CommonTrapDoorBlock {


    String modID;

    public CompatDyedTrapdoorBlock(String modID, BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedTrapdoorsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }


}
