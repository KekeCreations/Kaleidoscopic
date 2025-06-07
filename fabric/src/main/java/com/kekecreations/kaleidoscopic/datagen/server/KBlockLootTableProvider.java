package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.CompletableFuture;

public class KBlockLootTableProvider extends FabricBlockLootTableProvider {


    public KBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dyedRocks();
        dyedRockBricks();
        ladders();
        doors();
        trapdoors();
    }

    private void dyedRocks() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCKS.get(colour).get());
            add(KBlocks.DYED_ROCK_SLABS.get(colour).get(), createSlabItemTable(KBlocks.DYED_ROCK_SLABS.get(colour).get()));
            dropSelf(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCK_WALLS.get(colour).get());
        }
        dropSelf(KBlocks.CHISELED_BLEACHED_ROCK.get());
        dropSelf(KBlocks.BLEACHED_ROCK.get());
        add(KBlocks.BLEACHED_ROCK_SLAB.get(), createSlabItemTable(KBlocks.BLEACHED_ROCK_SLAB.get()));
        dropSelf(KBlocks.BLEACHED_ROCK_STAIRS.get());
        dropSelf(KBlocks.BLEACHED_ROCK_WALL.get());
    }

    private void dyedRockBricks() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
            add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get(), createSlabItemTable(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get()));
            dropSelf(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());
        }
        dropSelf(KBlocks.BLEACHED_ROCK_BRICKS.get());
        add(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), createSlabItemTable(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get()));
        dropSelf(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get());
        dropSelf(KBlocks.BLEACHED_ROCK_BRICK_WALL.get());
    }

    private void ladders() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.DYED_LADDERS.get(colour).get());
        }
        dropSelf(KBlocks.BLEACHED_LADDER.get());
    }

    private void doors() {
        for (DyeColor colour : DyeColor.values()) {
            add(KBlocks.DYED_DOORS.get(colour).get(), createDoorTable(KBlocks.DYED_DOORS.get(colour).get()));
        }
        add(KBlocks.BLEACHED_DOOR.get(), createDoorTable(KBlocks.BLEACHED_DOOR.get()));
    }

    private void trapdoors() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.DYED_TRAPDOORS.get(colour).get());
        }
        dropSelf(KBlocks.BLEACHED_TRAPDOOR.get());
    }
}