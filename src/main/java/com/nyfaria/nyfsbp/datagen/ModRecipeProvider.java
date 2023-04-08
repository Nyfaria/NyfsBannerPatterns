package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {
        ShapedRecipeBuilder.shaped(ItemInit.PATTERN_ITEM_GEM.get())
                .define('D', Items.DIAMOND)
                .define('E', Items.EMERALD)
                .define('P', Items.PAPER)
                .pattern("DED")
                .pattern("EPE")
                .pattern("DED")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(recipeSaver);
    }
}
