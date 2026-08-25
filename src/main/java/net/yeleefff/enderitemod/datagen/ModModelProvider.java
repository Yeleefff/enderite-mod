package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModArmorMaterials;
import net.yeleefff.enderitemod.item.ModItems;

public class ModModelProvider extends FabricModelProvider{
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(ModBlocks.ENDERITE_ORE, TexturedModel.COLUMN);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ENDERITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_SCRAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_SPEAR, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.ENDERITE_HELMET, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("helmet"), false);
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERITE_CHESTPLATE, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("chestplate"), false);
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERITE_LEGGINGS, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("leggings"), false);
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERITE_BOOTS, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("boots"), false);

        itemModelGenerator.generateFlatItem(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
    }

    public static Identifier getTrimAssetIdPrefix(String prefix) {
        return Identifier.fromNamespaceAndPath("enderitemod", "trims/items/" + prefix + "_trim");
    }
}
