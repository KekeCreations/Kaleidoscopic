package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.common.block.*;
import com.kekecreations.kaleidoscopic.common.item.DyedLadderBlockItem;
import com.kekecreations.kaleidoscopic.common.item.RockBlockItem;
import com.kekecreations.kaleidoscopic.common.item.RockVariantBlockItem;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Supplier;

public class KBlocks {
    public static final HashMap<DyeColor, Supplier<Block>> CHISELED_DYED_ROCKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_SLABS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_WALLS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_SLABS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_WALLS = new HashMap<>();


    public static final HashMap<DyeColor, Supplier<Block>> DYED_LADDERS = new HashMap<>();


    static {
        for (DyeColor colour : DyeColor.values()) {
            //DYED ROCKS
            DYED_ROCKS.put(colour, registerRockBlock(colour + "_rock",  () -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()))));
            DYED_ROCK_STAIRS.put(colour, registerRockVariantBlock(colour + "_rock_stairs",  () -> new RockStairBlock(DYED_ROCKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            DYED_ROCK_SLABS.put(colour, registerRockVariantBlock(colour + "_rock_slab",  () -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            DYED_ROCK_WALLS.put(colour, registerRockVariantBlock(colour + "_rock_wall", () -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            //DYED ROCK BRICKS
            DYED_ROCK_BRICKS.put(colour, registerRockBlock(colour + "_rock_bricks", () -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()))));
            DYED_ROCK_BRICK_STAIRS.put(colour, registerRockVariantBlock(colour + "_rock_brick_stairs",  () -> new RockStairBlock(DYED_ROCK_BRICKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
            DYED_ROCK_BRICK_SLABS.put(colour, registerRockVariantBlock(colour + "_rock_brick_slab", () -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
            DYED_ROCK_BRICK_WALLS.put(colour, registerRockVariantBlock(colour + "_rock_brick_wall", () -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
            //DYED CHISELED ROCK
            CHISELED_DYED_ROCKS.put(colour, registerRockBlock("chiseled_" + colour + "_rock", () -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()))));


            DYED_LADDERS.put(colour, registerDyedLadder(colour + "_ladder", () -> new DyedLadderBlock(BlockBehaviour.Properties.of().forceSolidOff().strength(0.4F).sound(SoundType.LADDER).noOcclusion().pushReaction(PushReaction.DESTROY))));
        }
    }


    public static Supplier<Block> registerRockBlock(String name, Supplier<Block> blockSupplier) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, blockSupplier);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new RockBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static Supplier<Block> registerRockVariantBlock(String name, Supplier<Block> blockSupplier) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, blockSupplier);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new RockVariantBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static Supplier<Block> registerDyedLadder(String name, Supplier<Block> blockSupplier) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, blockSupplier);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new DyedLadderBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void loadClass() {}
}
