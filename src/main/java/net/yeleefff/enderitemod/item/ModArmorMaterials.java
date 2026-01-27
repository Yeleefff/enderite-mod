package net.yeleefff.enderitemod.item;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.EnumMap;


public interface ModArmorMaterials {
    ResourceKey<EquipmentAsset> ENDERITE_ASSET_KEYS = ResourceKey.create(
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset")),
            Identifier.fromNamespaceAndPath(EnderiteMod.MOD_ID, "enderite"));

    ArmorMaterial ENDERITE = new ArmorMaterial(40, Util.make(new EnumMap(ArmorType.class), (enumMap) -> {
        enumMap.put(ArmorType.BOOTS, 3);
        enumMap.put(ArmorType.LEGGINGS, 6);
        enumMap.put(ArmorType.CHESTPLATE, 8);
        enumMap.put(ArmorType.HELMET, 3);
        enumMap.put(ArmorType.BODY, 11);
    }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 0.2f, ModTags.REPAIRS_ENDERITE_ARMOR, ENDERITE_ASSET_KEYS);
}