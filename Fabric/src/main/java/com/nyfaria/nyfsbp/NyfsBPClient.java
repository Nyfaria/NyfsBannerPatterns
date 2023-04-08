package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.init.ItemInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.impl.client.itemgroup.FabricCreativeGuiComponents;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

import java.util.List;

public class NyfsBPClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(
                (itemGroup) -> {
                    itemGroup.accept(ItemInit.PATTERN_ITEM_BEETROOT.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_CARROT.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_EGG.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_LLAMA.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_VEX.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_MOON.get());
                    itemGroup.accept(ItemInit.PATTERN_ITEM_GEM.get());
                }
        );
    }
}
