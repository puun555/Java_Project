package objects;

import java.awt.geom.Point2D;

/**
 *
 * @author sahad
 */
public class MagicProjectile {
    private Point2D.Float pos;
    private int id,magicType;
    private boolean active = true;
    public MagicProjectile(float x, float y, int id, int magicType){
       pos = new Point2D.Float(x,y);
       this.id = id;
       this.magicType = magicType;
    }
    public void move(float x, float y){
        pos.x += x;
        pos.y += y;
    }

    public Point2D.Float getPos() {
        return pos;
    }

    public int getId() {
        return id;
    }

    public int getMagicType() {
        return magicType;
    }

    public boolean isActive() {
        return active;
    }

    public void setPos(Point2D.Float pos) {
        this.pos = pos;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
