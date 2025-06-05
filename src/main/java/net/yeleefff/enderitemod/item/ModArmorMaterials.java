package net.yeleefff.enderitemod.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.EnumMap;


public interface ModArmorMaterials {
    RegistryKey<EquipmentAsset> ENDERITE_ASSET_KEYS = RegistryKey.of(
            RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
            Identifier.of(EnderiteMod.MOD_ID, "enderite"));

    ArmorMaterial ENDERITE = new ArmorMaterial(40, Util.make(new EnumMap(EquipmentType.class), (enumMap) -> {
        enumMap.put(EquipmentType.BOOTS, 3);
        enumMap.put(EquipmentType.LEGGINGS, 6);
        enumMap.put(EquipmentType.CHESTPLATE, 8);
        enumMap.put(EquipmentType.HELMET, 3);
        enumMap.put(EquipmentType.BODY, 11);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.2f, ModTags.REPAIRS_ENDERITE_ARMOR, ENDERITE_ASSET_KEYS);
}