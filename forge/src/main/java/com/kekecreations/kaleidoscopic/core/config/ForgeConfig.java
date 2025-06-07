package com.kekecreations.kaleidoscopic.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue IS_DYED_ROCK_ENABLED;
    public static final ForgeConfigSpec.BooleanValue IS_DYED_ROCK_VARIANTS_ENABLED;

    public static final ForgeConfigSpec.BooleanValue ARE_DYED_LADDERS_ENABLED;
    public static final ForgeConfigSpec.BooleanValue ARE_DYED_DOORS_ENABLED;
    public static final ForgeConfigSpec.BooleanValue ARE_DYED_TRAPDOORS_ENABLED;


    static {
        BUILDER.push("Kaleidoscopic Config");

        BUILDER.comment("Setting these values to false will disable features using the vanilla isEnabled method");
        BUILDER.comment("It is recommended to create a new world after changing the config!");
        BUILDER.push("Features");

        IS_DYED_ROCK_ENABLED = BUILDER
                .comment("Enables Dyed Rock blocks")
                .define("dyedRockBlocks", true);

        IS_DYED_ROCK_VARIANTS_ENABLED = BUILDER
                .comment("Enables Dyed Rock block variants")
                .define("dyedRockVariantBlocks", true);

        ARE_DYED_LADDERS_ENABLED = BUILDER
                .comment("Enables Dyed Ladders!")
                .define("dyedLadders", true);

        ARE_DYED_DOORS_ENABLED = BUILDER
                .comment("Enables Dyed Doors!")
                .define("dyedDoors", true);

        ARE_DYED_TRAPDOORS_ENABLED = BUILDER
                .comment("Enables Dyed Trapdoors!")
                .define("dyedTrapdoors", true);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
