package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.config.ExampleClientConfig;
import com.nyfaria.nyfsbp.config.ExampleConfig;
import com.nyfaria.nyfsbp.datagen.ModBlockStateProvider;
import com.nyfaria.nyfsbp.datagen.ModItemModelProvider;
import com.nyfaria.nyfsbp.datagen.ModLangProvider;
import com.nyfaria.nyfsbp.datagen.ModLootTableProvider;
import com.nyfaria.nyfsbp.datagen.ModRecipeProvider;
import com.nyfaria.nyfsbp.datagen.ModSoundProvider;
import com.nyfaria.nyfsbp.datagen.ModTagProvider;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.BlockInit;
import com.nyfaria.nyfsbp.init.EntityInit;
import com.nyfaria.nyfsbp.init.ItemInit;
import com.nyfaria.nyfsbp.init.LootModifierInit;
import com.nyfaria.nyfsbp.init.TagInit;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NyfsBP.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsBP {
    public static final String MODID = "nyfsbp";
    public static final Logger LOGGER = LogManager.getLogger();

    public NyfsBP() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ExampleConfig.CONFIG_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ExampleClientConfig.CLIENT_SPEC);

        TagInit.init();
        ItemInit.ITEMS.register(modBus);
        EntityInit.ENTITIES.register(modBus);
        BlockInit.BLOCKS.register(modBus);
        BlockInit.BLOCK_ENTITIES.register(modBus);
        BannerPatternInit.BANNER_PATTERNS.register(modBus);
        LootModifierInit.LOOT_MODIFIERS.register(modBus);
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        generator.addProvider(includeServer, new ModRecipeProvider(generator));
        generator.addProvider(includeServer, new ModLootTableProvider(generator));
        generator.addProvider(includeServer, new ModSoundProvider(generator, existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Blocks(generator, existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Items(generator, existingFileHelper));
        generator.addProvider(includeClient, new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(includeClient, new ModLangProvider(generator));
    }
}
