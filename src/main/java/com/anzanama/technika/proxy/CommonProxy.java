package com.anzanama.technika.proxy;

import com.anzanama.technika.RegistryManager;
import com.anzanama.technika.lifeforce.LifeforceChunkManager;
import net.minecraftforge.common.MinecraftForge;
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
        MinecraftForge.EVENT_BUS.register(new LifeforceChunkManager());
    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
