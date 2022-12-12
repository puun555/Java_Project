package main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import java.awt.image.*;
import java.io.File;
import java.awt.*;

public class Game extends JFrame implements Runnable{

    private GameScreen gameScreen;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private MyMouseListener myMouseListener;
    private KeyboardListener keyboardListener;
    
    //constructor
    public Game() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen(this);
        add(gameScreen);

        pack();
        setVisible(true);

    }

    private void start() {
        gameThread = new Thread(this) {};

        gameThread.start();
    }


    //Thread
    @Override
    public void run() {
        //กูเอาทุกอย่างใส่ Thread
        
        double timePerFrames  = 1000000000.0/FPS_SET;
        double timePerUpdate  = 1000000000.0/UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            
            now = System.nanoTime();

            //render
            if (now- lastFrame >= timePerFrames) {
                repaint();
                lastFrame = now;
                frames++;
            }

            //Update
            if (now - lastUpdate >= timePerUpdate) {
                lastUpdate = now;
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS : " + frames + " | UPS : " + updates);
                frames  = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }
        
    }

    private void initInput() {
        myMouseListener = new MyMouseListener();
        keyboardListener = new KeyboardListener();
        //mouse
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        //keybord
        addKeyListener(keyboardListener);

        requestFocus();
    }





    //Main naja
    public static void main(String[] args) {
        Game game = new Game();
        game.initInput();
        game.start();

    }

}
