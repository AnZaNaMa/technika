package com.anzanama.technika.common.item;

import com.anzanama.technika.RegistryManager;
import com.anzanama.technika.Technika;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Andrew Graber on 10/7/2016.
 */
public class ItemTool extends Item {

    public ItemTool(String name){
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Technika.tab);
        this.addPropertyOverride(new ResourceLocation("minecraft:pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    ItemStack itemstack = entityIn.getActiveItemStack();
                    return itemstack != null && itemstack.getItem() == RegistryManager.shockWand ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    public static void createData(ItemStack stack){
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger("maxUses", 16);
        stack.getTagCompound().setInteger("uses", 16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        ItemStack stack = new ItemStack(this);
        createData(stack);
        subItems.add(stack);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn){
        createData(stack);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.BOW;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        if(stack.hasTagCompound() && (getUses(stack) < getMaxUses(stack))){
            return true;
        }
        return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack){
        if(stack.hasTagCompound()){
            return 1.0-(double)getUses(stack)/(double)getMaxUses(stack);
        }
        return 1.0;
    }

    public static int getMaxUses(ItemStack stack){
        return stack.getTagCompound().getInteger("maxUses");
    }

    public static int getUses(ItemStack stack){
        return stack.getTagCompound().getInteger("uses");
    }

    public int getPercentRemaining(ItemStack stack){
        return (int)(((double)getUses(stack)/(double)getMaxUses(stack))*100);
    }

    @Override
    public int getItemStackLimit(ItemStack stack){
        return 1;
    }

    public boolean destroyWhenEmpty(){
        return false;
    }

    public static void decrementUses(ItemStack stack, EntityLivingBase player, EnumHand hand){
        stack.getTagCompound().setInteger("uses", getUses(stack)-1);
    }

    public boolean hasCharge(ItemStack stack){
        return getUses(stack) <= 0;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
        if(stack.hasTagCompound()){
            if(getPercentRemaining(stack) <= 10){
                tooltip.add("Uses Remaining: " + TextFormatting.RED + getUses(stack) + "/" + TextFormatting.WHITE + getMaxUses(stack));
            } else if(getPercentRemaining(stack) < 70){
                tooltip.add("Uses Remaining: " + TextFormatting.GOLD + getUses(stack) + "/" + TextFormatting.WHITE + getMaxUses(stack));
            } else {
                tooltip.add("Uses Remaining: " + TextFormatting.GREEN + getUses(stack) + "/" + TextFormatting.WHITE + getMaxUses(stack));
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        if(stack.hasTagCompound() && !player.isSneaking()){
            if(world.isRemote && Minecraft.getMinecraft().currentScreen != null){
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
            } else {
                player.setActiveHand(hand);
                return new ActionResult(EnumActionResult.SUCCESS, stack);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged){
        if(oldStack.hasTagCompound() && newStack.hasTagCompound()){
            if(slotChanged){
                return true;
            }
        }
        return slotChanged;
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
