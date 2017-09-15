package main;

import java.awt.*;


/**
 * Created by geraldlee on 2017-05-03.
 */
public class SmartEnemy extends GameObject {
    private final Handler handler;
private GameObject player;



    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i<handler.object.size();i++){
            if(handler.object.get(i).getid()==ID.Player)
                player=handler.object.get(i);
        }

    }

    @Override
    public void tick() {

        x += speedX;
        y += speedY;

        float diffX= x-player.getX()-16;
        float diffY = y-player.getY()-16;
        float distance=(float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));

        speedX=  ((-3/distance)*diffX);
        speedY=  ((-1/distance)*diffY+2);

//
//        if(y<=0||y>=Game.HEIGHT) speedY=0;
//        else speedY=1;


    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int)x,(int) y,16,16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,15,15);}

    public Rectangle getBoundsL() {
        return null;
    }

    public Rectangle getBoundsR() {
        return null;
    }
}
