package com.gmdd.unlimitedimagination.datagen;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import java.util.List;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.gmdd.unlimitedimagination.clases.Blocks;
import com.gmdd.unlimitedimagination.clases.Items;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class URecipeProvider extends RecipeProvider implements IConditionBuilder {

    public URecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@SuppressWarnings("null") Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(Items.RAWZINC.get()), RecipeCategory.MISC, Items.ZINCINGOT.get(), 0.7f, 200,
                "zinc");

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, Items.RAWZINC.get(), RecipeCategory.MISC,
                Blocks.RAWZINCBLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, Items.ZINCINGOT.get(), RecipeCategory.MISC,
                Blocks.ZINCBLOCK.get());
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_,
            RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_,
                p_251687_, "_from_smelting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_,
            RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_,
            RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_,
            String p_249236_) {
        for (ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_)
                    .group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_250791_, new ResourceLocation(UnlimitedImagination.MODID, getItemName(p_250066_)) + p_249236_ + "_"
                            + getItemName(itemlike));
        }
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_,
            ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_),
                (String) null, getSimpleRecipeName(p_251689_), (String) null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_,
            ItemLike p_250042_,
            RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
            String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_)
                .unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(UnlimitedImagination.MODID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###")
                .pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_))
                .save(p_250423_, new ResourceLocation(UnlimitedImagination.MODID, p_250475_));
    }
}
