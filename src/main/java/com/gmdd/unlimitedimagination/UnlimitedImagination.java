package com.gmdd.unlimitedimagination;

import com.gmdd.unlimitedimagination.clases.Blocks;
import com.gmdd.unlimitedimagination.clases.Items;
import com.gmdd.unlimitedimagination.clases.Tabs;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
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

        bus.addListener(this::addCreative);
    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        // Tabs del juego
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(Blocks.RAWZINCBLOCK);
        }
        if(event.getTab() == CreativeModeTabs.INVENTORY) {
            event.accept(Items.COPPERDUST);
            event.accept(Items.RAWZINC);
            event.accept(Items.ZINCINGOT);
        }
        // Tabs personalizadas
        if(event.getTab() == Tabs.UI_ELECTRICAL) {
            event.accept(Items.COPPERDUST);
            event.accept(Items.RAWZINC);
            event.accept(Items.ZINCINGOT);
        }
        if(event.getTab() == Tabs.UI_BLOCKS) {
            event.accept(Blocks.RAWZINCBLOCK);
        }
    }
}
