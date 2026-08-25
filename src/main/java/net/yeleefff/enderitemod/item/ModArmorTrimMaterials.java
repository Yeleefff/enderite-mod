package net.yeleefff.enderitemod.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.yeleefff.enderitemod.EnderiteMod;

import java.util.Map;

public class ModArmorTrimMaterials {
    static ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<TrimMaterial> ENDERITE = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(EnderiteMod.MOD_ID, "enderite"));
    public static final ResourceKey<EquipmentAsset> ENDERITE_ASSET_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(EnderiteMod.MOD_ID, "enderite"));

    public static void bootstrap(BootstrapContext<TrimMaterial> registry) {
        MaterialAssetGroup assets = MaterialAssetGroup.create("enderite", Map.of(ENDERITE_ASSET_KEY, "enderite_darker"));
        Component text = Component.translatable(Util.makeDescriptionId("trim_material", ENDERITE.identifier())).withStyle(Style.EMPTY.withColor(TextColor.parseColor("#1A5551").getOrThrow()));

        registry.register(ENDERITE, new TrimMaterial(assets, text));
    }

    private static ResourceKey<TrimMaterial> of(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.withDefaultNamespace(name));
    }
}
