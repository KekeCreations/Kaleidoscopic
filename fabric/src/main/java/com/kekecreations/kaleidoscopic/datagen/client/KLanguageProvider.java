package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class KLanguageProvider extends FabricLanguageProvider {


    public KLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        for (DyeColor colour : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colour.getName(), "blue", "Blue"), "gray", "Gray"), "_", " "));

            builder.add(KBlocks.CHISELED_DYED_ROCKS.get(colour).get().asItem(), "Chiseled " + stringColour + " Rock");
            builder.add(KBlocks.DYED_ROCKS.get(colour).get().asItem(), stringColour + " Rock");
            builder.add(KBlocks.DYED_ROCK_STAIRS.get(colour).get().asItem(), stringColour + " Rock Stairs");
            builder.add(KBlocks.DYED_ROCK_SLABS.get(colour).get().asItem(), stringColour + " Rock Slab");
            builder.add(KBlocks.DYED_ROCK_WALLS.get(colour).get().asItem(), stringColour + " Rock Wall");

            builder.add(KBlocks.DYED_ROCK_BRICKS.get(colour).get().asItem(), stringColour + " Rock Bricks");
            builder.add(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get().asItem(), stringColour + " Rock Brick Stairs");
            builder.add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get().asItem(), stringColour + " Rock Brick Slab");
            builder.add(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get().asItem(), stringColour + " Rock Brick Wall");

            builder.add(KBlocks.DYED_LADDERS.get(colour).get().asItem(), stringColour + " Ladder");
            builder.add(KBlocks.DYED_DOORS.get(colour).get().asItem(), stringColour + " Door");
            builder.add(KBlocks.DYED_TRAPDOORS.get(colour).get().asItem(), stringColour + " Trapdoor");

            builder.add(KBlocks.DYED_LAMPS.get(colour).get().asItem(), stringColour + " Lamp");
        }

        builder.add(KBlocks.CHISELED_BLEACHED_ROCK.get().asItem(), "Chiseled Bleached Rock");
        builder.add(KBlocks.BLEACHED_ROCK.get().asItem(), "Bleached Rock");
        builder.add(KBlocks.BLEACHED_ROCK_STAIRS.get().asItem(), "Bleached Rock Stairs");
        builder.add(KBlocks.BLEACHED_ROCK_SLAB.get().asItem(), "Bleached Rock Slab");
        builder.add(KBlocks.BLEACHED_ROCK_WALL.get().asItem(), "Bleached Rock Wall");
        builder.add(KBlocks.BLEACHED_ROCK_BRICKS.get().asItem(), "Bleached Rock Bricks");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get().asItem(), "Bleached Rock Brick Stairs");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get().asItem(), "Bleached Rock Brick Slab");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_WALL.get().asItem(), "Bleached Rock Brick Wall");
        builder.add(KBlocks.BLEACHED_LADDER.get().asItem(), "Bleached Ladder");
        builder.add(KBlocks.BLEACHED_DOOR.get().asItem(), "Bleached Door");
        builder.add(KBlocks.BLEACHED_TRAPDOOR.get().asItem(), "Bleached Trapdoor");
        builder.add(KBlocks.BLEACHED_LAMP.get().asItem(), "Bleached Lamp");

        builder.add("tab.kaleidoscopic.configurable_tab", "Kaleidoscopic");
        builder.add("tab.kaleidoscopic.compat_tab", "Kaleidoscopic x Delicate Dyes");

    }
}
