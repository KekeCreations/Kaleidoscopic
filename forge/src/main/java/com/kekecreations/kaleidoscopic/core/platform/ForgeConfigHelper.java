package com.kekecreations.kaleidoscopic.core.platform;

import com.kekecreations.kaleidoscopic.core.config.ForgeConfig;
import com.kekecreations.kaleidoscopic.core.platform.services.IConfigHelper;

public class ForgeConfigHelper implements IConfigHelper  {



    @Override
    public boolean isDyedRockEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.IS_DYED_ROCK_ENABLED.get();
    }

    @Override
    public boolean isDyedRockVariantsEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.IS_DYED_ROCK_VARIANTS_ENABLED.get();
    }

    @Override
    public boolean areDyedLaddersEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ARE_DYED_LADDERS_ENABLED.get();
    }

    @Override
    public boolean areDyedDoorsEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ARE_DYED_DOORS_ENABLED.get();
    }

    @Override
    public boolean areDyedTrapdoorsEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ARE_DYED_TRAPDOORS_ENABLED.get();
    }
}
