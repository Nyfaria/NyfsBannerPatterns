package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.registration.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.*;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.block.entity.*;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDamageTypeProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BANNER_PATTERN, ModDamageTypeProvider::addDamageType);

    public ModDamageTypeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Constants.MODID));
    }


    public static void addDamageType(BootstrapContext<BannerPattern> context) {
        registerBannerPattern(context, "pattern_a");
        registerBannerPattern(context, "pattern_b");
        registerBannerPattern(context, "pattern_c");
        registerBannerPattern(context, "pattern_d");
        registerBannerPattern(context, "pattern_e");
        registerBannerPattern(context, "pattern_f");
        registerBannerPattern(context, "pattern_g");
        registerBannerPattern(context, "pattern_h");
        registerBannerPattern(context, "pattern_i");
        registerBannerPattern(context, "pattern_j");
        registerBannerPattern(context, "pattern_k");
        registerBannerPattern(context, "pattern_l");
        registerBannerPattern(context, "pattern_m");
        registerBannerPattern(context, "pattern_n");
        registerBannerPattern(context, "pattern_o");
        registerBannerPattern(context, "pattern_p");
        registerBannerPattern(context, "pattern_q");
        registerBannerPattern(context, "pattern_r");
        registerBannerPattern(context, "pattern_s");
        registerBannerPattern(context, "pattern_t");
        registerBannerPattern(context, "pattern_u");
        registerBannerPattern(context, "pattern_v");
        registerBannerPattern(context, "pattern_w");
        registerBannerPattern(context, "pattern_x");
        registerBannerPattern(context, "pattern_y");
        registerBannerPattern(context, "pattern_z");
        registerBannerPattern(context, "pattern_0");
        registerBannerPattern(context, "pattern_1");
        registerBannerPattern(context, "pattern_2");
        registerBannerPattern(context, "pattern_3");
        registerBannerPattern(context, "pattern_4");
        registerBannerPattern(context, "pattern_5");
        registerBannerPattern(context, "pattern_6");
        registerBannerPattern(context, "pattern_7");
        registerBannerPattern(context, "pattern_8");
        registerBannerPattern(context, "pattern_9");
        registerBannerPattern(context, "pattern_comma");
        registerBannerPattern(context, "pattern_period");
        registerBannerPattern(context, "pattern_question_mark");
        registerBannerPattern(context, "pattern_exclamation_point");
        registerBannerPattern(context, "pattern_apostrophe");
        registerBannerPattern(context, "pattern_block");
        registerBannerPattern(context, "pattern_zombie");
        registerBannerPattern(context, "pattern_egg_outline");
        registerBannerPattern(context, "pattern_egg_inside_bottom");
        registerBannerPattern(context, "pattern_egg_inside_top");
        registerBannerPattern(context, "pattern_egg_inside_middle");
        registerBannerPattern(context, "pattern_easter_1");
        registerBannerPattern(context, "pattern_easter_2");
        registerBannerPattern(context, "pattern_easter_3");
        registerBannerPattern(context, "pattern_easter_4");
        registerBannerPattern(context, "pattern_llama");
        registerBannerPattern(context, "pattern_carrot_bottom");
        registerBannerPattern(context, "pattern_carrot_top");
        registerBannerPattern(context, "pattern_beetroot");
        registerBannerPattern(context, "pattern_emerald");
        registerBannerPattern(context, "pattern_diamond");
        registerBannerPattern(context, "pattern_vex");
        registerBannerPattern(context, "pattern_moon_full");
        registerBannerPattern(context, "pattern_moon_hl");
        registerBannerPattern(context, "pattern_moon_hr");
        registerBannerPattern(context, "pattern_moon_cl");
        registerBannerPattern(context, "pattern_moon_cr");
        registerBannerPattern(context, "pattern_moon_gl");
        registerBannerPattern(context, "pattern_moon_gr");
    }
    public static void registerBannerPattern(BootstrapContext<BannerPattern> context, String name) {
        context.register(ResourceKey.create(Registries.BANNER_PATTERN,ResourceLocation.fromNamespaceAndPath(Constants.MODID,name)),new BannerPattern(ResourceLocation.fromNamespaceAndPath(Constants.MODID,name),name));
    }
}
