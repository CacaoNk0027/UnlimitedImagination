package com.gmdd.unlimitedimagination.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.gmdd.unlimitedimagination.ores.ConfigureFeatures;
import com.gmdd.unlimitedimagination.ores.PlacementFeatures;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public class UWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfigureFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacementFeatures::bootstrap);

    public UWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(UnlimitedImagination.MODID));
    }
}
