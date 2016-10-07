package com.anzanama.technika.common.block;

import com.anzanama.technika.Technika;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Andrew Graber on 10/7/2016.
 */
public class BlockTechnika extends Block {

    public BlockTechnika(Material material, String name){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Technika.tab);

    }

}
