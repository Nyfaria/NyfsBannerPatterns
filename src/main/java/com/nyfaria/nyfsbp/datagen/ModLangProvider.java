package com.nyfaria.nyfsbp.datagen;

import com.google.common.collect.ImmutableMap;
import com.nyfaria.nyfsbp.NyfsBP;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.BlockInit;
import com.nyfaria.nyfsbp.init.EntityInit;
import com.nyfaria.nyfsbp.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", ""
    );

    public ModLangProvider(DataGenerator gen) {
        super(gen, NyfsBP.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.ITEMS.getEntries().forEach(this::itemLang);
        EntityInit.ENTITIES.getEntries().forEach(this::entityLang);
        BlockInit.BLOCKS.getEntries().forEach(this::blockLang);
        BannerPatternInit.BANNER_PATTERNS.getEntries().forEach(this::bannerPatternLang);
        add("item.nyfsbp.egg_banner_pattern.desc","Egg");
    }

    private void bannerPatternLang(RegistryObject<BannerPattern> entry) {
        for(DyeColor color : DyeColor.values()){
            add("block.minecraft.banner."+entry.getId().getNamespace()+"." + entry.getId().getPath() + "." + color.getName(), checkReplace(color.getName()) + " " + checkReplace(entry));
        }
    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplace(entry));
        }
    }

    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}