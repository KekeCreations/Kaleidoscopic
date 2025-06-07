package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class KLanguageProvider extends FabricLanguageProvider {

    public KLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        for (DyeColor colour : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colour.getName(), "blue", "Blue"), "gray", "Gray"), "_", " "));

            builder.add(KBlocks.CHISELED_DYED_ROCKS.get(colour).get(), "Chiseled " + stringColour + " Rock");
            builder.add(KBlocks.DYED_ROCKS.get(colour).get(), stringColour + " Rock");
            builder.add(KBlocks.DYED_ROCK_STAIRS.get(colour).get(), stringColour + " Rock Stairs");
            builder.add(KBlocks.DYED_ROCK_SLABS.get(colour).get(), stringColour + " Rock Slab");
            builder.add(KBlocks.DYED_ROCK_WALLS.get(colour).get(), stringColour + " Rock Wall");

            builder.add(KBlocks.DYED_ROCK_BRICKS.get(colour).get(), stringColour + " Rock Bricks");
            builder.add(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get(), stringColour + " Rock Brick Stairs");
            builder.add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get(), stringColour + " Rock Brick Slab");
            builder.add(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get(), stringColour + " Rock Brick Wall");

            builder.add(KBlocks.DYED_LADDERS.get(colour).get(), stringColour + " Ladder");
            builder.add(KBlocks.DYED_DOORS.get(colour).get(), stringColour + " Door");
            builder.add(KBlocks.DYED_TRAPDOORS.get(colour).get(), stringColour + " Trapdoor");
        }

        builder.add(KBlocks.CHISELED_BLEACHED_ROCK.get(), "Chiseled Bleached Rock");
        builder.add(KBlocks.BLEACHED_ROCK.get(), "Bleached Rock");
        builder.add(KBlocks.BLEACHED_ROCK_STAIRS.get(), "Bleached Rock Stairs");
        builder.add(KBlocks.BLEACHED_ROCK_SLAB.get(), "Bleached Rock Slab");
        builder.add(KBlocks.BLEACHED_ROCK_WALL.get(), "Bleached Rock Wall");
        builder.add(KBlocks.BLEACHED_ROCK_BRICKS.get(), "Bleached Rock Bricks");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), "Bleached Rock Brick Stairs");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), "Bleached Rock Brick Slab");
        builder.add(KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), "Bleached Rock Brick Wall");
        builder.add(KBlocks.BLEACHED_LADDER.get(), "Bleached Ladder");
        builder.add(KBlocks.BLEACHED_DOOR.get(), "Bleached Door");
        builder.add(KBlocks.BLEACHED_TRAPDOOR.get(), "Bleached Trapdoor");

        builder.add("tab.kaleidoscopic.configurable_tab", "Kaleidoscopic");

    }
}
