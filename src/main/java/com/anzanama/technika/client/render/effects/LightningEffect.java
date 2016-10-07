package com.anzanama.technika.client.render.effects;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.util.Random;

/**
 * Created by Andrew Graber on 10/7/2016.
 */
public class LightningEffect {

    public static void drawLightningFromAtoB(Vec3d start, Vec3d end) {
        double distance = start.distanceTo(end);

    }
/*
    public static BlockPos jitter(BlockPos pos, double strength){
        Random rand = new Random();
        double x = pos.getX() + (strength*((2*rand.nextDouble())-1));
        double y = pos.getY() + (strength*((2*rand.nextDouble())-1));
        double z = pos.getZ() + (strength*((2*rand.nextDouble())-1));
        //return new BlockPos(pos.getX() + )
    }
    */
}
