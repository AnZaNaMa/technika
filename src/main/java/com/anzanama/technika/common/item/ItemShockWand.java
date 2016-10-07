package com.anzanama.technika.common.item;

import com.anzanama.technika.Technika;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Created by Andrew Graber on 10/2/2016.
 */
public class ItemShockWand extends ItemTool {
    public static SoundEvent shockingSound = new SoundEvent(new ResourceLocation("technika:shock"));//TODO

    public ItemShockWand(String name){
        super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(16);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
        if(stack.hasTagCompound()){
            tooltip.add("A Shockingly Useful Item!");
            tooltip.add(TextFormatting.BLUE + "Charge by intercepting lightning");
        }
        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase player, int timeLeft){
        if(timeLeft < 72000-12){
            attemptShock(stack, world, player);
            decrementUses(stack, player, player.getActiveHand());
        }
    }

    public void attemptShock(ItemStack stack, World world, EntityLivingBase player){
        if(player instanceof EntityPlayer){
            EntityPlayer playerEntity = (EntityPlayer)player;
            world.playSound(playerEntity.posX, playerEntity.posY, playerEntity.posZ, shockingSound, SoundCategory.PLAYERS, 0.95f+0.1f*itemRand.nextFloat(), 0.95f+0.1f*itemRand.nextFloat(), false);
            RayTraceResult result = world.rayTraceBlocks(player.getPositionVector(), player.getLookVec());
            IBlockState block = world.getBlockState(result.getBlockPos());
            if(block.getBlock() instanceof IShockable){
                ((IShockable)block).onShocked();
            }
        }
    }
}
