/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import helpz.Utilz;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objects.MageTower;
import scenes.Playing;
import ui.Images;

/**
 *
 * @author sahad
 */
public class MageTowerManager {
    private Playing playing;
    private BufferedImage[] mageButtonSprite;
    private Image[] mageSprite;
    private ArrayList<MageTower> mages = new ArrayList<>();
    private Images images;
    public MageTowerManager(Playing playing){
        this.playing = playing;
        images = new Images();
        drawMageSprite();
    }
    
    public void draw(Graphics g){
        for(MageTower m:mages){
            g.drawImage(mageSprite[m.getTowerType()], m.getX(), m.getY()-26,32,48, null);
        }
    }

    

    private void drawMageSprite() {
        mageSprite = new Image[4];
        mageSprite[0] = images.wind_mage;
        mageSprite[1] = images.ice_mage;
        mageSprite[2] = images.earth_mage;
        mageSprite[3] = images.fire_mage;
        
    }
    
    public void update() {
        spellEnemy();
    }
    private void spellEnemy() {
        for(MageTower m:mages){
            for(Enemy e: playing.getEnemyManager().getEnemies()){
                if(e.isAlive()){
                    if(isEnemyInRange(m,e)){
                        //attack

                        e.attacked(1);
                    }
                } 
            }
        }
    }
    private boolean isEnemyInRange(MageTower m, Enemy e) {
        int range = Utilz.GetHypoDistance(m.getX(), m.getY(), e.getX(), e.getY());
        System.out.println(e.getX());
        return range < m.getRange();
    }
    
    public BufferedImage[] getMageButtonSprite() {
        return mageButtonSprite;
    }

    public Image[] getMageSprite() {
        return mageSprite;
    }

    public void addTower(MageTower selectedTower, int x, int y) {
        mages.add(new MageTower(x,y,selectedTower.getTowerType()));
    }

    public MageTower getPosTower(int x, int y) {
        for(MageTower m:mages)
            if(m.getX() == x)
                if(m.getY() == y)
                    return m;
        return null;
    }

    

   
}
    

