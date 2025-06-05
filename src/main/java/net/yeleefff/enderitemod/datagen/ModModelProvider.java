package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModArmorMaterials;
import net.yeleefff.enderitemod.item.ModItems;

public class ModModelProvider extends FabricModelProvider{
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(ModBlocks.ENDERITE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDERITE_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.ENDERITE_HELMET, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("helmet"), false);
        itemModelGenerator.registerArmor(ModItems.ENDERITE_CHESTPLATE, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("chestplate"), false);
        itemModelGenerator.registerArmor(ModItems.ENDERITE_LEGGINGS, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("leggings"), false);
        itemModelGenerator.registerArmor(ModItems.ENDERITE_BOOTS, ModArmorMaterials.ENDERITE_ASSET_KEYS, getTrimAssetIdPrefix("boots"), false);

        itemModelGenerator.register(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
    }

    public static Identifier getTrimAssetIdPrefix(String prefix) {
        return Identifier.of("enderitemod", "trims/items/" + prefix + "_trim");
    }
}
