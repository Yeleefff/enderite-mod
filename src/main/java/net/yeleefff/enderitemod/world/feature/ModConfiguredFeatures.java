package net.yeleefff.enderitemod.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.block.ModBlocks;
import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERITE_ORE_KEY = registerKey("enderite_ore");
    public static final TagKey<Block> END_STONES = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "end_stones"));

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        List<OreFeatureConfig.Target> enderiteOres = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(END_STONES), ModBlocks.ENDERITE_ORE.getDefaultState())
        );

        register(context, ENDERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(enderiteOres, 3));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EnderiteMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}