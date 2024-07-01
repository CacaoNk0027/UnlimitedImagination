package com.gmdd.unlimitedimagination.ores;

import java.util.List;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.gmdd.unlimitedimagination.clases.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ConfigureFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ZINCORE = registerKey("zincore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldZincOres = List.of(
            OreConfiguration.target(
                stoneReplaceables,
                Blocks.ZINCORE.get().defaultBlockState()
            ),
            OreConfiguration.target(
                deepslateReplaceables,
                Blocks.DEEPZINCORE.get().defaultBlockState()
            )
        );

        // minerales
        register(context, OVERWORLD_ZINCORE, Feature.ORE, new OreConfiguration(overworldZincOres, 11));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UnlimitedImagination.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
