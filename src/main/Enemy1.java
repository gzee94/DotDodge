package main;

import java.awt.*;
import java.util.Random;


/**
 * Created by geraldlee on 2017-05-03.
 */
public class Enemy1 extends GameObject {
    private final Handler handler;
//    private Random r;
Random r = new Random();
    int sizexx = r.nextInt(Game.WIDTH-50);
     int sizey =20;



    public Enemy1(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }
    public void spawnLeft(Graphics g, int sizex){
        g.setColor(Color.red);
        g.fillRect(0, (int)y, sizex, sizey);

    }
    public void spawnRight(Graphics g, int sizex){
        g.setColor(Color.red);
        g.fillRect(sizex+50, (int)y, Game.WIDTH-(sizex+50), sizey);

    }
    public void endLeft(Graphics g, int sizex){
        g.setColor(Color.black);
        g.fillRect(0, (int)y, sizex, sizey);

    }
    public void endRight(Graphics g, int sizex){
        g.setColor(Color.black);
        g.fillRect(sizex+50, (int)y, Game.WIDTH-(sizex+50), sizey);

    }

    @Override
    public void tick() {

        x += speedX;
        y += speedY;
//        if(y<=0||y>=Game.HEIGHT) speedY=0;
//        else speedY=1;


    }

    @Override
    public void render(Graphics g) {
        spawnLeft(g, sizexx);
        spawnRight(g, sizexx);

        if(y<=0||y>=Game.HEIGHT){
            endLeft(g, sizexx);
            endRight(g, sizexx);
        }
    }

    @Override
    public Rectangle getBounds() {
    return null;}

    public Rectangle getBoundsL() {
        return new Rectangle(0, (int)y, sizexx, sizey);
    }

    public Rectangle getBoundsR() {
        return new Rectangle(sizexx+50,(int) y, Game.WIDTH-(sizexx+50), sizey);
    }
    }
