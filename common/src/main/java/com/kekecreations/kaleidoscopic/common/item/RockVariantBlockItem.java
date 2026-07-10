package com.kekecreations.kaleidoscopic.common.item;

import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class RockVariantBlockItem extends BlockItem {
    public RockVariantBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.CONFIG.isDyedRockEnabled() && Services.CONFIG.isDyedRockVariantsEnabled();
    }
}
