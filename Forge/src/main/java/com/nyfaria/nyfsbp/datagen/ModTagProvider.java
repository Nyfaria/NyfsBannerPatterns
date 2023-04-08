package com.nyfaria.nyfsbp.datagen;

import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.init.BannerPatternInit;
import com.nyfaria.nyfsbp.init.TagInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.tags.BannerPatternTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModTagProvider {

    public static class BannerPatterns extends BannerPatternTagsProvider {

        public BannerPatterns(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Constants.MODID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(BannerPatternTags.NO_ITEM_REQUIRED).add(
                    BannerPatternInit.PATTERN_A.getResourceKey(),
                    BannerPatternInit.PATTERN_B.getResourceKey(),
                    BannerPatternInit.PATTERN_C.getResourceKey(),
                    BannerPatternInit.PATTERN_D.getResourceKey(),
                    BannerPatternInit.PATTERN_E.getResourceKey(),
                    BannerPatternInit.PATTERN_F.getResourceKey(),
                    BannerPatternInit.PATTERN_G.getResourceKey(),
                    BannerPatternInit.PATTERN_H.getResourceKey(),
                    BannerPatternInit.PATTERN_I.getResourceKey(),
                    BannerPatternInit.PATTERN_J.getResourceKey(),
                    BannerPatternInit.PATTERN_K.getResourceKey(),
                    BannerPatternInit.PATTERN_L.getResourceKey(),
                    BannerPatternInit.PATTERN_M.getResourceKey(),
                    BannerPatternInit.PATTERN_N.getResourceKey(),
                    BannerPatternInit.PATTERN_O.getResourceKey(),
                    BannerPatternInit.PATTERN_P.getResourceKey(),
                    BannerPatternInit.PATTERN_Q.getResourceKey(),
                    BannerPatternInit.PATTERN_R.getResourceKey(),
                    BannerPatternInit.PATTERN_S.getResourceKey(),
                    BannerPatternInit.PATTERN_T.getResourceKey(),
                    BannerPatternInit.PATTERN_U.getResourceKey(),
                    BannerPatternInit.PATTERN_V.getResourceKey(),
                    BannerPatternInit.PATTERN_W.getResourceKey(),
                    BannerPatternInit.PATTERN_X.getResourceKey(),
                    BannerPatternInit.PATTERN_Y.getResourceKey(),
                    BannerPatternInit.PATTERN_Z.getResourceKey(),
                    BannerPatternInit.PATTERN_0.getResourceKey(),
                    BannerPatternInit.PATTERN_1.getResourceKey(),
                    BannerPatternInit.PATTERN_2.getResourceKey(),
                    BannerPatternInit.PATTERN_3.getResourceKey(),
                    BannerPatternInit.PATTERN_4.getResourceKey(),
                    BannerPatternInit.PATTERN_5.getResourceKey(),
                    BannerPatternInit.PATTERN_6.getResourceKey(),
                    BannerPatternInit.PATTERN_7.getResourceKey(),
                    BannerPatternInit.PATTERN_8.getResourceKey(),
                    BannerPatternInit.PATTERN_9.getResourceKey(),
                    BannerPatternInit.PATTERN_COMMA.getResourceKey(),
                    BannerPatternInit.PATTERN_PERIOD.getResourceKey(),
                    BannerPatternInit.PATTERN_EXCLAMATION_POINT.getResourceKey(),
                    BannerPatternInit.PATTERN_QUESTION_MARK.getResourceKey(),
                    BannerPatternInit.PATTERN_APOSTROPHE.getResourceKey()
            );

            tag(TagInit.EGG_BANNERS).add(
                    BannerPatternInit.PATTERN_EGG_OUTLINE.getResourceKey(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_TOP.getResourceKey(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_BOTTOM.getResourceKey(),
                    BannerPatternInit.PATTERN_EGG_INSIDE_MIDDLE.getResourceKey(),
                    BannerPatternInit.PATTERN_EASTER_1.getResourceKey(),
                    BannerPatternInit.PATTERN_EASTER_2.getResourceKey(),
                    BannerPatternInit.PATTERN_EASTER_3.getResourceKey(),
                    BannerPatternInit.PATTERN_EASTER_4.getResourceKey()
            );
            tag(TagInit.MOON_BANNERS).add(
                    BannerPatternInit.PATTERN_MOON_FULL.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_HR.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_HL.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_CL.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_CR.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_GL.getResourceKey(),
                    BannerPatternInit.PATTERN_MOON_GR.getResourceKey()
            );
            tag(TagInit.GEM_BANNERS).add(
                    BannerPatternInit.PATTERN_DIAMOND.getResourceKey(),
                    BannerPatternInit.PATTERN_EMERALD.getResourceKey()
            );
            tag(TagInit.CARROT_BANNERS).add(
                    BannerPatternInit.PATTERN_CARROT_BOTTOM.getResourceKey(),
                    BannerPatternInit.PATTERN_CARROT_TOP.getResourceKey()
            );
            tag(TagInit.BEETROOT_BANNERS).add(
                    BannerPatternInit.PATTERN_BEETROOT.getResourceKey()
            );
//            tag(TagInit.PUMPKIN_BANNERS).add(
//                    BannerPatternInit.PATTERN_PUMPKIN.getResourceKey()
//            );
            tag(TagInit.VEX_BANNERS).add(
                    BannerPatternInit.PATTERN_VEX.getResourceKey()
            );
            tag(TagInit.LLAMA_BANNERS).add(
                    BannerPatternInit.PATTERN_LLAMA.getResourceKey()
            );

        }


    }

}