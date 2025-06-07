package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.kaleidoscopic.core.init.KTags;
import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.*;
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
            chiselRecipe(KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), KBlocks.CHISELED_DYED_ROCKS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.CHISELED_DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK), dyeColour, KBlocks.DYED_ROCKS.get(dyeColour).get(), recipeOutput);
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS), dyeColour, KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_SLAB), dyeColour, KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_WALL), dyeColour, KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            stairRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
            slabRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
            wallRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
            //Dyed Rock Bricks
            typeRecipe(KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            stairRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get());
            slabRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get());
            wallRecipe(KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), recipeOutput);
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get());
            //Dyed Ladders
            dyeSquareRecipe(Ingredient.of(new ItemStack(Items.LADDER)), dyeColour, KBlocks.DYED_LADDERS.get(dyeColour).get(), recipeOutput);
            //Dyed Doors
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_DOOR), dyeColour, KBlocks.DYED_DOORS.get(dyeColour).get(), recipeOutput);
            //Dyed Trapdoors
            dyeSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_TRAPDOOR), dyeColour, KBlocks.DYED_TRAPDOORS.get(dyeColour).get(), recipeOutput);
        }

        //COMPAT
        bleachSquareRecipe(Ingredient.of(new ItemStack(Items.LADDER)), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_LADDER.get(), recipeOutput);
        //Dyed Doors
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_DOOR), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_DOOR.get(), recipeOutput);
        //Dyed Trapdoors
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_TRAPDOOR), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_TRAPDOOR.get(), recipeOutput);

        //Dyed Rocks
        chiselRecipe(KBlocks.BLEACHED_ROCK_SLAB.get(), KBlocks.CHISELED_BLEACHED_ROCK.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.CHISELED_BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK.get());
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK.get(), recipeOutput);
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_STAIRS.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_STAIRS.get(), KBlocks.BLEACHED_ROCK.get());
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_SLAB), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_SLAB.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_SLAB.get(), KBlocks.BLEACHED_ROCK.get());
        bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_WALL), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_WALL.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_WALL.get(), KBlocks.BLEACHED_ROCK.get());
        stairRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_STAIRS.get(), recipeOutput);
        slabRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_SLAB.get(), recipeOutput);
        wallRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_WALL.get(), recipeOutput);
        //Dyed Rock Bricks
        typeRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_BRICKS.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK.get());
        stairRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), KBlocks.BLEACHED_ROCK.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), KBlocks.BLEACHED_ROCK_BRICKS.get());
        slabRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), KBlocks.BLEACHED_ROCK.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), KBlocks.BLEACHED_ROCK_BRICKS.get());
        wallRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), KBlocks.BLEACHED_ROCK.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), KBlocks.BLEACHED_ROCK_BRICKS.get());

    }


    protected static void bleachSquareRecipe(Ingredient craftingBlock, Item dyeColour, Block resultBlock, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,2)
                .pattern("XK")
                .pattern("KX")
                .define('K', craftingBlock)
                .define('X', dyeColour)
                .unlockedBy(getItemName(resultBlock), has(dyeColour))
                .save(output, getItemName(resultBlock) + "_type");
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

    protected static void chiselRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,1)
                .pattern("K")
                .pattern("K")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
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

