package com.gmdd.unlimitedimagination;

import com.gmdd.unlimitedimagination.clases.Blocks;
import com.gmdd.unlimitedimagination.clases.BlocksSnTxs;
import com.gmdd.unlimitedimagination.clases.Items;
import com.gmdd.unlimitedimagination.conf.AddCreativeTabs;
import com.gmdd.unlimitedimagination.conf.ClientSetup;

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
        Blocks.BLOCKS.register(bus);
        BlocksSnTxs.BLOCKS.register(bus);
        
        bus.addListener(new AddCreativeTabs()::addCreative);
        bus.addListener(new ClientSetup()::setupClient);
    }
}

/*
 * pagina para los recipes
 * https://misode.github.io/recipe/
 */