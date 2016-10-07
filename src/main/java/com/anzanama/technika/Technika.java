package com.anzanama.technika;

import com.anzanama.technika.proxy.CommonProxy;
import com.anzanama.technika.reference.ModConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 10/2/2016.
 *
 * BUILT ON FORGE 2095
 *
 * ONLY THAT VERSION OF FORGE IS SUPPORTED FOR THIS BUILD OF THE MOD
 */
@Mod(modid = ModConstants.MODID, name = ModConstants.MODNAME, version = ModConstants.VERSION)
public class Technika {

    @SidedProxy(clientSide = "com.anzanama.technika.proxy.ClientProxy", serverSide = "com.anzanama.technika.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance("technika")
    public static Technika instance = new Technika();

    public static CreativeTabs tab = new CreativeTabs(ModConstants.MODID) {
        @Override
        public String getTabLabel(){
            return "technika";
        }
        @Override
        public Item getTabIconItem() {
            return Items.DIAMOND;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}

