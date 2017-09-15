package main;

import java.awt.*;

/**
 * Created by geraldlee on 2017-05-03.
 */
public abstract class GameObject {
    protected float x;
    protected float y;
    protected ID id;
    protected float speedX, speedY;

    public GameObject(int x, int y , ID id){
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick();


    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract Rectangle getBoundsR();
    public abstract Rectangle getBoundsL();


    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
    public float getX(){
        return x;
    }

    public float getY(){
        return y;

    }
    public void setid(){
        this.id = id;
    }
    public ID getid(){
        return id;
    }

    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }

    public float getSpeedX(){
        return speedX;
    }
    public float getSpeedY(){
        return speedY;
    }


}
