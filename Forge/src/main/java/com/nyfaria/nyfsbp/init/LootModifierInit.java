package com.nyfaria.nyfsbp.init;

import com.mojang.serialization.Codec;
import com.nyfaria.nyfsbp.Constants;
import com.nyfaria.nyfsbp.NyfsBP;
import com.nyfaria.nyfsbp.lootmodifiers.ExtraDropsLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifierInit {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> EXTRA_DROPS = LOOT_MODIFIERS.register("extra_drops", () -> ExtraDropsLootModifier.CODEC);
}