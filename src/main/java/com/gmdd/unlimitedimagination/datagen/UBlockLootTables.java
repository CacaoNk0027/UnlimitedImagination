package com.gmdd.unlimitedimagination.datagen;

import java.util.Set;

import com.gmdd.unlimitedimagination.clases.Blocks;
import com.gmdd.unlimitedimagination.clases.Items;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class UBlockLootTables extends BlockLootSubProvider {

    protected UBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // dropean su propio bloque
        dropSelf(Blocks.RAWZINCBLOCK.get());
        dropSelf(Blocks.ZINCBLOCK.get());

        // dropean otro material
        add(Blocks.ZINCORE.get(), (block) -> createOreDrop(Blocks.ZINCORE.get(), Items.RAWZINC.get()));
        add(Blocks.DEEPZINCORE.get(), (block) -> createOreDrop(Blocks.DEEPZINCORE.get(), Items.RAWZINC.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    
}
