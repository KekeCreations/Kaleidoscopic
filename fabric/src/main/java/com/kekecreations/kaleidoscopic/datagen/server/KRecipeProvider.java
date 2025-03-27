package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.init.KTags;
import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class KRecipeProvider  extends FabricRecipeProvider {


    public KRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        for (DyeColor dyeColour : DyeColor.values()) {
            //Dyed Rocks
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK), dyeColour, KBlocks.DYED_ROCKS.get(dyeColour).get(), recipeOutput);
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS), dyeColour, KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_SLAB), dyeColour, KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_WALL), dyeColour, KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
            stairRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
            slabRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
            wallRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
            //Dyed Rock Bricks
            typeRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), recipeOutput);
            stairRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), recipeOutput);
            slabRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), recipeOutput);
            wallRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), recipeOutput);

        }

    }



    protected static void dyeSquareRecipe(Ingredient craftingBlock, DyeColor dyeColour, Block resultBlock, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,2)
                .pattern("XK")
                .pattern("KX")
                .define('K', craftingBlock)
                .define('X', DyeItem.byColor(dyeColour))
                .unlockedBy(getItemName(resultBlock), has(DyeItem.byColor(dyeColour)))
                .save(output, getItemName(resultBlock) + "_type");
    }

    protected static void typeRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("KK")
                .pattern("KK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void stairRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void slabRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void wallRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
}

