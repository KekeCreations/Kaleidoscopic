package com.kekecreations.kaleidoscopic.datagen.client.util;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class KTextureMapping {

    public static TextureMapping ladderTextureMappings(Block block) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
                .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
    }

    public static Identifier getTexture(String texture, String modID) {
        return Identifier.fromNamespaceAndPath(modID, "block/" + texture);
    }
}
