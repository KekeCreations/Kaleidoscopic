package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.common.block.*;
import com.kekecreations.kaleidoscopic.common.block.compat.*;
import com.kekecreations.kaleidoscopic.common.item.*;
import com.kekecreations.kaleidoscopic.common.item.compat.*;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Function;
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

    public static final HashMap<DyeColor, Supplier<Block>> DYED_DOORS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TRAPDOORS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_LAMPS = new HashMap<>();


    static String ArtsAndCrafts = "arts_and_crafts";


    public static final Supplier<Block> BLEACHED_DOOR = registerCompatDyedDoor(ArtsAndCrafts, "bleached_door",
            registryName -> new CompatDyedDoorBlock(ArtsAndCrafts, BlockSetType.OAK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava()));

    public static final Supplier<Block> BLEACHED_LADDER = registerCompatDyedLadder(ArtsAndCrafts, "bleached_ladder",
            registryName -> new CompatDyedLadderBlock(ArtsAndCrafts, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).forceSolidOff().strength(0.4F).sound(SoundType.LADDER).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> BLEACHED_TRAPDOOR = registerCompatDyedTrapdoor(ArtsAndCrafts, "bleached_trapdoor",
            registryName -> new CompatDyedTrapdoorBlock(ArtsAndCrafts, BlockSetType.OAK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(KBlocks::never).ignitedByLava()));

    public static final Supplier<Block> BLEACHED_ROCK = registerCompatRockBlock(ArtsAndCrafts, "bleached_rock",
            registryName -> new CompatRockBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_STAIRS = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_stairs",
            registryName -> new CompatRockStairBlock(ArtsAndCrafts, BLEACHED_ROCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_SLAB = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_slab",
            registryName -> new CompatRockSlabBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_WALL = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_wall",
            registryName -> new CompatRockWallBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_BRICKS = registerCompatRockBlock(ArtsAndCrafts, "bleached_rock_bricks",
            registryName -> new CompatRockBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_BRICK_STAIRS = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_brick_stairs",
            registryName -> new CompatRockStairBlock(ArtsAndCrafts, BLEACHED_ROCK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_BRICK_SLAB = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_brick_slab",
            registryName -> new CompatRockSlabBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> BLEACHED_ROCK_BRICK_WALL = registerCompatRockVariantBlock(ArtsAndCrafts, "bleached_rock_brick_wall",
            registryName -> new CompatRockWallBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> CHISELED_BLEACHED_ROCK = registerCompatRockBlock(ArtsAndCrafts, "chiseled_bleached_rock",
            registryName -> new CompatRockBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName))));


    public static final Supplier<Block> BLEACHED_LAMP = registerCompatDyedLamp(ArtsAndCrafts, "bleached_lamp",
            registryName -> new CompatLampBlock(ArtsAndCrafts, BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).setId(JinxedRegistryHelper.blockKey(registryName))));

    static {
        for (DyeColor colour : DyeColor.values()) {
            //DYED ROCKS
            DYED_ROCKS.put(colour, registerRockBlock(colour + "_rock",  registryName -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_STAIRS.put(colour, registerRockVariantBlock(colour + "_rock_stairs",  registryName -> new RockStairBlock(DYED_ROCKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_SLABS.put(colour, registerRockVariantBlock(colour + "_rock_slab",  registryName -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_WALLS.put(colour, registerRockVariantBlock(colour + "_rock_wall", registryName -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            //DYED ROCK BRICKS
            DYED_ROCK_BRICKS.put(colour, registerRockBlock(colour + "_rock_bricks", registryName -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_BRICK_STAIRS.put(colour, registerRockVariantBlock(colour + "_rock_brick_stairs",  registryName -> new RockStairBlock(DYED_ROCK_BRICKS.get(colour).get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_BRICK_SLABS.put(colour, registerRockVariantBlock(colour + "_rock_brick_slab", registryName -> new RockSlabBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_ROCK_BRICK_WALLS.put(colour, registerRockVariantBlock(colour + "_rock_brick_wall", registryName -> new RockWallBlock(BlockBehaviour.Properties.ofFullCopy(DYED_ROCK_BRICKS.get(colour).get()).setId(JinxedRegistryHelper.blockKey(registryName)))));
            //DYED CHISELED ROCK
            CHISELED_DYED_ROCKS.put(colour, registerRockBlock("chiseled_" + colour + "_rock", registryName -> new RockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName)))));


            DYED_LADDERS.put(colour, registerDyedLadder(colour + "_ladder", registryName -> new DyedLadderBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).forceSolidOff().strength(0.4F).sound(SoundType.LADDER).noOcclusion().pushReaction(PushReaction.DESTROY))));

            DYED_DOORS.put(colour, registerDyedDoor(colour + "_door", registryName -> new DyedDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava())));
            DYED_TRAPDOORS.put(colour, registerDyedTrapdoor(colour + "_trapdoor", registryName -> new DyedTrapdoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(KBlocks::never).ignitedByLava())));

            DYED_LAMPS.put(colour, registerLampBlock(colour + "_lamp",  registryName -> new RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP.defaultBlockState().getBlock()).setId(JinxedRegistryHelper.blockKey(registryName)))));
        }
    }

    public static Supplier<Block> registerLampBlock(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new LampBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerRockBlock(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new RockBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerRockVariantBlock(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new RockVariantBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerDyedLadder(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new DyedLadderBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerDyedDoor(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new DyedDoorBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerDyedTrapdoor(String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new DyedTrapdoorBlockItem(block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }



    public static Supplier<Block> registerCompatRockBlock(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatRockBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerCompatRockVariantBlock(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatRockVariantBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerCompatDyedLadder(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatDyedLadderBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerCompatDyedDoor(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatDyedDoorBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerCompatDyedTrapdoor(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatDyedTrapdoorBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }

    public static Supplier<Block> registerCompatDyedLamp(String modID, String name, Function<Identifier, ? extends Block> function) {
        var block = JinxedRegistryHelper.registerBlock(Kaleidoscopic.MOD_ID, name, false, function);
        JinxedRegistryHelper.registerItem(Kaleidoscopic.MOD_ID, name, () -> new CompatDyedLampBlockItem(modID, block.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(Kaleidoscopic.MOD_ID, name))));
        return block;
    }




    private static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    public static void register() {}
}
