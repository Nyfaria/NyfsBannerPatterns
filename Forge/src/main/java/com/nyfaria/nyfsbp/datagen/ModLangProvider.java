package com.nyfaria.nyfsbp.datagen;

import com.google.common.collect.ImmutableMap;
import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.ItemInit;
import com.nyfaria.nyfsbp.registration.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.ITEMS.getEntries().forEach(this::itemLang);
        BannerPatternInit.BANNER_PATTERNS.getEntries().forEach(this::bannerPatternLang);
//        add("item.nyfsbp.egg_banner_pattern.desc","Egg");
//        add("item.nyfsbp.moon_banner_pattern.desc","Moon");
//        add("item.nyfsbp.vex_banner_pattern.desc","Vex");
//        add("item.nyfsbp.llama_banner_pattern.desc","LLama");
//        add("item.nyfsbp.gem_banner_pattern.desc","Gem");
    }

    private void bannerPatternLang(RegistryObject<BannerPattern> entry) {
        for(DyeColor color : DyeColor.values()){
            add("block.minecraft.banner."+entry.getId().getNamespace()+"." + entry.getId().getPath() + "." + color.getName(), checkReplace(color.getName()) + " " + checkReplace(entry));
        }
    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplaceBannerItem(entry));
            add(entry.get().getDescriptionId() + ".desc", checkReplaceBannerItemDesc(entry));
        }
    }

    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }


    protected String checkReplaceBannerItem(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .filter(s -> !s.isBlank() && List.of("banner", "pattern").contains(s))
                .map(this::checkReplace)
                .collect(Collectors.joining(" "))
                .trim();
    }
    protected String checkReplaceBannerItemDesc(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .filter(s -> !s.isBlank() && !List.of("banner", "pattern").contains(s))
                .map(this::checkReplace)
                .collect(Collectors.joining(" "))
                .trim();
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
