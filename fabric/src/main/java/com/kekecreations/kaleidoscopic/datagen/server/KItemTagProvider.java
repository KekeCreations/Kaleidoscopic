package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.init.KTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class KItemTagProvider extends FabricTagProvider.ItemTagProvider{

    public KItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        canCraftRock();

    }

    private void canCraftRock() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_ROCK).setReplace(false)
                .add(Blocks.COBBLESTONE.asItem())
                .add(Blocks.COBBLED_DEEPSLATE.asItem())
                .add(Blocks.ANDESITE.asItem())
                .add(Blocks.DIORITE.asItem())
                .add(Blocks.GRANITE.asItem());

    }
}
