package com.gmdd.unlimitedimagination.datagen;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.gmdd.unlimitedimagination.clases.Items;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class UItemModelProvider extends ItemModelProvider {

    public UItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnlimitedImagination.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Items.COPPERDUST);
        simpleItem(Items.IRONSTICK);
        simpleItem(Items.RAWZINC);
        simpleItem(Items.ZINCINGOT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(UnlimitedImagination.MODID, "item/" + item.getId().getPath()));
    }

    @SuppressWarnings("unused")
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                        new ResourceLocation(UnlimitedImagination.MODID, "item/" + item.getId().getPath()));
    }
}
