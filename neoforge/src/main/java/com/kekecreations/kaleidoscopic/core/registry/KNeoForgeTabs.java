package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryHelper;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;

import java.util.function.Supplier;

public class KNeoForgeTabs {

    public static final Supplier<CreativeModeTab> CONFIG_TAB = registerTab("configurable_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("tab." + Kaleidoscopic.MOD_ID + ".configurable_tab"))
            .icon(() -> KBlocks.DYED_ROCKS.get(DyeColor.BLUE).get().asItem().getDefaultInstance())
            .displayItems((params, pOutput) -> {
                pOutput.accept(KBlocks.BLEACHED_DOOR.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrder) {
                    pOutput.accept(KBlocks.DYED_DOORS.get(colour).get());
                }
                pOutput.accept(KBlocks.BLEACHED_TRAPDOOR.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrder) {
                    pOutput.accept(KBlocks.DYED_TRAPDOORS.get(colour).get());
                }
                pOutput.accept(KBlocks.BLEACHED_LADDER.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrder) {
                    pOutput.accept(KBlocks.DYED_LADDERS.get(colour).get());
                }
                pOutput.accept(KBlocks.BLEACHED_LAMP.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrder) {
                    pOutput.accept(KBlocks.DYED_LAMPS.get(colour).get());
                }
                pOutput.accept(KBlocks.BLEACHED_ROCK.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_BRICKS.get());
                pOutput.accept(KBlocks.CHISELED_BLEACHED_ROCK.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_STAIRS.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_BRICK_STAIRS.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_SLAB.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_BRICK_SLAB.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_WALL.get());
                pOutput.accept(KBlocks.BLEACHED_ROCK_BRICK_WALL.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrder) {
                    pOutput.accept(KBlocks.DYED_ROCKS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
                    pOutput.accept(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_SLABS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_WALLS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());
                }
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> COMPAT_TAB = registerTab("compat_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("tab." + Kaleidoscopic.MOD_ID + ".compat_tab"))
            .icon(() -> KBlocks.DYED_LAMPS.get(DyeColor.RED).get().asItem().getDefaultInstance())
            .displayItems((params, pOutput) -> {
                for (DyeColor colour : DyeColor.values()) {
                    if (colour.getId() > 15) {
                        pOutput.accept(KBlocks.DYED_DOORS.get(colour).get());
                    }
                }
                for (DyeColor colour : DyeColor.values()) {
                    if (colour.getId() > 15) {
                        pOutput.accept(KBlocks.DYED_TRAPDOORS.get(colour).get());
                    }
                }
                for (DyeColor colour : DyeColor.values()) {
                    if (colour.getId() > 15) {
                        pOutput.accept(KBlocks.DYED_LADDERS.get(colour).get());
                    }
                }
                for (DyeColor colour : DyeColor.values()) {
                    if (colour.getId() > 15) {
                        pOutput.accept(KBlocks.DYED_LAMPS.get(colour).get());
                    }
                }
                for (DyeColor colour : DyeColor.values()) {
                    if (colour.getId() > 15) {
                        pOutput.accept(KBlocks.DYED_ROCKS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_BRICKS.get(colour).get());
                        pOutput.accept(KBlocks.CHISELED_DYED_ROCKS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_BRICK_STAIRS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_SLABS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_BRICK_SLABS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_WALLS.get(colour).get());
                        pOutput.accept(KBlocks.DYED_ROCK_BRICK_WALLS.get(colour).get());
                    }
                }
            })
            .build()
    );

    public static Supplier<CreativeModeTab> registerTab(String name, Supplier<CreativeModeTab> supplier) {
        return JinxedRegistryHelper.register(BuiltInRegistries.CREATIVE_MODE_TAB, Kaleidoscopic.MOD_ID, name, supplier);
    }

    public static void register() {}
}
