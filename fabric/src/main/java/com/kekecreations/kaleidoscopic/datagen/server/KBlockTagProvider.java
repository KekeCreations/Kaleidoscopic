package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.init.KTags;
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
        rock();
        rockStairs();
        rockSlab();
        rockWall();
        rockBricks();
        rockBrickStairs();
        rockBrickSlab();
        rockBrickWall();
        rockChiseled();
        ladders();
        doors();
        trapdoors();
        walls();
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
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(KBlocks.CHISELED_BLEACHED_ROCK.get())
                .add(KBlocks.BLEACHED_ROCK.get())
                .add(KBlocks.BLEACHED_ROCK_STAIRS.get())
                .add(KBlocks.BLEACHED_ROCK_SLAB.get())
                .add(KBlocks.BLEACHED_ROCK_WALL.get())
                .add(KBlocks.BLEACHED_ROCK_BRICKS.get())
                .add(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get())
                .add(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get())
                .add(KBlocks.BLEACHED_ROCK_BRICK_WALL.get())
        ;
    }

    private void axeMineable() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                    .add(KBlocks.DYED_LADDERS.get(colour).get())
                    .add(KBlocks.DYED_DOORS.get(colour).get())
                    .add(KBlocks.DYED_TRAPDOORS.get(colour).get())
            ;
        }
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(KBlocks.BLEACHED_LADDER.get())
                .add(KBlocks.BLEACHED_DOOR.get())
                .add(KBlocks.BLEACHED_TRAPDOOR.get())
        ;
    }

    private void climbable() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                    .add(KBlocks.DYED_LADDERS.get(colour).get());
        }
        this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(KBlocks.BLEACHED_LADDER.get());
    }

    private void rock() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK)
                    .add(KBlocks.DYED_ROCKS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK)
                .add(KBlocks.BLEACHED_ROCK.get());
    }

    private void rockChiseled() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.CHISELED_ROCK)
                    .add(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.CHISELED_ROCK)
                .add(KBlocks.CHISELED_BLEACHED_ROCK.get());
    }

    private void rockStairs() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_STAIRS)
                    .add(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_STAIRS)
                .add(KBlocks.BLEACHED_ROCK_STAIRS.get());
    }

    private void rockSlab() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_SLAB)
                    .add(KBlocks.DYED_ROCK_SLABS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_SLAB)
                .add(KBlocks.BLEACHED_ROCK_SLAB.get());
    }

    private void rockWall() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_WALL)
                    .add(KBlocks.DYED_ROCK_WALLS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_WALL)
                .add(KBlocks.BLEACHED_ROCK_WALL.get());
    }


    private void rockBricks() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICKS)
                    .add(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICKS)
                .add(KBlocks.BLEACHED_ROCK_BRICKS.get());
    }

    private void rockBrickStairs() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_STAIRS)
                    .add(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_STAIRS)
                .add(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get());
    }

    private void rockBrickSlab() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_SLAB)
                    .add(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_SLAB)
                .add(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get());
    }

    private void rockBrickWall() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_WALL)
                    .add(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.ROCK_BRICK_WALL)
                .add(KBlocks.BLEACHED_ROCK_BRICK_WALL.get());
    }

    private void ladders() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.DYED_LADDERS)
                    .add(KBlocks.DYED_LADDERS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.DYED_LADDERS)
                .add(KBlocks.BLEACHED_LADDER.get());
    }

    private void doors() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.DYED_DOORS)
                    .add(KBlocks.DYED_DOORS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.DYED_DOORS)
                .add(KBlocks.BLEACHED_DOOR.get());
    }

    private void trapdoors() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(KTags.BlockTags.DYED_TRAPDOORS)
                    .add(KBlocks.DYED_TRAPDOORS.get(colour).get());
        }
        this.getOrCreateTagBuilder(KTags.BlockTags.DYED_TRAPDOORS)
                .add(KBlocks.BLEACHED_TRAPDOOR.get());
    }

    private void walls() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.WALLS)
                    .add(KBlocks.DYED_ROCK_WALLS.get(colour).get())
                    .add(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get())
            ;
        }
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .add(KBlocks.BLEACHED_ROCK_WALL.get())
                .add(KBlocks.BLEACHED_ROCK_BRICK_WALL.get())
        ;
    }
}
