package com.nyfaria.nyfsbp.init;

import com.mojang.serialization.*;
import com.nyfaria.nyfsbp.*;
import com.nyfaria.nyfsbp.lootmodifiers.*;
import com.nyfaria.nyfsbp.registration.*;
import net.neoforged.neoforge.common.loot.*;
import net.neoforged.neoforge.registries.*;

public class LootModifierInit {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>,MapCodec<ExtraDropsLootModifier>> EXTRA_DROPS = LOOT_MODIFIERS.register("extra_drops", () -> ExtraDropsLootModifier.CODEC);
}