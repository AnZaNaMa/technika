package com.anzanama.technika.lifeforce;

/**
 * CS18000 - NAME
 * <p>
 * DESCRIPTION
 *
 * @author Andrew Graber, lab sec B10
 * @version 10/11/2016
 */
public class Lifeforce {
    private double strength;
    private double purity;

    public Lifeforce(double strength, double purity){
        setStrength(strength);
        setPurity(purity);
    }

    public Lifeforce(double strength) {
        this(strength, 0);
    }

    public Lifeforce(){
        this(1, 0);
    }

    public void setStrength(double strength){
        if(strength >= 0 && strength <= 100){
            this.strength = strength;
        } else if(strength < 0){
            this.strength = 0;
        } else if(strength > 100){
            this.strength = 100;
        }
    }

    public void setPurity(double purity){
        if(purity >= -1 && purity <= 1){
            this.purity = purity;
        } else if(purity < -1){
            this.purity = -1;
        } else if(purity > 1){
            this.purity = 1;
        }
    }

    public double getStrength(){
        return strength;
    }

    public double getPurity(){
        return purity;
    }
}
