package com.anzanama.technika.lifeforce;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * CS18000 - NAME
 * <p>
 * DESCRIPTION
 *
 * @author Andrew Graber, lab sec B10
 * @version 10/11/2016
 */
public class LifeforceChunkManager {

    @SubscribeEvent
    public void onChunkCreation(ChunkGeneratorEvent.ReplaceBiomeBlocks event){
        Chunk chunk = event.getWorld().getChunkFromChunkCoords(event.getX(), event.getZ());
        Biome biome = getMajorityBiome(chunk);
        if(event.getWorld().isRemote) return;

    }

    @SubscribeEvent
    public void onChunkNBTLoad(ChunkDataEvent.Load event){

    }

    @SubscribeEvent
    public void onChunkNBTUnload(ChunkDataEvent.Unload event){

    }

    public Biome getMajorityBiome(Chunk chunk){
        Hashtable<Biome,Integer> table = new Hashtable<Biome,Integer>();
        for(int x=0; x<16; x++){
            for(int z=0; z<16; z++){
                Biome biome = chunk.getBiome(new BlockPos(x, 0, z), chunk.getWorld().getBiomeProvider());
                if(!table.containsKey(biome)){
                    table.put(biome, 1);
                } else {
                    table.put(biome, table.get(biome) + 1);
                }
            }
        }
        Biome biome = null;
        for(Map.Entry<Biome,Integer> entry : table.entrySet()){
            if(biome == null){
                biome = entry.getKey();
            } else if(entry.getValue() > table.get(biome)){
                biome = entry.getKey();
            }
        }
        return biome;
    }
}
