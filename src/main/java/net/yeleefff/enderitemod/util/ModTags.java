package net.yeleefff.enderitemod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;

public class ModTags {
    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = ofBlock("incorrect_for_enderite_tool");
    public static final TagKey<Item> ENDERITE_TOOL_MATERIALS = ofItem("enderite_tool_materials");
    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = ofItem("repairs_enderite_armor");

    private static TagKey<Block> ofBlock(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EnderiteMod.MOD_ID, id));
    }

    private static TagKey<Item> ofItem(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(EnderiteMod.MOD_ID, id));
    }
}
