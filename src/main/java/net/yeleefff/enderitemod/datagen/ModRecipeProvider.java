package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.BlastingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 200, RecipeSerializer.SMELTING, SmeltingRecipe::new)
                        .group("enderite")
                        .criterion("has_enderite_ore", this.conditionsFromItem(ModBlocks.ENDERITE_ORE))
                        .offerTo(exporter, "enderitemod:" + RecipeGenerator.getItemPath(ModItems.ENDERITE_SCRAP) + "_from_smelting_" + RecipeGenerator.getItemPath(ModBlocks.ENDERITE_ORE));

                CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 100, RecipeSerializer.BLASTING, BlastingRecipe::new)
                        .group("enderite")
                        .criterion("has_enderite_ore", this.conditionsFromItem(ModBlocks.ENDERITE_ORE))
                        .offerTo(exporter, "enderitemod:" + RecipeGenerator.getItemPath(ModItems.ENDERITE_SCRAP) + "_from_blasting_" + RecipeGenerator.getItemPath(ModBlocks.ENDERITE_ORE));

                createShapeless(RecipeCategory.MISC, ModItems.ENDERITE_INGOT)
                        .input(ModItems.ENDERITE_SCRAP, 2)
                        .input(Items.ENDER_EYE, 2)
                        .group("enderite")
                        .criterion("has_enderite_scrap", this.conditionsFromItem(ModItems.ENDERITE_SCRAP))
                        .offerTo(exporter);

                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.ENDERITE_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_BLOCK, "enderitemod:enderite_block",
                        "enderite", "enderitemod:enderite_ingot_from_block", "enderite");

                offerSmithingTemplateCopyingRecipe(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Items.END_STONE);

                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.ENDERITE_AXE);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.ENDERITE_PICKAXE);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.ENDERITE_SHOVEL);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.ENDERITE_HOE);

                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.ENDERITE_SWORD);

                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.ENDERITE_HELMET);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ENDERITE_CHESTPLATE);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.ENDERITE_LEGGINGS);
                offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.ENDERITE_BOOTS);
            }

            public void offerEnderiteUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
                SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(ModItems.ENDERITE_INGOT), category, result)
                        .criterion("has_enderite_ingot", this.conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter, "enderitemod:" + RecipeGenerator.getItemPath(result) + "_smithing");
            }
        };
    }
}
