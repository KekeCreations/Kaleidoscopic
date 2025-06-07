package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryHelper;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import com.kekecreations.kaleidoscopic.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class KTabs {

    public static final Supplier<CreativeModeTab> CONFIG_TAB = registerCreativeModeTab("configurable_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("tab." + Kaleidoscopic.MOD_ID + ".configurable_tab"))
            //.icon(() -> KBlocks.DYED_ROCKS.get(DyeColor.BLUE).get().asItem().getDefaultInstance())
            .icon(() -> new ItemStack(Items.STICK))
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

    private static <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<T> tabSupplier) {
        return Services.PLATFORM.registerCreativeModeTab(name, tabSupplier);
    }

    public static void register() {}
}
