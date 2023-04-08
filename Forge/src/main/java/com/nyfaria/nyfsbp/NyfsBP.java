package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.datagen.ModItemModelProvider;
import com.nyfaria.nyfsbp.datagen.ModLangProvider;
import com.nyfaria.nyfsbp.datagen.ModRecipeProvider;
import com.nyfaria.nyfsbp.datagen.ModTagProvider;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.LootModifierInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsBP {
    
    public NyfsBP() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        LootModifierInit.LOOT_MODIFIERS.register(modBus);
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        generator.addProvider(event.includeClient(), new ModLangProvider(generator.getPackOutput()));
        generator.addProvider(includeServer, new ModItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.BannerPatterns(generator.getPackOutput(),event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeServer, new ModRecipeProvider(generator.getPackOutput()));
    }
}