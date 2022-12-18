package objects;

import java.awt.geom.Point2D;

/**
 *
 * @author sahad
 */
public class MagicProjectile {
    private Point2D.Float pos;
    private int id,magicType;
    private float xSpeed,ySpeed;
    private boolean active = true;
    public MagicProjectile(float x, float y,float xSpeed,float ySpeed, int id, int magicType){
       pos = new Point2D.Float(x,y);
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
       this.id = id;
       this.magicType = magicType;
    }
    public void move(){
        pos.x += xSpeed;
        pos.y += ySpeed;
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
