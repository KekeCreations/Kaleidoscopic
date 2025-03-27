package com.kekecreations.kaleidoscopic.core.platform;

import com.kekecreations.kaleidoscopic.core.config.NeoForgeConfig;
import com.kekecreations.kaleidoscopic.core.platform.services.IConfigHelper;

public class NeoForgeConfigHelper implements IConfigHelper {


    @Override
    public boolean isDyedRockEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.IS_DYED_ROCK_ENABLED.get();
    }

    @Override
    public boolean isDyedRockVariantsEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.IS_DYED_ROCK_VARIANTS_ENABLED.get();
    }
}
