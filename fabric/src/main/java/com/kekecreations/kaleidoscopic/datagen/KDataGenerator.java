package com.kekecreations.kaleidoscopic.datagen;

import com.kekecreations.kaleidoscopic.datagen.client.KLanguageProvider;
import com.kekecreations.kaleidoscopic.datagen.client.KModelProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KBlockLootTableProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KBlockTagProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KItemTagProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class KDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        pack.addProvider(KBlockTagProvider::new);
        pack.addProvider(KItemTagProvider::new);
        pack.addProvider(KRecipeProvider::new);
        pack.addProvider(KBlockLootTableProvider::new);

        // Client Data
        pack.addProvider(KModelProvider::new);
        pack.addProvider(KLanguageProvider::new);
    }
}
