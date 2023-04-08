package com.nyfaria.nyfsbp.init;

import com.nyfaria.nyfsbp.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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

//    public static TagKey<Morph> morphTag(String path) {
//        return HMMMorphInit.getRegistry().tags().createTagKey(new ResourceLocation(HundredDaysStory.MODID, path));
//    }

    public static TagKey<Block> blockTag(String path) {
        return TagKey.create(Registries.BLOCK,new ResourceLocation(Constants.MODID, path));
    }

    public static TagKey<Item> itemTag(String path) {
        return TagKey.create(Registries.ITEM,new ResourceLocation(Constants.MODID, path));
    }
    public static TagKey<BannerPattern> bannerPatternTag(String path) {
        return TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(Constants.MODID,path));
    }

}