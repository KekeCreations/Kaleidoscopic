package com.kekecreations.kaleidoscopic.datagen.client.util;

import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class KModelTemplate {


    public static final ModelTemplate LADDER = createLadder(TextureSlot.PARTICLE, TextureSlot.TEXTURE);

    public static ModelTemplate createLadder(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation(Kaleidoscopic.MOD_ID, "block/ladder_template"))), Optional.empty(), textureSlots);
    }

}
