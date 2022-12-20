package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import ui.MyButton;
import static main.GameStates.*;
import ui.Images;
import ui.MyImage;
public class Menu extends GameScene implements SceneMethods {
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;
    private MyButton bPlaying,bSetting,bQuit,bMenu;
    private MyImage LogoUI,Background;
    private boolean mouseOver;
    private Images allImage;
    public Menu(Game game) {
        super(game);
        allImage = new Images();
        initButtons();
    }
    @Override
    public void render(Graphics g) {
        Background.draw(g);
        LogoUI.draw(g);
        drawButtons(g);
    }
	

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bQuit.draw(g);
    }

    private void initButtons() {
        int w = 150;
        int h = w/3;
        int x = 640 / 2 - w / 2;
        int y = 250;
        int yOffset = 80;
        Background = new MyImage(allImage.background,-20,0,672,800);
        LogoUI = new MyImage(allImage.logoImage,640 / 2 - 600 / 2,150,600,100);
        bPlaying = new MyButton(allImage.start_button,x,y+yOffset,w,h);
        bQuit = new MyButton(allImage.quit_button,x,y+yOffset*2,w,h);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bPlaying.getBounds().contains(x, y)){
            SetGameState(PLAYING);
            
        }else if(bQuit.getBounds().contains(x,y)){
            System.exit(0);
        }
    }

    @Override
    public void mouseMove(int x, int y) {
        bPlaying.setMouseOver(false);
        bQuit.setMouseOver(false);
        if(bPlaying.getBounds().contains(x, y)){
            bPlaying.setMouseOver(true);
        }if(bQuit.getBounds().contains(x, y)){
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        bPlaying.setMousePressed(false);
        bQuit.setMousePressed(false);
        if(bPlaying.getBounds().contains(x, y)){
            bPlaying.setMousePressed(true);
        }
        if(bQuit.getBounds().contains(x, y)){
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bPlaying.setMousePressed(false);
        bQuit.setMousePressed(false);
    }
    
   

}