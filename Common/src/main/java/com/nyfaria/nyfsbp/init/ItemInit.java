package com.nyfaria.nyfsbp.init;

import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.registration.RegistrationProvider;
import com.nyfaria.nyfsbp.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

    public static final RegistryObject<Item> PATTERN_ITEM_EGG = registerBannerItem("egg_banner_pattern", TagInit.EGG_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_MOON = registerBannerItem("moon_banner_pattern", TagInit.MOON_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_VEX = registerBannerItem("vex_banner_pattern", TagInit.VEX_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_LLAMA = registerBannerItem("llama_banner_pattern", TagInit.LLAMA_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_CARROT = registerBannerItem("carrot_banner_pattern", TagInit.CARROT_BANNERS);
    //    public static final RegistryObject<Item> PATTERN_ITEM_PUMPKIN = registerBannerItem("pumpkin_banner_pattern", TagInit.PUMPKIN_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_BEETROOT = registerBannerItem("beetroot_banner_pattern", TagInit.BEETROOT_BANNERS);
    public static final RegistryObject<Item> PATTERN_ITEM_GEM = registerBannerItem("gem_banner_pattern", TagInit.GEM_BANNERS);
    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }
    public static RegistryObject<Item> registerBannerItem(String name, TagKey<BannerPattern> tag) {
        return ITEMS.register(name, () -> new BannerPatternItem(tag,getItemProperties().stacksTo(1)));
    }
    public static void loadClass() {
    }
}
