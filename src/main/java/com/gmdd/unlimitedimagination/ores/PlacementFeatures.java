package com.gmdd.unlimitedimagination.ores;

import java.util.List;

import com.gmdd.unlimitedimagination.UnlimitedImagination;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.*;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class PlacementFeatures {

    public static final ResourceKey<PlacedFeature> ZINCORE_PLACED = createKey("zincore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        register(context, ZINCORE_PLACED, configuredFeatures.getOrThrow(ConfigureFeatures.OVERWORLD_ZINCORE),
            OrePlacements.commonOrePlacement(30, HeightRangePlacement.uniform(
                VerticalAnchor.absolute(-30), 
                VerticalAnchor.absolute(30)
            )
        ));
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(UnlimitedImagination.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
