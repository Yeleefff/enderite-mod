package net.yeleefff.enderitemod.item;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.*;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.yeleefff.enderitemod.EnderiteMod;

import java.util.Map;

public class ModArmorTrimMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<ArmorTrimMaterial> ENDERITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(EnderiteMod.MOD_ID, "enderite"));
    public static final RegistryKey<EquipmentAsset> ENDERITE_ASSET_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(EnderiteMod.MOD_ID, "enderite"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registry) {
        ArmorTrimAssets assets = ArmorTrimAssets.of("enderite", Map.of(ENDERITE_ASSET_KEY, "enderite_darker"));
        Text text = Text.translatable(Util.createTranslationKey("trim_material", ENDERITE.getValue())).fillStyle(Style.EMPTY.withColor(TextColor.parse("#1A5551").getOrThrow()));

        registry.register(ENDERITE, new ArmorTrimMaterial(assets, text));
    }

    private static RegistryKey<ArmorTrimMaterial> of(String name) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.ofVanilla(name));
    }
}
