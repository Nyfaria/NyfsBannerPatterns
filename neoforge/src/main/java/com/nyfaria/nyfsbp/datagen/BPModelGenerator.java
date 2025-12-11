package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.*;
import com.nyfaria.nyfsbp.init.*;
import com.nyfaria.nyfsbp.registration.*;
import net.minecraft.client.data.models.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;

import java.util.*;
import java.util.stream.*;

public class BPModelGenerator extends ModelProvider {
    private final Map<ModelTemplate, ResourceLocation> models = new HashMap<>();


    public BPModelGenerator(PackOutput output) {
        super(output, Constants.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        ItemInit.ITEMS.getEntries().forEach(deferredItem -> {
            itemModels.generateFlatItem(deferredItem.get(), ModelTemplates.FLAT_ITEM);
        });

    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Stream.of();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ItemInit.ITEMS.getEntries().stream().map(RegistryObject::asHolder);
    }

}
