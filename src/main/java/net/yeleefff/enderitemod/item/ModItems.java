package net.yeleefff.enderitemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.mixin.NetheriteUpgradeSlotTexturesInvoker;

import java.util.List;
import java.util.function.Function;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModItems {

    public static final Item ENDERITE_SCRAP = registerItems("enderite_scrap", Item::new,
            new Item.Settings().fireproof());
    public static final Item ENDERITE_INGOT = registerItems("enderite_ingot", Item::new,
            new Item.Settings().fireproof());

    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItems("enderite_upgrade_smithing_template",
            (settings) -> new SmithingTemplateItem(
                Text.translatable(Util.createTranslationKey("item", Identifier.of(MOD_ID,"smithing_template.enderite_upgrade.applies_to"))).formatted(Formatting.BLUE),
                Text.translatable(Util.createTranslationKey("item", Identifier.of(MOD_ID,"smithing_template.enderite_upgrade.ingredients"))).formatted(Formatting.BLUE),
                Text.translatable(Util.createTranslationKey("item", Identifier.of(MOD_ID,"smithing_template.enderite_upgrade.base_slot_description"))),
                Text.translatable(Util.createTranslationKey("item", Identifier.of(MOD_ID,"smithing_template.enderite_upgrade.additions_slot_description"))),
                NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyBaseSlotTextures(),
                NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyAdditionsSlotTextures(),
                settings),
            new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item ENDERITE_SWORD = registerItems("enderite_sword", Item::new,
            new Item.Settings().sword(ModToolMaterials.ENDERITE, 8, -2.4f).maxCount(1).fireproof());
    public static final Item ENDERITE_PICKAXE = registerItems("enderite_pickaxe", Item::new,
            new Item.Settings().pickaxe(ModToolMaterials.ENDERITE,  6, -2.8f).maxCount(1).fireproof());
    public static final Item ENDERITE_SHOVEL = registerItems("enderite_shovel",
            (settings) -> new ShovelItem(ModToolMaterials.ENDERITE, 0.5f, -3f, settings),
            new Item.Settings().maxCount(1).fireproof());
    public static final Item ENDERITE_AXE = registerItems("enderite_axe",
            (settings) -> new AxeItem(ModToolMaterials.ENDERITE, 10, -3f, settings),
            new Item.Settings().maxCount(1).fireproof());
    public static final Item ENDERITE_HOE = registerItems("enderite_hoe",
            (settings) -> new HoeItem(ModToolMaterials.ENDERITE, 0, 0f, settings),
            new Item.Settings().maxCount(1).fireproof());

    public static final Item ENDERITE_HELMET = registerItems("enderite_helmet", Item::new,
            new Item.Settings().armor(ModArmorMaterials.ENDERITE, EquipmentType.HELMET).maxCount(1).fireproof());
    public static final Item ENDERITE_CHESTPLATE = registerItems("enderite_chestplate", Item::new,
            new Item.Settings().armor(ModArmorMaterials.ENDERITE, EquipmentType.CHESTPLATE).maxCount(1).fireproof());
    public static final Item ENDERITE_LEGGINGS = registerItems("enderite_leggings", Item::new,
            new Item.Settings().armor(ModArmorMaterials.ENDERITE, EquipmentType.LEGGINGS).maxCount(1).fireproof());
    public static final Item ENDERITE_BOOTS = registerItems("enderite_boots", Item::new,
            new Item.Settings().armor(ModArmorMaterials.ENDERITE, EquipmentType.BOOTS).maxCount(1).fireproof());

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

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
    }

    private static Item registerItems(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(keyOf(id)));
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item);
    }

    public static void registerModItems() {
        EnderiteMod.LOGGER.debug("Registering Mod Items for " + MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}
