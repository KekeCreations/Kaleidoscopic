package com.kekecreations.kaleidoscopic.common.block.compat;

import com.kekecreations.jinxedlib.common.block.CommonDoorBlock;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CompatDyedDoorBlock extends CommonDoorBlock {

    String modID;

    public CompatDyedDoorBlock(String modID, BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedDoorsEnabled() && Services.PLATFORM.isModLoaded(modID);
    }


}
