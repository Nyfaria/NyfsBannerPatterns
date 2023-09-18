package com.nyfaria.nyfsbp.events;

import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.init.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Constants.MODID)
public class ClientModEvents {

    @SubscribeEvent
    public static void onCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if(!event.getTab().equals(CreativeModeTabs.INGREDIENTS))return;
        ItemInit.ITEMS.getEntries().forEach(
                item -> event.accept(item.get().getDefaultInstance())
        );
    }
}
