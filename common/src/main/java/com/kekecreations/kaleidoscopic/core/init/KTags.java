package com.kekecreations.kaleidoscopic.core.init;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class KTags {

    public static class ItemTags {
        public static final TagKey<Item> CAN_CRAFT_ROCK
                = tag("can_craft_rock");

        public static final TagKey<Item> CAN_CRAFT_ROCK_STAIRS
                = tag("can_craft_rock_stairs");

        public static final TagKey<Item> CAN_CRAFT_ROCK_SLAB
                = tag("can_craft_rock_slab");

        public static final TagKey<Item> CAN_CRAFT_ROCK_WALL
                = tag("can_craft_rock_wall");


        public static final TagKey<Item> CAN_CRAFT_DOOR
                = tag("can_craft_door");

        public static final TagKey<Item> CAN_CRAFT_TRAPDOOR
                = tag("can_craft_trapdoor");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Kaleidoscopic.MOD_ID, name));
        }
    }
    public static class BlockTags {

        public static final TagKey<Block> ROCK
                = tag("rock");

        public static final TagKey<Block> CHISELED_ROCK
                = tag("chiseled_rock");

        public static final TagKey<Block> ROCK_STAIRS
                = tag("rock_stairs");

        public static final TagKey<Block> ROCK_SLAB
                = tag("rock_slab");

        public static final TagKey<Block> ROCK_WALL
                = tag("rock_wall");

        public static final TagKey<Block> ROCK_BRICKS
                = tag("rock_bricks");

        public static final TagKey<Block> ROCK_BRICK_STAIRS
                = tag("rock_brick_stairs");

        public static final TagKey<Block> ROCK_BRICK_SLAB
                = tag("rock_brick_slab");

        public static final TagKey<Block> ROCK_BRICK_WALL
                = tag("rock_brick_wall");

        public static final TagKey<Block> DYED_LADDERS
                = tag("dyed_ladders");

        public static final TagKey<Block> DYED_DOORS
                = tag("dyed_doors");

        public static final TagKey<Block> DYED_TRAPDOORS
                = tag("dyed_trapdoors");


        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Kaleidoscopic.MOD_ID, name));
        }

    }
}
