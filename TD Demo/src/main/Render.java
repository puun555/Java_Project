package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.*;
import java.io.File;
import java.util.random.*;

import javax.imageio.ImageIO;

public class Render {
    private GameScreen gameScreen;
    private Random random;
    private BufferedImage bufferedImage;

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public Render(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        random = new Random();
        loadSprite();
    }

    public void render(Graphics g) {
        switch(GameStates.gameStates) {
            case MENU:
                for (int y = 0; y < 20; y ++) {
                    for (int x = 0; x < 20; x++) {
                        g.drawImage(sprites.get(getRndIndex()), x*32, y*32, null);
                    }
                }
                break;
            case PLAYING:
                break;
            case SETTING:
                break;


        }
    }

    //getImg and Put in ArrayList( )
    private void loadSprite() {
        for (int y = 0; y < 3 ; y++) {
            for (int x = 0 ; x < 10 ; x++) {
                sprites.add(img.getSubimage(x*32, y*32, 32, 32));
            }
        }
    }

    //getIndex
    private int getRndIndex() {
        int index = random.nextInt(30);
        return index;
    }

    //import img set
    private void importImg(){
        try {
            Image img = ImageIO.read(new File("\\TD Demo\\src\\res\\spriteatlas.png"));
            bufferedImage = (BufferedImage) img;
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
