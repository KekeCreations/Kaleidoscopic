package com.kekecreations.kaleidoscopic.core.init;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

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

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Kaleidoscopic.MOD_ID, name));
        }

    }
}
