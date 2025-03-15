package com.kekecreations.kaleidoscopic.datagen.client;

import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.DyeColor;

public class KModelProvider extends FabricModelProvider {
    public KModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {

        for (DyeColor colour : DyeColor.values()) {
            BlockModelGenerators.BlockFamilyProvider rockBlock = generator.family(KBlocks.DYED_ROCKS.get(colour).get());
            rockBlock.stairs(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
