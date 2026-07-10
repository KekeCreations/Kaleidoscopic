package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import com.kekecreations.kaleidoscopic.datagen.client.util.KModelTemplate;
import com.kekecreations.kaleidoscopic.datagen.client.util.KTextureMapping;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class KModelProvider extends FabricModelProvider {

    private static final PropertyDispatch<VariantMutator> ROTATION_HORIZONTAL_FACING = PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
            .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
            .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
            .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)
            .select(Direction.NORTH, BlockModelGenerators.NOP);;

    public KModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {

        for (DyeColor colour : DyeColor.values()) {
            generator.createTrivialCube(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
            BlockModelGenerators.BlockFamilyProvider rockBlock = generator.family(KBlocks.DYED_ROCKS.get(colour).get());
            rockBlock.stairs(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
            rockBlock.slab(KBlocks.DYED_ROCK_SLABS.get(colour).get());
            rockBlock.wall(KBlocks.DYED_ROCK_WALLS.get(colour).get());

            BlockModelGenerators.BlockFamilyProvider rockBrickBlock = generator.family(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
            rockBrickBlock.stairs(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
            rockBrickBlock.slab(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get());
            rockBrickBlock.wall(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());

            createDyedLadder(KBlocks.DYED_LADDERS.get(colour).get(), generator);
            generator.registerSimpleFlatItemModel(KBlocks.DYED_LADDERS.get(colour).get().asItem());
            generator.createDoor(KBlocks.DYED_DOORS.get(colour).get());
            generator.createOrientableTrapdoor(KBlocks.DYED_TRAPDOORS.get(colour).get());

            createRedstoneLamp(KBlocks.DYED_LAMPS.get(colour).get(), generator);
        }

        //compat
        generator.createTrivialCube(KBlocks.CHISELED_BLEACHED_ROCK.get());
        BlockModelGenerators.BlockFamilyProvider rockBlock = generator.family(KBlocks.BLEACHED_ROCK.get());
        rockBlock.stairs(KBlocks.BLEACHED_ROCK_STAIRS.get());
        rockBlock.slab(KBlocks.BLEACHED_ROCK_SLAB.get());
        rockBlock.wall(KBlocks.BLEACHED_ROCK_WALL.get());

        BlockModelGenerators.BlockFamilyProvider rockBlock2 = generator.family(KBlocks.BLEACHED_ROCK_BRICKS.get());
        rockBlock2.stairs(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get());
        rockBlock2.slab(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get());
        rockBlock2.wall(KBlocks.BLEACHED_ROCK_BRICK_WALL.get());

        createDyedLadder(KBlocks.BLEACHED_LADDER.get(), generator);
        generator.registerSimpleFlatItemModel(KBlocks.BLEACHED_LADDER.get().asItem());
        generator.createDoor(KBlocks.BLEACHED_DOOR.get());
        generator.createOrientableTrapdoor(KBlocks.BLEACHED_TRAPDOOR.get());
        createRedstoneLamp(KBlocks.BLEACHED_LAMP.get(), generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    }

    public static Variant plainModel(final Identifier model) {
        return new Variant(model);
    }

    public static MultiVariant variant(final Variant variant) {
        return new MultiVariant(WeightedList.of(variant));
    }

    public static MultiVariant plainVariant(final Identifier model) {
        return variant(plainModel(model));
    }

    public final void createDyedLadder(Block ladderBlock, BlockModelGenerators generator) {
        Identifier model = KModelTemplate.LADDER.create(ladderBlock, KTextureMapping.ladderTextureMappings(ladderBlock), generator.modelOutput);
        //generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(ladderBlock, MultiVariant.with(VariantProperties.MODEL, model)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(ladderBlock, plainVariant(ModelLocationUtils.getModelLocation(ladderBlock))).with(ROTATION_HORIZONTAL_FACING));
    }


    private void createRedstoneLamp(Block lamp, BlockModelGenerators generator) {
        MultiVariant off = plainVariant(generator.createSuffixedVariant(lamp, "_off", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        MultiVariant on = plainVariant(generator.createSuffixedVariant(lamp, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(lamp).with(generator.createBooleanModelDispatch(BlockStateProperties.LIT, on, off)));
        //generator.delegateItemModel(lamp, resourceLocation);
    }
}
