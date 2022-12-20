package objects;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage[] sprite;
    private int id,tileType;
    public Tile(BufferedImage sprite,int tileType) {
        this.sprite = new BufferedImage[1];
        this.sprite[0] = sprite;
        this.tileType = tileType;
        
    }
    public Tile(BufferedImage[] sprite,int tileType) {
        this.sprite = sprite;
        this.tileType = tileType;
    }
    public int getTileType() {
        return tileType;
    }
    public BufferedImage getSprite(int animationIndex) {
        return sprite[animationIndex];
    }
    public BufferedImage getSprite() {
        return sprite[0];
    }
    public boolean isAnimation(){
        return sprite.length > 1;
    }
}
