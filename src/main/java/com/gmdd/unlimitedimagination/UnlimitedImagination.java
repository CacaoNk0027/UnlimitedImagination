package com.gmdd.unlimitedimagination;

import com.gmdd.unlimitedimagination.init.Items;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UnlimitedImagination.MODID)
public class UnlimitedImagination {
    // id del mod
    public static final String MODID = "unlimitedimagination";
    
    // constructor de la clase 
    public UnlimitedImagination() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // carga de items
        Items.ITEMS.register(bus);
    }
}
