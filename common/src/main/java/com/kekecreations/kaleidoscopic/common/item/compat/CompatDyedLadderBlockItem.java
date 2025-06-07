package com.kekecreations.kaleidoscopic.common.item.compat;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class CompatDyedLadderBlockItem extends BlockItem {
    String modID;

    public CompatDyedLadderBlockItem(String modID, Block block, Properties properties) {
        super(block, properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.areDyedLaddersEnabled() && Services.PLATFORM.isModLoaded(modID);
    }
}
