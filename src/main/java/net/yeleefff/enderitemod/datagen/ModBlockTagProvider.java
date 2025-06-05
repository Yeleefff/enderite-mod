package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.concurrent.CompletableFuture;

import static net.yeleefff.enderitemod.EnderiteMod.MOD_ID;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static RegistryKey<Block> keyOf(Block block) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, block.toString()));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        builder(BlockTags.PICKAXE_MINEABLE)
                .add(keyOf(ModBlocks.ENDERITE_ORE))
                .add(keyOf(ModBlocks.ENDERITE_BLOCK));

        builder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
                .add(keyOf(ModBlocks.ENDERITE_ORE))
                .add(keyOf(ModBlocks.ENDERITE_BLOCK));

        builder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        builder(ModTags.INCORRECT_FOR_ENDERITE_TOOL);

        builder(BlockTags.BEACON_BASE_BLOCKS)
                .add(keyOf(ModBlocks.ENDERITE_BLOCK));

        builder(BlockTags.DRAGON_IMMUNE)
                .add(keyOf(ModBlocks.ENDERITE_ORE))
                .add(keyOf(ModBlocks.ENDERITE_BLOCK));

//        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
//                .add(ModBlocks.ENDERITE_ORE)
//                .add(ModBlocks.ENDERITE_BLOCK);
//
//        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
//                .add(ModBlocks.ENDERITE_ORE)
//                .add(ModBlocks.ENDERITE_BLOCK);
//
//        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
//                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));
//
//        getOrCreateTagBuilder(ModTags.INCORRECT_FOR_ENDERITE_TOOL);
//
//        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
//                .add(ModBlocks.ENDERITE_BLOCK);
//
//        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
//                .add(ModBlocks.ENDERITE_ORE)
//                .add(ModBlocks.ENDERITE_BLOCK);
    }
}
