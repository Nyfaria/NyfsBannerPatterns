package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.ItemInit;
import com.nyfaria.nyfsbp.init.TagInit;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;

public class CommonClass {

    public static void init() {
        TagInit.loadClass();
        BannerPatternInit.loadClass();
        ItemInit.loadClass();
    }

    public static void checkMoonPhase(MinecraftServer server){
        ServerLevel level = server.getLevel(Level.OVERWORLD);
        if (level != null && level.getDayTime() % 18000 == 0 && level.getMoonPhase() == 0) {
            server.getPlayerList().getPlayers().forEach(player -> {
                if (player.getRandom().nextInt(2) == 0) {
                    ItemEntity moonPatternEntity = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), ItemInit.PATTERN_ITEM_MOON.get().getDefaultInstance());
                    player.level().addFreshEntity(moonPatternEntity);
                }
            });
        }
    }
}