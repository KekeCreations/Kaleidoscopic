package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import com.kekecreations.kaleidoscopic.datagen.client.util.KModelTemplate;
import com.kekecreations.kaleidoscopic.datagen.client.util.KTextureMapping;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class KModelProvider extends FabricModelProvider {
    public KModelProvider(FabricDataOutput output) {
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
            generator.createSimpleFlatItemModel(KBlocks.DYED_LADDERS.get(colour).get());
            generator.createDoor(KBlocks.DYED_DOORS.get(colour).get());
            generator.createOrientableTrapdoor(KBlocks.DYED_TRAPDOORS.get(colour).get());
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
        generator.createSimpleFlatItemModel(KBlocks.BLEACHED_LADDER.get());
        generator.createDoor(KBlocks.BLEACHED_DOOR.get());
        generator.createOrientableTrapdoor(KBlocks.BLEACHED_TRAPDOOR.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }

    public final void createDyedLadder(Block ladderBlock, BlockModelGenerators generator) {
        ResourceLocation model = KModelTemplate.LADDER.create(ladderBlock, KTextureMapping.ladderTextureMappings(ladderBlock), generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(ladderBlock, Variant.variant().with(VariantProperties.MODEL, model)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }
}
