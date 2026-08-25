package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ENDERITE_ORE)
                .add(ModBlocks.ENDERITE_BLOCK);

        valueLookupBuilder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("fabric", "needs_tool_level_4")))
                .add(ModBlocks.ENDERITE_ORE)
                .add(ModBlocks.ENDERITE_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("fabric", "needs_tool_level_4")));

        valueLookupBuilder(ModTags.INCORRECT_FOR_ENDERITE_TOOL);

        valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.ENDERITE_BLOCK);

        valueLookupBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.ENDERITE_ORE)
                .add(ModBlocks.ENDERITE_BLOCK);
    }
}
