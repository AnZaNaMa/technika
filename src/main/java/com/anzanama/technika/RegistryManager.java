package com.anzanama.technika;

import com.anzanama.technika.common.item.ItemShockWand;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Graber on 10/7/2016.
 */
public class RegistryManager {
    public static Item shockWand;


    public static void init(){
        //ITEM REGISTRY
        GameRegistry.register(shockWand = new ItemShockWand("shockWand"));

        //BLOCK REGISTRY

        //TILE ENTITY REGISTRY
    }

    public static void registerRecipes(){
        //GameRegistry.addRecipe();

        //OreDictionary.registerOre(name, item);
    }

    public static void registerSounds(){
        GameRegistry.register(ItemShockWand.shockingSound, new ResourceLocation("technika:shock"));
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemRenderers(){
        //TESRs
        //ClientRegistry.bindTileEntitySpecialRenderer(class, object);

        //ITEM MODELS
        ((ItemShockWand)shockWand).initModel();

        //BLOCKS
        //((BLOCK)block).initModel();
    }
}
