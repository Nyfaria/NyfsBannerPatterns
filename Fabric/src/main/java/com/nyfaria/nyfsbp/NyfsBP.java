package com.nyfaria.nyfsbp;

import com.nyfaria.nyfsbp.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

import java.util.List;

public class NyfsBP implements ModInitializer {

    @Override
    public void onInitialize() {
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        LootTableEvents.MODIFY.register((resourceManager, lootTables, resourceLocation, builder, lootTableSource) -> {
            if (EntityType.RABBIT.getDefaultLootTable().equals(resourceLocation)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                LootItemRandomChanceCondition.randomChance(0.1f).build())
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_EGG.get()));
                builder.pool(poolBuilder.build());
            }
            if (EntityType.VEX.getDefaultLootTable().equals(resourceLocation)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                LootItemRandomChanceCondition.randomChance(0.1f).build())
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_VEX.get()));
                builder.pool(poolBuilder.build());
            }
            if (EntityType.LLAMA.getDefaultLootTable().equals(resourceLocation)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(
                                LootItemRandomChanceCondition.randomChance(0.1f).build())
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_LLAMA.get()));
                builder.pool(poolBuilder.build());
            }
            if (Blocks.CARROTS.getLootTable().equals(resourceLocation)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(List.of(
                                LootItemRandomChanceCondition.randomChance(0.1f).build(),
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CARROTS).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarrotBlock.AGE, 7)).build()
                        ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_CARROT.get()));
                builder.pool(poolBuilder.build());
            }
            if (Blocks.BEETROOTS.getLootTable().equals(resourceLocation)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().conditionally(List.of(
                                LootItemRandomChanceCondition.randomChance(0.1f).build(),
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BEETROOTS).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarrotBlock.AGE, 3)).build()
                        ))
                        .add(LootItem.lootTableItem(ItemInit.PATTERN_ITEM_BEETROOT.get()));
                builder.pool(poolBuilder.build());
            }
        });
        ServerTickEvents.END_SERVER_TICK.register(CommonClass::checkMoonPhase);
    }
}
