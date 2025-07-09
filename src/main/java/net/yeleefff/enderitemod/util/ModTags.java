package net.yeleefff.enderitemod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;

public class ModTags {
    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = ofBlock(EnderiteMod.MOD_ID, "incorrect_for_enderite_tool");
    public static final TagKey<Item> ENDERITE_TOOL_MATERIALS = ofItem(EnderiteMod.MOD_ID, "enderite_tool_materials");
    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = ofItem(EnderiteMod.MOD_ID, "repairs_enderite_armor");

    public static final TagKey<Item> INGOTS = ofItem("c", "ingots");
    public static final TagKey<Block> ORES = ofBlock("c", "ores");
    public static final TagKey<Item> TOOLS = ofItem("c", "tools");
    public static final TagKey<Item> ARMORS = ofItem("c", "armors");

    private static TagKey<Block> ofBlock(String nameSpace, String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(nameSpace, name));
    }

    private static TagKey<Item> ofItem(String nameSpace, String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(nameSpace, name));
    }
}
