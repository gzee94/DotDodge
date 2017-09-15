package main;

import java.awt.*;

/**
 * Created by geraldlee on 2017-05-05.
 */
public class HUD {

    public static float HEALTH = (Game.WIDTH)/4+18;
    private int h = (int) HEALTH;
    private float greenValue = 255;
    public int score=0;
    private int level = 1;

    public void tick(){
        //HEALTH--;

        HEALTH= Game.clamp(HEALTH,0,(Game.WIDTH/5)*3);

        greenValue = Game.clamp(greenValue,0,255);
        greenValue = HEALTH;
        score++;



    }

    public void render(Graphics g){
        g.setColor(Color.magenta);
        g.fillRect(15,15,(Game.WIDTH/5)*3,32);
        g.setColor(new Color(100,(int)greenValue,0));
        g.fillRect(15,15,(int)HEALTH*2,32);
        g.setColor(Color.WHITE);
        g.drawRect(15,15,(Game.WIDTH/5)*3,32);
        g.drawString("Score: "+score,Game.WIDTH-90,30);
        g.drawString("Level: "+level,Game.WIDTH-90,45);



    }
    public void score(int score){
        this.score=score;

    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
