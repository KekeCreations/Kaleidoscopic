package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.common.block.RockBlock;
import com.kekecreations.kaleidoscopic.common.block.RockSlabBlock;
import com.kekecreations.kaleidoscopic.common.block.RockStairBlock;
import com.kekecreations.kaleidoscopic.common.block.RockWallBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.function.Supplier;

public class KBlocks {
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_SLABS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_WALLS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_SLABS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ROCK_BRICK_WALLS = new HashMap<>();


    static {
        for (DyeColor colour : DyeColor.values()) {
            //DYED ROCKS
            DYED_ROCKS.put(colour, registerBlock(colour + "_rock", true, () -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()))));
            DYED_ROCK_STAIRS.put(colour, registerBlock(colour + "_rock_stairs", true, () -> new RockStairBlock(DYED_ROCKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            DYED_ROCK_SLABS.put(colour, registerBlock(colour + "_rock_slab", true, () -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            DYED_ROCK_WALLS.put(colour, registerBlock(colour + "_rock_wall", true, () -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()))));
            //DYED ROCK BRICKS
            DYED_ROCK_BRICKS.put(colour, registerBlock(colour + "_rock_bricks", true, () -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()))));
            DYED_ROCK_BRICK_STAIRS.put(colour, registerBlock(colour + "_rock_brick_stairs", true, () -> new RockStairBlock(DYED_ROCK_BRICKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
            DYED_ROCK_BRICK_SLABS.put(colour, registerBlock(colour + "_rock_brick_slab", true, () -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
            DYED_ROCK_BRICK_WALLS.put(colour, registerBlock(colour + "_rock_brick_wall", true, () -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()))));
        }
    }


    public static Supplier<Block> registerBlock(String name, boolean hasItem, Supplier<Block> blockSupplier) {
        return JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, hasItem, blockSupplier);
    }

    public static void loadClass() {}
}
