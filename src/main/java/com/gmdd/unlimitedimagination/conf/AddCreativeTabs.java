package com.gmdd.unlimitedimagination.conf;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import com.gmdd.unlimitedimagination.clases.Blocks;
import com.gmdd.unlimitedimagination.clases.BlocksSnTxs;
import com.gmdd.unlimitedimagination.clases.Items;
import com.gmdd.unlimitedimagination.clases.Tabs;

public class AddCreativeTabs {
    public void addCreative(CreativeModeTabEvent.BuildContents event) {
        // Tabs del juego
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(Blocks.ZINCBLOCK);
        }
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(Blocks.RAWZINCBLOCK);
            event.accept(Blocks.ZINCORE);
            event.accept(Blocks.DEEPZINCORE);
        }
        if(event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(BlocksSnTxs.COPPERPRESSUREPLATE);
            event.accept(BlocksSnTxs.ZINCPRESSUREPLATE);
        }
        if(event.getTab() == CreativeModeTabs.INVENTORY) {
            event.accept(Items.COPPERDUST);
            event.accept(Items.RAWZINC);
            event.accept(Items.ZINCINGOT);
        }
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(Items.IRONSTICK);
        }
        // Tabs personalizadas
        if(event.getTab() == Tabs.UI_ELECTRICAL) {
            event.accept(Items.COPPERDUST);
            event.accept(Items.RAWZINC);
            event.accept(Items.ZINCINGOT);
            event.accept(Items.IRONSTICK);
            event.accept(BlocksSnTxs.COPPERPRESSUREPLATE);
            event.accept(BlocksSnTxs.ZINCPRESSUREPLATE);
        }
        if(event.getTab() == Tabs.UI_BLOCKS) {
            event.accept(Blocks.RAWZINCBLOCK);
            event.accept(Blocks.ZINCBLOCK);
            event.accept(Blocks.ZINCORE);
            event.accept(Blocks.DEEPZINCORE);
        }
    }
}
