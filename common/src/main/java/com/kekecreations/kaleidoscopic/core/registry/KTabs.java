package com.kekecreations.kaleidoscopic.core.registry;

import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryUtils;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;

import java.util.function.Supplier;

public class KTabs {

    public static final Supplier<CreativeModeTab> CONFIG_TAB = registerTab("configurable_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 5)
            .title(Component.translatable("tab." + Kaleidoscopic.MOD_ID + ".configurable_tab"))
            .icon(() -> KBlocks.DYED_ROCKS.get(DyeColor.BLUE).get().asItem().getDefaultInstance())
            .displayItems((params, pOutput) -> {
                for (DyeColor colour : JinxedCreativeCategoryUtils.colourOrder) {
                    pOutput.accept(KBlocks.DYED_ROCKS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_STAIRS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_SLABS.get(colour).get());
                    pOutput.accept(KBlocks.DYED_ROCK_WALLS.get(colour).get());
                }

            })
            .build()
    );

    public static Supplier<CreativeModeTab> registerTab(String name, Supplier<CreativeModeTab> supplier) {
        return JinxedRegistryHelper.register(BuiltInRegistries.CREATIVE_MODE_TAB, Kaleidoscopic.MOD_ID, name, supplier);
    }

    public static void register() {}
}
