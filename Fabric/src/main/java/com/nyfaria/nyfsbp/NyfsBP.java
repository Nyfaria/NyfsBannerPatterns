package com.nyfaria.nyfsbp;

import com.jcraft.jorbis.*;
import com.nyfaria.nyfsbp.init.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.*;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.fabricmc.fabric.api.loot.v3.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.predicates.*;

import java.util.*;

public class NyfsBP implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(
            content -> {
                ItemInit.ITEMS.getEntries().forEach(entry -> {
                    content.accept(entry.get());
                });
            }
        );

        LootTableEvents.MODIFY.register((key,builder, loottables, provider) -> {
            if (EntityType.RABBIT.getDefaultLootTable().equals(key.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                List.of(
                                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                                        LootItemKilledByPlayerCondition.killedByPlayer().build()
                                ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_EGG.get()));
                builder.pool(poolBuilder.build());
            }
            if (EntityType.VEX.getDefaultLootTable().equals(key.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                List.of(
                                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                                        LootItemKilledByPlayerCondition.killedByPlayer().build()
                                ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_VEX.get()));
                builder.pool(poolBuilder.build());
            }
            if (EntityType.LLAMA.getDefaultLootTable().equals(key.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                List.of(
                                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                                        LootItemKilledByPlayerCondition.killedByPlayer().build()
                                ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_LLAMA.get()));
                builder.pool(poolBuilder.build());
            }
            if (Blocks.CARROTS.getLootTable().equals(key.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(List.of(
                                LootItemRandomChanceCondition.randomChance(0.05f).build(),
                                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(provider.lookup(Registries.ENTITY_TYPE).get(),EntityType.PLAYER))).build(),
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CARROTS).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarrotBlock.AGE, 7)).build()
                        ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_CARROT.get()));
                builder.pool(poolBuilder.build());
            }
            if (Blocks.BEETROOTS.getLootTable().equals(key.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(List.of(
                                LootItemRandomChanceCondition.randomChance(0.05f).build(),
                                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(provider.lookup(Registries.ENTITY_TYPE).get(),EntityType.PLAYER))).build(),
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BEETROOTS).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarrotBlock.AGE, 3)).build()
                        ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_BEETROOT.get()));
                builder.pool(poolBuilder.build());
            }
        });
        ServerTickEvents.END_SERVER_TICK.register(CommonClass::checkMoonPhase);
    }
}
