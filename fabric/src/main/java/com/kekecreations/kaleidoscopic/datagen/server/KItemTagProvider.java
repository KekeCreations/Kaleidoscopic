package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.init.KTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class KItemTagProvider extends FabricTagProvider.ItemTagProvider{

    public KItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        canCraftRock();
        canCraftRockStairs();
        canCraftRockSlab();
        canCraftRockWall();
        canCraftDoor();
        canCraftTrapdoor();
    }

    private void canCraftRock() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_ROCK).setReplace(false)
                .add(Items.COBBLESTONE)
                .add(Items.COBBLED_DEEPSLATE)
                .add(Items.ANDESITE)
                .add(Items.DIORITE)
                .add(Items.GRANITE)
                .add(Items.MOSSY_COBBLESTONE);

    }

    private void canCraftRockStairs() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS).setReplace(false)
                .add(Items.COBBLESTONE_STAIRS)
                .add(Items.COBBLED_DEEPSLATE_STAIRS)
                .add(Items.ANDESITE_STAIRS)
                .add(Items.DIORITE_STAIRS)
                .add(Items.GRANITE_STAIRS)
                .add(Items.MOSSY_COBBLESTONE_STAIRS);

    }

    private void canCraftRockSlab() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_ROCK_SLAB).setReplace(false)
                .add(Items.COBBLESTONE_SLAB)
                .add(Items.COBBLED_DEEPSLATE_SLAB)
                .add(Items.ANDESITE_SLAB)
                .add(Items.DIORITE_SLAB)
                .add(Items.GRANITE_SLAB)
                .add(Items.MOSSY_COBBLESTONE_SLAB);

    }

    private void canCraftRockWall() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_ROCK_WALL).setReplace(false)
                .add(Items.COBBLESTONE_WALL)
                .add(Items.COBBLED_DEEPSLATE_WALL)
                .add(Items.ANDESITE_WALL)
                .add(Items.DIORITE_WALL)
                .add(Items.GRANITE_WALL)
                .add(Items.MOSSY_COBBLESTONE_WALL);

    }

    private void canCraftDoor() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_DOOR).setReplace(false)
                .addOptionalTag(ItemTags.WOODEN_DOORS);

    }

    private void canCraftTrapdoor() {
        this.getOrCreateTagBuilder(KTags.ItemTags.CAN_CRAFT_TRAPDOOR).setReplace(false)
                .addOptionalTag(ItemTags.WOODEN_TRAPDOORS);

    }
}
