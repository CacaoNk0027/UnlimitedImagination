package com.gmdd.unlimitedimagination.clases;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "unlimitedimagination");

    // Aca se registran todos los items
    
    // public static final RegistryObject<Item> NOMBREITEM = ITEMS.register("nombreitem", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPERDUST = ITEMS.register("copperdust",
        () -> new Item(new Item.Properties())
    );
}
