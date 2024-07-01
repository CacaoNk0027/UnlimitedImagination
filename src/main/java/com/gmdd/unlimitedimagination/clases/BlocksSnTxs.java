package com.gmdd.unlimitedimagination.clases;

import com.gmdd.unlimitedimagination.UnlimitedImagination;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksSnTxs {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnlimitedImagination.MODID);

    public static final RegistryObject<Block> COPPERPRESSUREPLATE = blockRegister("copperpressureplate", () -> new PressurePlateBlock(
        PressurePlateBlock.Sensitivity.EVERYTHING, 
        BlockBehaviour.Properties.of(Material.METAL)
            .strength(5f)
            .noCollission(),
        BlockSetType.IRON
    ));

    public static final RegistryObject<Block> ZINCPRESSUREPLATE = blockRegister("zincpressureplate", () -> new PressurePlateBlock(
        PressurePlateBlock.Sensitivity.EVERYTHING, 
        BlockBehaviour.Properties.of(Material.METAL)
            .strength(5f)
            .noCollission(),
        BlockSetType.IRON
    ));

    // funcion para registrar bloques
    private static <T extends Block> RegistryObject<T> blockRegister(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block); 
        blockItemRegister(name, ret);
        return ret;
    }

    // funcion para registrar items de bloques o para asociar?
    private static <T extends Block> RegistryObject<Item> blockItemRegister(String name, RegistryObject<T> block) {
        return Items.ITEMS.register(name, () -> new BlockItem(
            block.get(), 
            new Item.Properties()
            )
        );
    }
}
