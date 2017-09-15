package main;

import java.awt.*;
import java.util.Random;

/**
 * Created by geraldlee on 2017-05-03.
 */
public class Player extends GameObject {
    public Game.STATE gameState;
    Random r = new Random();
    Handler handler;
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;


    }

    @Override
    public void tick() {

        x+=speedX;
        y+=speedY;

        x = Game.clamp(x,0,Game.WIDTH-20);
        //handler.addObject(new Trail(x,y,ID.Trail,Color.red, 0.1f,handler));
 collision();
    }
private void collision(){
    for(int i = 0; i<handler.object.size();i++){
        GameObject tempObject=handler.object.get(i);
        if(tempObject.getid()==ID.Enemy1) {
            if (getBounds().intersects(tempObject.getBoundsL())) {
                HUD.HEALTH -= 1;
                if(HUD.HEALTH==0) gameState=Game.STATE.End;
            }
            if (getBounds().intersects(tempObject.getBoundsR())) {
                HUD.HEALTH -= 1;
                if(HUD.HEALTH==0) gameState=Game.STATE.End;
            }
        }
        if(tempObject.getid()==ID.SmartEnemy){
            if(getBounds().intersects(tempObject.getBounds())){
                HUD.HEALTH-=1;
                if(HUD.HEALTH==0) gameState=Game.STATE.End;
            }
        }

    }
}
    @Override
    public void render(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//
//        g.setColor(Color.yellow);
//        g2d.draw(getBounds());


        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,20,30);

    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int)x,(int)y,20,30);
    }

    @Override
    public Rectangle getBoundsR() {
        return null;
    }

    @Override
    public Rectangle getBoundsL() {
        return null;
    }


}
