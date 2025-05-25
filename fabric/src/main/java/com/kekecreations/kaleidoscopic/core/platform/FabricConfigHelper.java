package com.kekecreations.kaleidoscopic.core.platform;

import com.kekecreations.kaleidoscopic.FabricKaleidoscopic;
import com.kekecreations.kaleidoscopic.core.platform.services.IConfigHelper;

public class FabricConfigHelper implements IConfigHelper {


    @Override
    public boolean isDyedRockEnabled() {
        if (FabricKaleidoscopic.getConfig() != null) {
            return FabricKaleidoscopic.getConfig().isDyedRockEnabled();
        }
        return false;
    }

    @Override
    public boolean isDyedRockVariantsEnabled() {
        if (FabricKaleidoscopic.getConfig() != null) {
            return FabricKaleidoscopic.getConfig().isDyedRockVariantsEnabled();
        }
        return false;
    }

    @Override
    public boolean areDyedLaddersEnabled() {
        if (FabricKaleidoscopic.getConfig() != null) {
            return FabricKaleidoscopic.getConfig().areDyedLaddersEnabled();
        }
        return false;
    }
}
