package com.kekecreations.kaleidoscopic.core.config;

import blue.endless.jankson.Comment;
import blue.endless.jankson.Jankson;
import blue.endless.jankson.api.DeserializationException;
import blue.endless.jankson.api.SyntaxError;
import com.kekecreations.kaleidoscopic.Kaleidoscopic;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;


//Original file was wrote by https://github.com/Iamnotagenius. Massive thanks to them!
public class FabricConfig implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<FabricConfig> PACKET_ID = new CustomPacketPayload.Type<>(Kaleidoscopic.id("sync_config"));
    public static final StreamCodec<FriendlyByteBuf, FabricConfig> PACKET_CODEC = StreamCodec.ofMember(FabricConfig::writeToClient, FabricConfig::readFromServer);


    private static File getConfigFile() {
        return Path.of(
                FabricLoader.getInstance().getConfigDir().toString(),
                Kaleidoscopic.MOD_ID,
                "config.json5"
        ).toFile();
    }

    private static final Jankson JANKSON = Jankson.builder()
            .registerSerializer(ResourceLocation.class, (id, marshaller) -> marshaller.serialize(id.toString()))
            .registerDeserializer(String.class, ResourceLocation.class, (str, marshaller) -> ResourceLocation.tryParse(str))
            .build();

    public static Component lastError;

    public void save() throws FileNotFoundException {
        getConfigFile().getParentFile().mkdirs();
        try (var outStream = new FileOutputStream(getConfigFile())) {
            outStream.write(JANKSON.toJson(this).toJson(true, true).getBytes());
        } catch (IOException e) {
            Kaleidoscopic.LOG.error("IO exception while saving config: {}", e.getMessage());
        }
    }

    public static FabricConfig load() {
        var defaults = new FabricConfig();
        try {
            if (getConfigFile().exists()) {
                lastError = null;
                var json = JANKSON.load(getConfigFile());
                return JANKSON.fromJsonCarefully(json, FabricConfig.class);
            }
            defaults.save();
            lastError = null;
            return defaults;
        } catch (SyntaxError e) {
            Kaleidoscopic.LOG.error("Config syntax error. {}.", e.getLineMessage());
            Kaleidoscopic.LOG.error(e.getMessage());
            Kaleidoscopic.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        } catch (DeserializationException e) {
            Kaleidoscopic.LOG.error("MCDE's config deserialization error.");
            Kaleidoscopic.LOG.error("{}", e.getMessage());
            if (e.getCause() != null) {
                Kaleidoscopic.LOG.error("Cause: {}", e.getCause().getMessage());
            }
            Kaleidoscopic.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        } catch (IOException e) {
            Kaleidoscopic.LOG.error("IO exception occured while reading config. Using defaults.");
            Kaleidoscopic.LOG.error(e.getMessage());
            Kaleidoscopic.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        }
        return defaults;
    }

    public static FabricConfig readFromServer(FriendlyByteBuf buf) {
        try {
            return JANKSON.fromJsonCarefully(buf.readUtf(), FabricConfig.class);
        } catch (SyntaxError | DeserializationException e) {
            Kaleidoscopic.LOG.error("Error while retrieving config from server: {}", e);
        }
        return null;
    }

    public void writeToClient(FriendlyByteBuf buf) {
        buf.writeUtf(JANKSON.toJson(this).toJson());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return PACKET_ID;
    }

    public static enum ListType {
        ALLOW, DENY
    }

    @Comment("Enables Dyed Rock blocks")
    private boolean isDyedRockEnabled = true;

    public boolean isDyedRockEnabled() {
        return isDyedRockEnabled;
    }

    @Comment("Enables Dyed Rock block variants")
    private boolean isDyedRockVariantsEnabled = true;

    public boolean isDyedRockVariantsEnabled() {
        return isDyedRockVariantsEnabled;
    }
}
