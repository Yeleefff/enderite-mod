package net.yeleefff.enderitemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;

import java.util.function.BiFunction;
import java.util.function.Function;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.METAL)
                    .mapColor(MapColor.BLACK)
                    .strength(50f, 1200.0F)
                    .requiresTool());

    public static final Block ENDERITE_ORE = registerBlock("enderite_ore", Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.METAL)
                    .mapColor(MapColor.BLACK)
                    .strength(30f, 1200.0F)
                    .requiresTool());

    private static RegistryKey<Item> keyOfItem(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
    }

    private static RegistryKey<Block> keyOfBlock(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }

    private static Block registerBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(keyOfBlock(id)));
        registerBlockItem(id, BlockItem::new, block, new Item.Settings().fireproof());
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, id), block);
    }

    private static void registerBlockItem(String id, BiFunction<Block, Item.Settings, BlockItem> factory, Block block, Item.Settings settings) {
        BlockItem item = factory.apply(block, settings.registryKey(keyOfItem(id)).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item);
//        item.appendBlocks(Item.BLOCK_ITEMS, item);
    }

    public static void registerModBlocks() {
        EnderiteMod.LOGGER.debug("Registering Mod Blocks for " + EnderiteMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(ENDERITE_ORE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ENDERITE_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(ENDERITE_ORE));
    }
}
