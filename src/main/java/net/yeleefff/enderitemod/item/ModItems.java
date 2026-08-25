package net.yeleefff.enderitemod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.mixin.NetheriteUpgradeSlotTexturesInvoker;

import java.util.List;
import java.util.function.Function;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModItems {
    public static final Item ENDERITE_SCRAP = registerItem("enderite_scrap", Item::new,
            new Item.Properties().fireResistant());
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", Item::new,
            new Item.Properties().fireResistant().trimMaterial(ModArmorTrimMaterials.ENDERITE));

    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template",
            settings -> new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MOD_ID,"smithing_template.enderite_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MOD_ID,"smithing_template.enderite_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MOD_ID,"smithing_template.enderite_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MOD_ID,"smithing_template.enderite_upgrade.additions_slot_description"))),
                NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyBaseSlotTextures(),
                NetheriteUpgradeSlotTexturesInvoker.invokeGetNetheriteUpgradeEmptyAdditionsSlotTextures(),
                settings),
            new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", Item::new,
            new Item.Properties().sword(ModToolMaterials.ENDERITE, 8, -2.4f).stacksTo(1).fireResistant());
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", Item::new,
            new Item.Properties().pickaxe(ModToolMaterials.ENDERITE,  6, -2.8f).stacksTo(1).fireResistant());
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
            settings -> new ShovelItem(ModToolMaterials.ENDERITE, 0.5f, -3f, settings),
            new Item.Properties().stacksTo(1).fireResistant());
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
            settings -> new AxeItem(ModToolMaterials.ENDERITE, 10, -3f, settings),
            new Item.Properties().stacksTo(1).fireResistant());
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
            settings -> new HoeItem(ModToolMaterials.ENDERITE, 0, 0f, settings),
            new Item.Properties().stacksTo(1).fireResistant());
    public static final Item ENDERITE_SPEAR = registerItem("enderite_spear", Item::new,
            new Item.Properties().spear(ModToolMaterials.ENDERITE, 1.20f, 1.275f, 3f, 2f, 6.5f, 4.5f, 5.1f, 8f, 4.6f)
                    .stacksTo(1).fireResistant());

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.ENDERITE, ArmorType.HELMET).stacksTo(1).fireResistant());
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.ENDERITE, ArmorType.CHESTPLATE).stacksTo(1).fireResistant());
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings", Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.ENDERITE, ArmorType.LEGGINGS).stacksTo(1).fireResistant());
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots", Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.ENDERITE, ArmorType.BOOTS).stacksTo(1).fireResistant());
    public static final Item ENDERITE_HORSE_ARMOR = registerItem("enderite_horse_armor", Item::new,
            new Item.Properties().horseArmor(ModArmorMaterials.ENDERITE).stacksTo(1).fireResistant());
    public static final Item ENDERITE_NAUTILUS_ARMOR = registerItem("enderite_nautilus_armor", Item::new,
            new Item.Properties().nautilusArmor(ModArmorMaterials.ENDERITE).stacksTo(1).fireResistant());

    public static final List<Item> ENDERITE_TOOLS_AND_ARMOR_LIST = List.of(
            ENDERITE_AXE, ENDERITE_PICKAXE, ENDERITE_SHOVEL, ENDERITE_HOE, ENDERITE_SWORD, ENDERITE_SPEAR,
            ENDERITE_HELMET, ENDERITE_CHESTPLATE, ENDERITE_LEGGINGS, ENDERITE_BOOTS, ENDERITE_HORSE_ARMOR, ENDERITE_NAUTILUS_ARMOR);

    private static ResourceKey<Item> keyOf(String id) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }

    private static Item registerItem(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(keyOf(id)));
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id), item);
    }

    public static void registerModItems() {
        EnderiteMod.LOGGER.debug("Registering Mod Items for " + MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.insertAfter(Items.NETHERITE_INGOT, ENDERITE_SCRAP, ENDERITE_INGOT);
            entries.insertAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ENDERITE_UPGRADE_SMITHING_TEMPLATE);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.insertAfter(Items.NETHERITE_HORSE_ARMOR, ENDERITE_HORSE_ARMOR);
            entries.insertAfter(Items.NETHERITE_SWORD, ENDERITE_SWORD);
            entries.insertAfter(Items.NETHERITE_BOOTS, ENDERITE_HELMET, ENDERITE_CHESTPLATE, ENDERITE_LEGGINGS, ENDERITE_BOOTS);
            entries.insertAfter(Items.NETHERITE_NAUTILUS_ARMOR, ENDERITE_NAUTILUS_ARMOR);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.insertAfter(Items.NETHERITE_HOE, ENDERITE_SHOVEL, ENDERITE_PICKAXE, ENDERITE_AXE, ENDERITE_HOE);
        });
    }
}
