package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.CompletableFuture;

public class KBlockLootTableProvider extends FabricBlockLootTableProvider {


    public KBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dyedRocks();
        dyedRockBricks();
    }

    private void dyedRocks() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCKS.get(colour).get());
            add(KBlocks.DYED_ROCK_SLABS.get(colour).get(), createSlabItemTable(KBlocks.DYED_ROCK_SLABS.get(colour).get()));
            dropSelf(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCK_WALLS.get(colour).get());
        }
    }

    private void dyedRockBricks() {
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
            add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get(), createSlabItemTable(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get()));
            dropSelf(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
            dropSelf(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());
        }
    }
}