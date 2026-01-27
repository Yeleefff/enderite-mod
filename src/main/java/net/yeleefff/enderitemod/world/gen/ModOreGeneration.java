package net.yeleefff.enderitemod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.world.feature.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        if (EnderiteMod.isPresent("enderscape")) {
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                    GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ENDERITE_ORE_PLACED_ENDERSCAPE_KEY);
        } else {
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                    GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ENDERITE_ORE_PLACED_KEY);
        }
    }
}