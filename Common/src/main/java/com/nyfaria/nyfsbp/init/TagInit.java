package com.nyfaria.nyfsbp.init;

import com.nyfaria.nyfsbp.Constants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class TagInit {

    public static TagKey<BannerPattern> EGG_BANNERS = bannerPatternTag("egg_banners");
    public static TagKey<BannerPattern> MOON_BANNERS = bannerPatternTag("moon_banners");
    public static TagKey<BannerPattern> VEX_BANNERS = bannerPatternTag("vex_banners");
    public static TagKey<BannerPattern> LLAMA_BANNERS = bannerPatternTag("llama_banners");
    public static TagKey<BannerPattern> CARROT_BANNERS = bannerPatternTag("carrot_banners");
    public static TagKey<BannerPattern> PUMPKIN_BANNERS = bannerPatternTag("pumpkin_banners");
    public static TagKey<BannerPattern> BEETROOT_BANNERS = bannerPatternTag("beetroot_banners");
    public static TagKey<BannerPattern> GEM_BANNERS = bannerPatternTag("gem_banners");



    public static void loadClass() {

    }

    public static TagKey<BannerPattern> bannerPatternTag(String path) {
        return TagKey.create(Registry.BANNER_PATTERN_REGISTRY, new ResourceLocation(Constants.MODID,path));
    }

}