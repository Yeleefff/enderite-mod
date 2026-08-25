package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;
import net.yeleefff.enderitemod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
        return new RecipeProvider(registries, exporter) {
            @Override
            public void buildRecipes() {
//                SimpleCookingRecipeBuilder.generic(Ingredient.of(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 200,  registries. registries.get(ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.withDefaultNamespace("smelting"))), SmeltingRecipe::new)
//                        .group("enderite")
//                        .unlockedBy("has_enderite_ore", this.has(ModBlocks.ENDERITE_ORE))
//                        .save(output, "enderitemod:" + RecipeProvider.getItemName(ModItems.ENDERITE_SCRAP) + "_from_smelting_" + RecipeProvider.getItemName(ModBlocks.ENDERITE_ORE));
//
//                SimpleCookingRecipeBuilder.generic(Ingredient.of(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 100, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new)
//                        .group("enderite")
//                        .unlockedBy("has_enderite_ore", this.has(ModBlocks.ENDERITE_ORE))
//                        .save(output, "enderitemod:" + RecipeProvider.getItemName(ModItems.ENDERITE_SCRAP) + "_from_blasting_" + RecipeProvider.getItemName(ModBlocks.ENDERITE_ORE));

                shapeless(RecipeCategory.MISC, ModItems.ENDERITE_INGOT)
                        .requires(ModItems.ENDERITE_SCRAP, 4)
                        .requires(Items.ENDER_EYE, 4)
                        .group("enderite")
                        .unlockedBy("has_enderite_scrap", this.has(ModItems.ENDERITE_SCRAP))
                        .save(output);

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.ENDERITE_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_BLOCK, "enderitemod:enderite_block",
                        "enderite", "enderitemod:enderite_ingot_from_block", "enderite");

                copySmithingTemplate(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Items.END_STONE);

                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.ENDERITE_AXE);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.ENDERITE_PICKAXE);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.ENDERITE_SHOVEL);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.ENDERITE_HOE);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.ENDERITE_SWORD);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_SPEAR, RecipeCategory.COMBAT, ModItems.ENDERITE_SPEAR);

                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.ENDERITE_HELMET);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ENDERITE_CHESTPLATE);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.ENDERITE_LEGGINGS);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.ENDERITE_BOOTS);

                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_HORSE_ARMOR, RecipeCategory.COMBAT, ModItems.ENDERITE_HORSE_ARMOR);
                offerEnderiteUpgradeRecipe(output, Items.NETHERITE_NAUTILUS_ARMOR, RecipeCategory.COMBAT, ModItems.ENDERITE_NAUTILUS_ARMOR);
            }

            public void offerEnderiteUpgradeRecipe(RecipeOutput exporter, Item input, RecipeCategory category, Item result) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input), this.tag(ModTags.ENDERITE_TOOL_MATERIALS), category, result)
                        .unlocks("has_enderite_ingot", this.has(ModTags.ENDERITE_TOOL_MATERIALS))
                        .save(exporter, RecipeProvider.getItemName(result) + "_smithing");
            }
        };
    }
}
