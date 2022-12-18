/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import helpz.Constant;
import static helpz.Constant.Mages.*;
import static helpz.Constant.Projectiles.*;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import objects.MageTower;
import objects.MagicProjectile;
import scenes.Playing;
import ui.Images;

/**
 *
 * @author sahad
 */
public class ProjectileManager {
    private Playing playing;
    private ArrayList<MagicProjectile> magic = new ArrayList<>();
    private Image[] projectImg;
    private Images image = new Images();
    public ProjectileManager(Playing playing){
        this.playing = playing;
        importImage();
    }
    
    private void importImage(){
        projectImg = new Image[4];
        projectImg[3] = image.fireBolt;
    }
    
    public void newProjectile(MageTower m, Enemy e){
        int type = getProjectileType(m);
        
        int xDistance = (int)Math.abs(m.getX() - e.getX());
        int yDistance = (int)Math.abs(m.getY() - e.getY());
        int totalDistance = xDistance + yDistance;
        
        float xPercent = (float)xDistance / totalDistance;
        float yPercent = 1.0f - xPercent;
        
        float xSpeed = xPercent * Constant.Projectiles.GetSpeed(type);
        float ySpeed = yPercent * Constant.Projectiles.GetSpeed(type);
        
        if(m.getX() > e.getX()){
            xSpeed *= -1;
        }
    } 
    public void update(){
        
    }
    
    public void draw(Graphics g){
        for(Image im: projectImg){
            g.drawImage(im, 300, 300, null);
        }
    }

    public int getProjectileType(MageTower m){
        switch(m.getTowerType()){
            case ICE:
                return ICE_SPELL;
            case EARTH:
                return EARTH_SPELL;
            case WIND:
                return WIND_SPELL;
            case FIRE:
                return FIRE_SPELL;
        }
        return 0;
    }
}
