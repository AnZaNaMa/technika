package com.anzanama.technika.proxy;

import com.anzanama.technika.RegistryManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 10/2/2016.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        RegistryManager.init();
    }

    public void init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
