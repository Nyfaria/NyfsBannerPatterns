package com.nyfaria.nyfsbp.events;

import com.nyfaria.nyfsbp.*;
import com.nyfaria.nyfsbp.init.*;
import com.nyfaria.nyfsbp.registration.*;
import com.nyfaria.nyfsbp.registration.specialised.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.*;
import net.neoforged.fml.common.*;
import net.neoforged.neoforge.event.*;
import net.neoforged.neoforge.event.tick.*;

@EventBusSubscriber
public class CommonGameEvents {

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        CommonClass.checkMoonPhase(event.getServer());
    }
    @SubscribeEvent
    public static void onCMT(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            for (RegistryObject<Item, ? extends Item> entry : ItemInit.ITEMS.getEntries()) {
                event.accept(entry.get());
            }
        }
    }
}