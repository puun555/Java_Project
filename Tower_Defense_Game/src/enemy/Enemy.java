/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import ui.Images;
import static helpz.Constant.Direction.*;
import helpz.Constant.Enemies;
/**
 *
 * @author sahad
 */
public abstract class Enemy {
    protected float x,y;
    protected Rectangle bounds;
    protected int HP,maxHP;
    protected double speed;
    protected int enemyType;
    protected int lastDir;
    protected boolean alive = true;
    public Enemy(float x,float y,int enemyType){
        this.x=x;
        this.y=y;
        this.speed = Enemies.GetSpeed(enemyType);
        this.enemyType=enemyType;
        bounds = new Rectangle((int)x,(int)y,32,32);
        this.lastDir = -1;
        setEnemieHealth();
    }
    private void setEnemieHealth(){
        HP = Enemies.GetHealth(enemyType);
        maxHP = HP;
    }
    public float getHPBar(){
        return HP/(float)maxHP;
    }
    public void move(int dir){
        lastDir = dir;
        switch(dir){
            case LEFT:
                this.x -= speed;
                break;
            case UP:
                this.y -= speed;
                break;
            case RIGHT:
                this.x += speed;
                break;
            case DOWN:
                this.y += speed;
                break;
        }
    }
    public void setPos(int x,int y){
        //for fix pos not fir moving
        this.x = x;
        this.y = y;
    }
    public void attacked(int dmg) {
        this.HP -= dmg;
        if(this.HP <= 0){
            alive = false;
        }
    }
    
    public Rectangle getBounds() {
        return bounds;
    }
    
    public int getHP() {
        return HP;
    }
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public int getLastDir() {
        return lastDir;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public boolean isAlive() {
        return alive;
    }
    
    
    
    
}
