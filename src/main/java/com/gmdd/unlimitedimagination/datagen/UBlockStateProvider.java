package com.gmdd.unlimitedimagination.datagen;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.gmdd.unlimitedimagination.clases.Blocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class UBlockStateProvider extends BlockStateProvider {

    public UBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UnlimitedImagination.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(Blocks.ZINCORE);
        blockWithItem(Blocks.DEEPZINCORE);
        blockWithItem(Blocks.RAWZINCBLOCK);
        blockWithItem(Blocks.ZINCBLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
