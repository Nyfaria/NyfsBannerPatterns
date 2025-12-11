package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.*;
import net.minecraft.data.*;
import net.neoforged.bus.api.*;
import net.neoforged.fml.common.*;
import net.neoforged.neoforge.data.event.*;

@EventBusSubscriber(modid = Constants.MODID)
public class DataGenEntrypoint {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(true, new ModDamageTypeProvider(packOutput, event.getLookupProvider()));
        generator.addProvider(true, new BPModelGenerator(packOutput));
    }
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(true, new ModDamageTypeProvider(packOutput, event.getLookupProvider()));
        generator.addProvider(true, new BPModelGenerator(packOutput));
    }
}
