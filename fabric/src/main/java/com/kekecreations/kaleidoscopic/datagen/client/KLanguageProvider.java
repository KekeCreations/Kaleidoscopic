package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class KLanguageProvider extends FabricLanguageProvider {
    public KLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        for (DyeColor colour : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colour.getName(), "blue", "Blue"), "gray", "Gray"), "_", " "));

            builder.add(KBlocks.DYED_ROCKS.get(colour).get(), stringColour + " Rock");
            builder.add(KBlocks.DYED_ROCK_STAIRS.get(colour).get(), stringColour + " Rock Stairs");
        }

    }
}
