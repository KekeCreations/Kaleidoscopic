package com.kekecreations.kaleidoscopic.core.platform;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.core.platform.services.IConfigHelper;
import com.kekecreations.kaleidoscopic.core.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static final IConfigHelper CONFIG = load(IConfigHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Kaleidoscopic.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}