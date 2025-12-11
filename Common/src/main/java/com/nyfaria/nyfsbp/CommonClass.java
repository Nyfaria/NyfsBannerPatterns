package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.init.*;
import net.minecraft.server.*;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.item.*;
import net.minecraft.world.level.*;

public class CommonClass {

    public static void init() {
        ItemInit.loadClass();
        BlockInit.loadClass();
        EntityInit.loadClass();
        TagInit.loadClass();
        BannerPatternInit.loadClass();
    }
    public static void checkMoonPhase(MinecraftServer server){
        ServerLevel level = server.getLevel(Level.OVERWORLD);
        if (level != null && ((int)(level.getDayTime() % 24000L) == 18000) && level.getMoonPhase() == 0) {
            if(!server.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT))
                return;
            server.getPlayerList().getPlayers().forEach(player -> {
                if (player.getRandom().nextInt(20) == 0) {
                    ItemEntity moonPatternEntity = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), ItemInit.PATTERN_ITEM_MOON.get().getDefaultInstance());
                    player.level().addFreshEntity(moonPatternEntity);
                }
            });
        }
    }
}