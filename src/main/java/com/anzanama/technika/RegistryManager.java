package com.anzanama.technika;

import com.anzanama.technika.common.item.*;
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

    public static Item ingotDemonOsmium;
    public static Item ingotImpIron;
    public static Item ingotPixieSteel;
    public static Item ingotFairyGold;
    public static Item ingotDruidPlatinum;
    public static Item ingotAngelicAlloy;


    public static void init(){
        //ITEM REGISTRY
        GameRegistry.register(shockWand = new ItemShockWand("shockWand"));
        GameRegistry.register(ingotDemonOsmium = new ItemDemonOsmium("ingotDemonOsmium"));
        GameRegistry.register(ingotImpIron = new ItemImpIron("ingotImpIron"));
        GameRegistry.register(ingotPixieSteel = new ItemPixieSteel("ingotPixieSteel"));
        GameRegistry.register(ingotFairyGold = new ItemFairyGold("ingotFairyGold"));
        GameRegistry.register(ingotDruidPlatinum = new ItemDruidPlatinum("ingotDruidPlatinum"));
        GameRegistry.register(ingotAngelicAlloy = new ItemAngelicAlloy("ingotAngelicAlloy"));
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
        ((ItemDemonOsmium)ingotDemonOsmium).initModel();
        ((ItemImpIron)ingotImpIron).initModel();
        ((ItemPixieSteel)ingotPixieSteel).initModel();
        ((ItemFairyGold)ingotFairyGold).initModel();
        ((ItemDruidPlatinum)ingotDruidPlatinum).initModel();
        ((ItemAngelicAlloy)ingotAngelicAlloy).initModel();


        //BLOCKS
        //((BLOCK)block).initModel();
    }
}
