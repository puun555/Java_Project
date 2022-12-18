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
        private MyImage bLogo,bBg;
        private boolean mouseOver;
        private Images allImage;
	public Menu(Game game) {
		super(game);
		random = new Random();
                allImage = new Images();
		
		loadSprites();
                initButtons();
	}

	@Override
	public void render(Graphics g) {
            bBg.draw(g);
            bLogo.draw(g);
            drawButtons(g);
	}

	

	private void loadSprites() {
		for (int y = 0; y < 1; y++) {
			for (int x = 0; x < 9; x++) {
				sprites.add(allImage.img.getSubimage(x * 32, y * 32, 32, 32));
			}
		}

	}

	private int getRndInt() {
		return random.nextInt(100);
	}

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bQuit.draw(g);
    }

    private void initButtons() {
        int w = 150;
        int h = w/3;
        int x = 640 / 2 - w / 2;
        int y = 150;
        int yOffset = 80;
        bBg = new MyImage(allImage.background,0,0,672,740);
        bLogo = new MyImage(allImage.logoImage,640 / 2 - 250 / 2,20,250,250);
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