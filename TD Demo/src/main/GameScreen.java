package main;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.*;

public class GameScreen extends JPanel{
    private Dimension size;
    private Game game;
    private Render reder;

    public GameScreen(Game game) {
        this.game = game;
        reder = new Render(this);
        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}
