package com.gmdd.unlimitedimagination.clases;

import com.gmdd.unlimitedimagination.UnlimitedImagination;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnlimitedImagination.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Tabs {
    public static CreativeModeTab UI_ELECTRICAL;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        UI_ELECTRICAL = event.registerCreativeModeTab(
            new ResourceLocation(UnlimitedImagination.MODID, "ui_electrical"), 
            t -> t.icon(() -> new ItemStack(
                Items.COPPERDUST.get()
            )).title(Component.translatable("creativemodetab.ui_electrical")));
    }
}
