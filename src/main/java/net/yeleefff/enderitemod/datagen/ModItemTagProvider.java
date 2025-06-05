package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.item.ModItems;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.concurrent.CompletableFuture;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    private static RegistryKey<Item> keyOf(Item item) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, item.toString()));
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        builder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(keyOf(ModItems.ENDERITE_INGOT));

        builder(ItemTags.TRIMMABLE_ARMOR)
                .add(keyOf(ModItems.ENDERITE_HELMET))
                .add(keyOf(ModItems.ENDERITE_CHESTPLATE))
                .add(keyOf(ModItems.ENDERITE_LEGGINGS))
                .add(keyOf(ModItems.ENDERITE_BOOTS));

        builder(ModTags.ENDERITE_TOOL_MATERIALS);

        builder(ModTags.REPAIRS_ENDERITE_ARMOR)
                .add(keyOf(ModItems.ENDERITE_INGOT));

//        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
//                .add(ModItems.ENDERITE_INGOT);
//
//        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
//                .add(ModItems.ENDERITE_HELMET)
//                .add(ModItems.ENDERITE_CHESTPLATE)
//                .add(ModItems.ENDERITE_LEGGINGS)
//                .add(ModItems.ENDERITE_BOOTS);
//
//        getOrCreateTagBuilder(ModTags.ENDERITE_TOOL_MATERIALS);
//
//        getOrCreateTagBuilder(ModTags.REPAIRS_ENDERITE_ARMOR)
//                .add(ModItems.ENDERITE_INGOT);
    }
}