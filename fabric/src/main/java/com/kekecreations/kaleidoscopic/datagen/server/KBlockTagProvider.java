package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.CompletableFuture;

public class KBlockTagProvider extends FabricTagProvider.BlockTagProvider{

    public KBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        pickaxeMineable();
        axeMineable();
        climbable();
    }

    private void pickaxeMineable() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(KBlocks.CHISELED_DYED_ROCKS.get(colour).get())
                    .add(KBlocks.DYED_ROCKS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_STAIRS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_SLABS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_WALLS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_BRICKS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get())
            ;
        }
    }

    private void axeMineable() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                    .add(KBlocks.DYED_LADDERS.get(colour).get())
                    .add(KBlocks.DYED_DOORS.get(colour).get())
                    .add(KBlocks.DYED_TRAPDOORS.get(colour).get())
            ;
        }
    }

    private void climbable() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                    .add(KBlocks.DYED_LADDERS.get(colour).get());
        }
    }


}
