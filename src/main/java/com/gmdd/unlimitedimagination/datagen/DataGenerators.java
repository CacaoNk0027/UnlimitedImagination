package com.gmdd.unlimitedimagination.datagen;

import java.util.concurrent.CompletableFuture;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnlimitedImagination.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<Provider> lockupProvider = event.getLookupProvider();

        generator.addProvider(true, new URecipeProvider(packOutput));
        generator.addProvider(true, ULootTableProvider.create(packOutput));
        generator.addProvider(true, new UBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new UItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new UWorldGenProvider(packOutput, lockupProvider));
    }
}
