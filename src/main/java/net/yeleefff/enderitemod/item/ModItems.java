package net.yeleefff.enderitemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.item.custom.ModAxeItem;
import net.yeleefff.enderitemod.item.custom.ModHoeItem;
import net.yeleefff.enderitemod.item.custom.ModPickaxeItem;
import net.yeleefff.enderitemod.mixin.NetheriteUpgradeSlotTexturesInvoker;

import java.util.List;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModItems {

    // Basic items
    public static final Item ENDERITE_SCRAP = registerItems("enderite_scrap",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_INGOT = registerItems("enderite_ingot",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItems("enderite_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier(MOD_ID,"smithing_template.enderite_upgrade.applies_to"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(MOD_ID,"smithing_template.enderite_upgrade.ingredients"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("upgrade", new Identifier(MOD_ID,"enderite_upgrade"))).formatted(Formatting.GRAY),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(MOD_ID,"smithing_template.enderite_upgrade.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(MOD_ID,"smithing_template.enderite_upgrade.additions_slot_description"))),
                    NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyBaseSlotTextures(),
                    NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyAdditionsSlotTextures()));

    // Tools
    public static final Item ENDERITE_SWORD = registerItems("enderite_sword",
            new SwordItem(ModToolMaterials.ENDERITE, 8, -2.4f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_SHOVEL = registerItems("enderite_shovel",
            new ShovelItem(ModToolMaterials.ENDERITE, 5.5f, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_PICKAXE = registerItems("enderite_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ENDERITE, 6, -2.8f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_AXE = registerItems("enderite_axe",
            new ModAxeItem(ModToolMaterials.ENDERITE, 10, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_HOE = registerItems("enderite_hoe",
            new ModHoeItem(ModToolMaterials.ENDERITE, 0, 0f,
                    new FabricItemSettings().fireproof()));

    // Armor
    public static final Item ENDERITE_HELMET = registerItems("enderite_helmet",
            new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.HELMET,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_CHESTPLATE = registerItems("enderite_chestplate",
            new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_LEGGINGS = registerItems("enderite_leggings",
            new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_BOOTS = registerItems("enderite_boots",
            new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS,
                    new FabricItemSettings().fireproof()));

    public static final List<Item> ENDERITE_TOOLS_AND_ARMOR_LIST = List.of(ModItems.ENDERITE_AXE, ModItems.ENDERITE_PICKAXE, ModItems.ENDERITE_SHOVEL, ModItems.ENDERITE_HOE, ModItems.ENDERITE_SWORD,
            ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS);

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDERITE_SCRAP);
        entries.add(ENDERITE_INGOT);
        entries.add(ENDERITE_UPGRADE_SMITHING_TEMPLATE);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDERITE_SWORD);
        entries.add(ENDERITE_HELMET);
        entries.add(ENDERITE_CHESTPLATE);
        entries.add(ENDERITE_LEGGINGS);
        entries.add(ENDERITE_BOOTS);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDERITE_SHOVEL);
        entries.add(ENDERITE_PICKAXE);
        entries.add(ENDERITE_AXE);
        entries.add(ENDERITE_HOE);
    }

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EnderiteMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnderiteMod.LOGGER.debug("Registering Mod Items for " + EnderiteMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}
