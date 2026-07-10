package com.kekecreations.kaleidoscopic.datagen.server;

import com.kekecreations.kaleidoscopic.core.init.KRecipeUtils;
import com.kekecreations.kaleidoscopic.core.init.KTags;
import com.kekecreations.kaleidoscopic.core.registry.KBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import static net.minecraft.data.recipes.RecipeProvider.getHasName;
import static net.minecraft.data.recipes.RecipeProvider.getItemName;

public class KRecipeProvider extends FabricRecipeProvider {


    public KRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput recipeOutput) {
        return new RecipeProvider(registryLookup, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                for (DyeColor dyeColour : DyeColor.values()) {
                    //Dyed Rocks
                    chiselRecipe(itemLookup, KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), KBlocks.CHISELED_DYED_ROCKS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.CHISELED_DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_ROCK, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_ROCKS.get(dyeColour).get(), recipeOutput);
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_ROCK_SLAB, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get(), 2);
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_ROCK_WALL, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    stairRecipe(itemLookup, KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_STAIRS.get(dyeColour).get(), recipeOutput);
                    slabRecipe(itemLookup, KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_SLABS.get(dyeColour).get(), recipeOutput);
                    wallRecipe(itemLookup, KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_WALLS.get(dyeColour).get(), recipeOutput);
                    //Dyed Rock Bricks
                    typeRecipe(itemLookup, KBlocks.DYED_ROCKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    stairRecipe(itemLookup, KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_STAIRS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get());
                    slabRecipe(itemLookup, KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get(), 2);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_SLABS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), 2);
                    wallRecipe(itemLookup, KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), recipeOutput);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCKS.get(dyeColour).get());
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.DYED_ROCK_BRICK_WALLS.get(dyeColour).get(), KBlocks.DYED_ROCK_BRICKS.get(dyeColour).get());
                    //Dyed Ladders
                    dyeSquareRecipe(itemLookup, Items.LADDER, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_LADDERS.get(dyeColour).get(), recipeOutput);
                    //Dyed Doors
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_DOOR, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_DOORS.get(dyeColour).get(), recipeOutput);
                    //Dyed Trapdoors
                    dyeSquareRecipe(itemLookup, KTags.ItemTags.CAN_CRAFT_TRAPDOOR, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_TRAPDOORS.get(dyeColour).get(), recipeOutput);
                    //Dyed Lamps
                    dyeSquareRecipe(itemLookup, Items.REDSTONE_LAMP, KRecipeUtils.getDyeItem(dyeColour), KBlocks.DYED_LAMPS.get(dyeColour).get(), recipeOutput);
                }

                //COMPAT
                /*
                //bleachSquareRecipe(Ingredient.of(Items.REDSTONE_LAMP), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_LAMP.get(), recipeOutput);
                //bleachSquareRecipe(Ingredient.of(new ItemStack(Items.LADDER)), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_LADDER.get(), recipeOutput);
                //Dyed Doors
                //bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_DOOR), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_DOOR.get(), recipeOutput);
                //Dyed Trapdoors
                //bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_TRAPDOOR), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_TRAPDOOR.get(), recipeOutput);

                //Dyed Rocks
                chiselRecipe(KBlocks.BLEACHED_ROCK_SLAB.get(), KBlocks.CHISELED_BLEACHED_ROCK.get(), recipeOutput);
                stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.CHISELED_BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK.get());
                bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK.get(), recipeOutput);
                bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_STAIRS), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_STAIRS.get(), recipeOutput);
                stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_STAIRS.get(), KBlocks.BLEACHED_ROCK.get());
                bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_SLAB), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_SLAB.get(), recipeOutput);
                stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_SLAB.get(), KBlocks.BLEACHED_ROCK.get(), 2);
                bleachSquareRecipe(Ingredient.of(KTags.ItemTags.CAN_CRAFT_ROCK_WALL), ACItems.BLEACHDEW.get(), KBlocks.BLEACHED_ROCK_WALL.get(), recipeOutput);
                stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_WALL.get(), KBlocks.BLEACHED_ROCK.get());
                stairRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_STAIRS.get(), recipeOutput);
                slabRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_SLAB.get(), recipeOutput);
                wallRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_WALL.get(), recipeOutput);
                //Dyed Rock Bricks
                typeRecipe(KBlocks.BLEACHED_ROCK.get(), KBlocks.BLEACHED_ROCK_BRICKS.get(), recipeOutput);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK.get());
                stairRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), recipeOutput);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), KBlocks.BLEACHED_ROCK.get());
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get(), KBlocks.BLEACHED_ROCK_BRICKS.get());
                slabRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), recipeOutput);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), KBlocks.BLEACHED_ROCK.get(), 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_SLAB.get(), KBlocks.BLEACHED_ROCK_BRICKS.get(), 2);
                wallRecipe(KBlocks.BLEACHED_ROCK_BRICKS.get(), KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), recipeOutput);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), KBlocks.BLEACHED_ROCK.get());

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, KBlocks.BLEACHED_ROCK_BRICK_WALL.get(), KBlocks.BLEACHED_ROCK_BRICKS.get());
                 */
            }
        };
    }



    protected static void bleachSquareRecipe(HolderLookup.RegistryLookup<Item> lookup, TagKey<Item> craftingBlock, Item dyeColour, Block resultBlock, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KXK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('X', dyeColour)
                .unlockedBy(getHasName(resultBlock), has(dyeColour, lookup))
                .save(output, getItemName(resultBlock) + "_type");
    }


    protected static void dyeSquareRecipe(HolderLookup.RegistryLookup<Item> lookup, TagKey<Item> craftingBlock, Item dyeItem, Block resultBlock, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KXK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('X', dyeItem)
                .unlockedBy(getItemName(resultBlock), has(dyeItem, lookup))
                .save(output, getItemName(resultBlock) + "_type");
    }

    protected static void dyeSquareRecipe(HolderLookup.RegistryLookup<Item> lookup, Item craftingBlock, Item dyeItem, Block resultBlock, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KXK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('X', dyeItem)
                .unlockedBy(getItemName(resultBlock), has(dyeItem, lookup))
                .save(output, getItemName(resultBlock) + "_type");
    }

    protected static void chiselRecipe(HolderLookup.RegistryLookup<Item> lookup, Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,1)
                .pattern("K")
                .pattern("K")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock, lookup))
                .save(recipeConsumer);
    }

    protected static void typeRecipe(HolderLookup.RegistryLookup<Item> lookup, Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("KK")
                .pattern("KK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock, lookup))
                .save(recipeConsumer);
    }

    protected static void stairRecipe(HolderLookup.RegistryLookup<Item> lookup, Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock, lookup))
                .save(recipeConsumer);
    }

    protected static void slabRecipe(HolderLookup.RegistryLookup<Item> lookup, Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock, lookup))
                .save(recipeConsumer);
    }

    protected static void wallRecipe(HolderLookup.RegistryLookup<Item> lookup, Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(lookup, RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock, lookup))
                .save(recipeConsumer);
    }


    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(final ItemLike item, HolderLookup.RegistryLookup<Item> lookup) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(lookup, new ItemLike[]{item}));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(final ItemPredicate.Builder... predicates) {
        return inventoryTrigger((ItemPredicate[])Arrays.stream(predicates).map(ItemPredicate.Builder::build).toArray((cheese) -> new ItemPredicate[cheese]));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(final ItemPredicate... predicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(predicates)));
    }

    @Override
    public String getName() {
        return "KRecipeProvider";
    }
}

