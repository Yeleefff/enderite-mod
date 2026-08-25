package net.yeleefff.enderitemod.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.yeleefff.enderitemod.EnderiteMod;

import java.util.function.BiFunction;
import java.util.function.Function;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(50f, 1200.0F)
                    .requiresCorrectToolForDrops());

    public static final Block ENDERITE_ORE = registerBlock("enderite_ore", Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(30f, 1200.0F)
                    .requiresCorrectToolForDrops());

    private static ResourceKey<Item> keyOfItem(String id) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }

    private static ResourceKey<Block> keyOfBlock(String id) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }

    private static Block registerBlock(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = factory.apply(settings.setId(keyOfBlock(id)));
        registerBlockItem(id, BlockItem::new, block, new Item.Properties().fireResistant());
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, id), block);
    }

    private static void registerBlockItem(String id, BiFunction<Block, Item.Properties, BlockItem> factory, Block block, Item.Properties settings) {
        BlockItem item = factory.apply(block, settings.setId(keyOfItem(id)).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id), item);
//        item.appendBlocks(Item.BLOCK_ITEMS, item);
    }

    public static void registerModBlocks() {
        EnderiteMod.LOGGER.debug("Registering Mod Blocks for " + EnderiteMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries -> entries.insertAfter(Blocks.ANCIENT_DEBRIS, ENDERITE_ORE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> entries.insertAfter(Blocks.NETHERITE_BLOCK, ENDERITE_BLOCK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> entries.insertAfter(Blocks.ANCIENT_DEBRIS, ENDERITE_ORE));
    }
}
