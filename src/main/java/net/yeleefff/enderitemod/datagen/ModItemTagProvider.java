package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.yeleefff.enderitemod.item.ModItems;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.ENDERITE_INGOT);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDERITE_HELMET)
                .add(ModItems.ENDERITE_CHESTPLATE)
                .add(ModItems.ENDERITE_LEGGINGS)
                .add(ModItems.ENDERITE_BOOTS);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.ENDERITE_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.ENDERITE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.ENDERITE_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.ENDERITE_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.ENDERITE_HOE);

        valueLookupBuilder(ModTags.ENDERITE_TOOL_MATERIALS)
                .add(ModItems.ENDERITE_INGOT);

        valueLookupBuilder(ModTags.REPAIRS_ENDERITE_ARMOR)
                .add(ModItems.ENDERITE_INGOT);
    }
}