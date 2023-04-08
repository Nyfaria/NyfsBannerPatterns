package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.NyfsBP;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.TagInit;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModTagProvider {

    public static class Items extends BannerPatternTagsProvider {

        public Items(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, NyfsBP.MODID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(BannerPatternTags.NO_ITEM_REQUIRED).add(
                    BannerPatternInit.PATTERN_A.get(),
                    BannerPatternInit.PATTERN_B.get(),
                    BannerPatternInit.PATTERN_C.get(),
                    BannerPatternInit.PATTERN_D.get(),
                    BannerPatternInit.PATTERN_E.get(),
                    BannerPatternInit.PATTERN_F.get(),
                    BannerPatternInit.PATTERN_G.get(),
                    BannerPatternInit.PATTERN_H.get(),
                    BannerPatternInit.PATTERN_I.get(),
                    BannerPatternInit.PATTERN_J.get(),
                    BannerPatternInit.PATTERN_K.get(),
                    BannerPatternInit.PATTERN_L.get(),
                    BannerPatternInit.PATTERN_M.get(),
                    BannerPatternInit.PATTERN_N.get(),
                    BannerPatternInit.PATTERN_O.get(),
                    BannerPatternInit.PATTERN_P.get(),
                    BannerPatternInit.PATTERN_Q.get(),
                    BannerPatternInit.PATTERN_R.get(),
                    BannerPatternInit.PATTERN_S.get(),
                    BannerPatternInit.PATTERN_T.get(),
                    BannerPatternInit.PATTERN_U.get(),
                    BannerPatternInit.PATTERN_V.get(),
                    BannerPatternInit.PATTERN_W.get(),
                    BannerPatternInit.PATTERN_X.get(),
                    BannerPatternInit.PATTERN_Y.get(),
                    BannerPatternInit.PATTERN_Z.get(),
                    BannerPatternInit.PATTERN_0.get(),
                    BannerPatternInit.PATTERN_1.get(),
                    BannerPatternInit.PATTERN_2.get(),
                    BannerPatternInit.PATTERN_3.get(),
                    BannerPatternInit.PATTERN_4.get(),
                    BannerPatternInit.PATTERN_5.get(),
                    BannerPatternInit.PATTERN_6.get(),
                    BannerPatternInit.PATTERN_7.get(),
                    BannerPatternInit.PATTERN_8.get(),
                    BannerPatternInit.PATTERN_9.get(),
                    BannerPatternInit.PATTERN_COMMA.get(),
                    BannerPatternInit.PATTERN_PERIOD.get(),
                    BannerPatternInit.PATTERN_EXCLAMATION_POINT.get(),
                    BannerPatternInit.PATTERN_QUESTION_MARK.get(),
                    BannerPatternInit.PATTERN_APOSTROPHE.get()
            );

            tag(TagInit.EGG_BANNERS).add(
                    BannerPatternInit.PATTERN_EGG_OUTLINE.get(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_TOP.get(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_BOTTOM.get(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_MIDDLE.get(),
                    BannerPatternInit.PATTERN_EASTER_1.get(),
                    BannerPatternInit.PATTERN_EASTER_2.get(),
                    BannerPatternInit.PATTERN_EASTER_3.get(),
                    BannerPatternInit.PATTERN_EASTER_4.get()
            );
            tag(TagInit.MOON_BANNERS).add(
                    BannerPatternInit.PATTERN_MOON_FULL.get(),
                    BannerPatternInit.PATTERN_MOON_HR.get(),
                    BannerPatternInit.PATTERN_MOON_HL.get(),
                    BannerPatternInit.PATTERN_MOON_CL.get(),
                    BannerPatternInit.PATTERN_MOON_CR.get(),
                    BannerPatternInit.PATTERN_MOON_GL.get(),
                    BannerPatternInit.PATTERN_MOON_GR.get()
            );
            tag(TagInit.GEM_BANNERS).add(
                    BannerPatternInit.PATTERN_DIAMOND.get(),
                    BannerPatternInit.PATTERN_EMERALD.get()
            );
            tag(TagInit.CARROT_BANNERS).add(
                    BannerPatternInit.PATTERN_CARROT_BOTTOM.get(),
                    BannerPatternInit.PATTERN_CARROT_TOP.get()
            );
            tag(TagInit.BEETROOT_BANNERS).add(
                    BannerPatternInit.PATTERN_BEETROOT.get()
            );
//            tag(TagInit.PUMPKIN_BANNERS).add(
//                    BannerPatternInit.PATTERN_PUMPKIN.get()
//            );
            tag(TagInit.VEX_BANNERS).add(
                    BannerPatternInit.PATTERN_VEX.get()
            );
            tag(TagInit.LLAMA_BANNERS).add(
                    BannerPatternInit.PATTERN_LLAMA.get()
            );

        }


    }

    public static class Blocks extends TagsProvider<Block> {

        public Blocks(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Registry.BLOCK, NyfsBP.MODID, existingFileHelper);
        }

        @Override
        protected void addTags() {

        }

        public void populateTag(TagKey<Block> tag, Supplier<Block>... items) {
            for (Supplier<Block> item : items) {
                tag(tag).add(item.get());
            }
        }
    }

}
