package com.anzanama.technika.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew Graber on 10/2/2016.
 */
public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
}
