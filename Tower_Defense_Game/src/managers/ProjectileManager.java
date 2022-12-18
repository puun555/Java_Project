/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import java.awt.Color;
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
        
    }
    public void update(){
        
    }
    
    public void draw(Graphics g){
        for(Image im: projectImg){
            g.drawImage(im, 300, 300, null);
        }
    }
}
