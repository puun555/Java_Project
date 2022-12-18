/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import helpz.Constant.Mages;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import static main.GameStates.*;
import objects.MageTower;
import scenes.Playing;

/**
 *
 * @author sahad
 */
public class InGameBar {
    private int x,y,width,height;
    private MyButton bMenu;
    private Images allImage;
    private MyButton[] mageButton;
    private Playing playing;
    private MageTower selectedTower;
    private MageTower mageInfro;
    private final Font font = new Font("Monospaced", Font.BOLD, 17);
    public InGameBar(int x,int y,int width,int height, Playing playing){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;
        allImage = new Images();
        initButtons();
    }
    public void draw(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(x, y, width, height);
        drawButtons(g);
        drawDisplayMageInfro(g);
        
    }
    private void drawButtons(Graphics g) {
        bMenu.draw(g);
        for(MyButton m : mageButton){
            m.draw(g);
            
        }
        
    }

    private void initButtons() {
        bMenu = new MyButton(allImage.menu_button,2,642,100,30);
        mageButton = new MyButton[4];
        int w = 50;
        int h = 50;
        int xStart = 50;
	int yStart = 644;
	int xOffset = (int) (w * 1.3f);
        
        mageButton[0] = new MyButton(allImage.wind_button,xStart + xOffset * 1,yStart,w,h,0);
        mageButton[1] = new MyButton(allImage.ice_button,xStart + xOffset * 2,yStart,w,h,1);
        mageButton[2] = new MyButton(allImage.earth_button,xStart + xOffset * 3,yStart,w,h,2);
        mageButton[3] = new MyButton(allImage.fire_button,xStart + xOffset * 4,yStart,w,h,3);
        
    }
  
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x, y)){
            SetGameState(MENU);
        }else{
            for(MyButton m:mageButton){
                if(m.getBounds().contains(x,y)){
                    selectedTower = new MageTower(x,y,m.getId());
                    playing.setSelectedTower(selectedTower);
                    return;
                }
            }
        }
    }    
    public void mouseMove(int x, int y) {
        bMenu.setMouseOver(false);
        for(MyButton m : mageButton){
            m.setMouseOver(false);
        }
        if(bMenu.getBounds().contains(x, y)){
            bMenu.setMouseOver(true);
        }else{
            for(MyButton m : mageButton){
                if(m.getBounds().contains(x,y)){
                    m.setMouseOver(true);
                }
            }
        }
    }
    public void mousePressed(int x, int y) {
        bMenu.setMousePressed(false);
        if(bMenu.getBounds().contains(x, y)){
            bMenu.setMousePressed(true);
        }
    }
    public void mouseReleased(int x, int y) {
        bMenu.setMousePressed(false);
    }

    public void displayMageInfro(MageTower mt) {
        mageInfro = mt;
    }
    private void drawDisplayMageInfro(Graphics g){
        int yOffset = 20;
        if(mageInfro != null){
            g.drawImage(playing.getMageTowerManager().getMageSprite()[mageInfro.getTowerType()], 400,650 ,48 ,64 ,null);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("" + Mages.GetNameMage(mageInfro.getTowerType()), 460, 670);
            g.drawString("Price : " + Mages.GetCostMage(mageInfro.getTowerType()) + "$", 460, 670 + yOffset);
            
            //Draw border
//            g.drawRect(mageInfro.getX(), mageInfro.getY(), 32, 32);
            
            //Draw Range
            drawRangeMage(g);
           
        }
    }

    public void setMageInfro(MageTower mageInfro) {
        this.mageInfro = mageInfro;
    }

    private void drawRangeMage(Graphics g) {
        int range = (int)mageInfro.getRange()*2;
        g.setColor(Color.WHITE);
        g.drawOval(mageInfro.getX() - range/2 + 16, 
                mageInfro.getY() - range/2 + 16, range, range);
    }

   
    
   
    
}
