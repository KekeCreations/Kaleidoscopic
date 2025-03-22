package com.kekecreations.kaleidoscopic.datagen;

import com.kekecreations.kaleidoscopic.datagen.client.KLanguageProvider;
import com.kekecreations.kaleidoscopic.datagen.client.KModelProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KItemTagProvider;
import com.kekecreations.kaleidoscopic.datagen.server.KRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class KDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        //pack.addProvider(ACCBlockTagProvider::new);
        //pack.addProvider(ACCLanguageProvider::new);
        pack.addProvider(KItemTagProvider::new);
        pack.addProvider(KRecipeProvider::new);
        //pack.addProvider(ACCBlockLootTableProvider::new);

        // Client Data
        pack.addProvider(KModelProvider::new);
        pack.addProvider(KLanguageProvider::new);
    }
}
