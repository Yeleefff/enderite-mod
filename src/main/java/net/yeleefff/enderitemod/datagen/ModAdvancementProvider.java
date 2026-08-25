package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder obtainEnderiteOre = Advancement.Builder.advancement().parent(Identifier.parse("end/root")).display(
                ModBlocks.ENDERITE_ORE,
                Component.literal("Hidden in the Void"),
                Component.literal("Obtain Enderite Debris"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            ).addCriterion("has_enderite_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ENDERITE_ORE))
                .save(consumer, EnderiteMod.MOD_ID + ":end/obtain_enderite_ore");

        AdvancementHolder obtainEnderiteArmor = Advancement.Builder.advancement().parent(obtainEnderiteOre).display(
                ModItems.ENDERITE_CHESTPLATE,
                Component.literal("Cover Me in Debris: The Sequel"),
                Component.literal("Get a full set of Enderite armor"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            ).rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("enderite_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS))
                .save(consumer, EnderiteMod.MOD_ID + ":end/enderite_armor");

        AdvancementHolder obtainEnderiteHoe = Advancement.Builder.advancement().parent(Identifier.parse("husbandry/obtain_netherite_hoe")).display(
                ModItems.ENDERITE_HOE,
                Component.literal("Too Much Dedication"),
                Component.literal("Use an Enderite Ingot to upgrade a Netherite Hoe after failing to rethink your life choices"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                true
            ).rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("enderite_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERITE_HOE))
                .save(consumer, EnderiteMod.MOD_ID + ":husbandry/obtain_enderite_hoe");
    }
}
