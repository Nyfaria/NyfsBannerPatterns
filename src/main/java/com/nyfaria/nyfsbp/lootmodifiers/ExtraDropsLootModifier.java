package com.nyfaria.nyfsbp.lootmodifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class ExtraDropsLootModifier extends LootModifier {
	public static final Codec<ExtraDropsLootModifier> CODEC = RecordCodecBuilder.create(builder -> codecStart(builder).and(
			ItemStack.CODEC.listOf().fieldOf("items").forGetter(instance -> instance.additionalStacks)
	).apply(builder, ExtraDropsLootModifier::new));

	private final List<ItemStack> additionalStacks;

	public ExtraDropsLootModifier(LootItemCondition[] conditions, List<ItemStack> additionalStacks) {
		super(conditions);

		this.additionalStacks = additionalStacks;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.addAll(additionalStacks);
		return generatedLoot;
	}
}