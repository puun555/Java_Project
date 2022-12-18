/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import helpz.Constant;

/**
 *
 * @author sahad
 */
public class MageTower {
    private int x,y;
    private int towerType;
    private double damage,range,cooldown;
    public MageTower(int x, int y,int towerType){
        this.x = x;
        this.y = y;
        this.towerType = towerType;
        setDamage();
        setRange();
        setCooldown();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTowerType() {
        return towerType;
    }

    private void setDamage() {
        damage = Constant.Mages.GetDamageMage(towerType);
    }

    private void setRange() {
        range = Constant.Mages.GetRangeMage(towerType);
    }

    private void setCooldown() {
        cooldown = Constant.Mages.GetCooldownMage(towerType);
    }

    public double getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }

    public double getCooldown() {
        return cooldown;
    }
    
   

   

    
        
    
}
