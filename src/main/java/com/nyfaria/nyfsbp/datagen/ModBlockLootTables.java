package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.init.BlockInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.getBlockStream().filter(this::shouldDropSelf).forEach(BlockLoot::createBannerDrop);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.getBlockStream().filter(this::shouldGenerateLoot).toList();
    }

    protected Stream<Block> getBlockStream() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get);
    }

    protected boolean shouldDropSelf(Block block) {
        return shouldGenerateLoot(block);
    }

    protected boolean shouldGenerateLoot(Block block) {
        return block.asItem() != Items.AIR && !(block instanceof DropExperienceBlock);
    }

}
