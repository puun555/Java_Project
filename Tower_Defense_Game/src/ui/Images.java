/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sahad
 */
public class Images {
    public BufferedImage img,start_button,logoImage,quit_button,background,menu_button;
    public Image normal_enemy,tanky_enemy,thieft_enemy,boss_enemy;
    public Image wind_mage,fire_mage,earth_mage,ice_mage;
    public Image fireBolt;
    public BufferedImage big_Tree,cut_Tree,big_Brush,farm,ver_brush,hor_brush;
    public BufferedImage wind_button,ice_button,fire_button,earth_button;
    public int x,y,width,height;
    public Images(){
        importImg();
    }
    private void importImg() {
        InputStream menu = getClass().getResourceAsStream("/res/menu.png");
        InputStream is = getClass().getResourceAsStream("/res/map.png");
        InputStream startButton = getClass().getResourceAsStream("/res/start_button.png");
        InputStream quitButton = getClass().getResourceAsStream("/res/quit_button.png");
        InputStream logo = getClass().getResourceAsStream("/res/logo.png");
        InputStream bg = getClass().getResourceAsStream("/res/background.jpg");
        //Enemies
        File normalEnemy = new File("src/res/Normal.gif");
        File tankyEnemy = new File("src/res/Tanky.gif");
        File thieftEnemy = new File("src/res/Thieft.gif");
        File bossEnemy = new File("src/res/Boss.gif");
        //Mages
        File windMage = new File("src/res/WindMage.gif");
        File iceMage = new File("src/res/IceMage.gif");
        File earthMage = new File("src/res/EarthMage.gif");
        File fireMage = new File("src/res/FireMage.gif");
        //Mage buttons
        InputStream windButton = getClass().getResourceAsStream("/res/wind_button.png");
        InputStream fireButton = getClass().getResourceAsStream("/res/fire_button.png");
        InputStream iceButton = getClass().getResourceAsStream("/res/ice_button.png");
        InputStream earthButton = getClass().getResourceAsStream("/res/earth_button.png");
        //Magic spell
        File fire_Bolt = new File("src/res/firebolt.gif");
        InputStream farmFile = getClass().getResourceAsStream("/res/Farm.gif"); 
        InputStream bigTree = getClass().getResourceAsStream("/res/big_tree.png");
        InputStream cutTree = getClass().getResourceAsStream("/res/cut_tree.png");
        InputStream bigBrush = getClass().getResourceAsStream("/res/big_brush.png");
        InputStream verBrush = getClass().getResourceAsStream("/res/vertical_brush.png");
        InputStream horBrush = getClass().getResourceAsStream("/res/horizontal_brush.png");
        try {
            menu_button = ImageIO.read(menu);
            img = ImageIO.read(is);
            start_button = ImageIO.read(startButton);
            quit_button = ImageIO.read(quitButton);
            logoImage = ImageIO.read(logo);
            background = ImageIO.read(bg);
            //Enemies
            normal_enemy = new ImageIcon(normalEnemy.getAbsolutePath()).getImage();
            tanky_enemy = new ImageIcon(tankyEnemy.getAbsolutePath()).getImage();
            thieft_enemy = new ImageIcon(thieftEnemy.getAbsolutePath()).getImage();
            boss_enemy = new ImageIcon(bossEnemy.getAbsolutePath()).getImage();
            //Mages
            wind_mage = new ImageIcon(windMage.getAbsolutePath()).getImage();
            fire_mage = new ImageIcon(fireMage.getAbsolutePath()).getImage();
            earth_mage = new ImageIcon(earthMage.getAbsolutePath()).getImage();
            ice_mage = new ImageIcon(iceMage.getAbsolutePath()).getImage();
            //Mage buttons
            wind_button = ImageIO.read(windButton);
            ice_button = ImageIO.read(iceButton);
            fire_button = ImageIO.read(fireButton);
            earth_button = ImageIO.read(earthButton);
            //Magic spell
            fireBolt = new ImageIcon(fire_Bolt.getAbsolutePath()).getImage();
            big_Tree = ImageIO.read(bigTree);
            cut_Tree = ImageIO.read(cutTree);
            big_Brush = ImageIO.read(bigBrush);
            farm = ImageIO.read(farmFile);
            ver_brush = ImageIO.read(verBrush);
            hor_brush = ImageIO.read(horBrush);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
