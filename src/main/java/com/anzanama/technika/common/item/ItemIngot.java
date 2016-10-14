package com.anzanama.technika.common.item;

import com.anzanama.technika.Technika;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * CS18000 - NAME
 * <p>
 * DESCRIPTION
 *
 * @author Andrew Graber, lab sec B10
 * @version 10/11/2016
 */
public class ItemIngot extends Item {

    public ItemIngot(String name) {
        super();
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Technika.tab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
