package main;

import java.util.Random;

/**
 * Created by geraldlee on 2017-05-05.
 */
public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }


    public void tick() {
        scoreKeep++;
        if (scoreKeep % 500==0) {
            //scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

        }

        switch(hud.getLevel()){
            case 2:
                switch (scoreKeep%500) {
                    case 73:
                        Enemy1 a = new Enemy1(0, 0, ID.Enemy1, handler);
                        a.setSpeedY(1);
                        Enemy1 b = new Enemy1(0, 100, ID.Enemy1, handler);
                        b.setSpeedY(1);
                        Enemy1 c = new Enemy1(0, 200, ID.Enemy1, handler);
                        c.setSpeedY(1);

                        handler.addObject(a);
                        handler.addObject(b);
                        handler.addObject(c);

                    case 257:
                        Enemy1 d = new Enemy1(0, -100, ID.Enemy1, handler);
                        d.setSpeedY(1);
                        Enemy1 z = new Enemy1(0, -200, ID.Enemy1, handler);
                        z.setSpeedY(1);
                        handler.addObject(d);
                        handler.addObject(z);

                    default:
                        break;
                }

            case 3:

                switch (scoreKeep%1000) {
                    case 239:
                        Enemy1 x = new Enemy1(r.nextInt(Game.WIDTH), -500, ID.Enemy1, handler);
                        x.setSpeedY(2);
                        handler.addObject(x);
                        Enemy1 a = new Enemy1(0, -600, ID.Enemy1, handler);
                        a.setSpeedY(2);
                        Enemy1 b = new Enemy1(0, -700, ID.Enemy1, handler);
                        b.setSpeedY(2);
                        Enemy1 c = new Enemy1(0, -800, ID.Enemy1, handler);
                        c.setSpeedY(2);

                        handler.addObject(a);
                        handler.addObject(b);
                        handler.addObject(c);
                }
            case 4:
                switch(scoreKeep%1500){
                    case 239:
                        SmartEnemy x = new SmartEnemy(r.nextInt(Game.WIDTH), -800, ID.SmartEnemy, handler);
                        handler.addObject(x);
                        SmartEnemy y = new SmartEnemy(r.nextInt(Game.WIDTH), -600, ID.SmartEnemy, handler);
                        handler.addObject(y);
                        SmartEnemy z = new SmartEnemy(r.nextInt(Game.WIDTH), -400, ID.SmartEnemy, handler);
                        handler.addObject(z);
                        SmartEnemy a = new SmartEnemy(r.nextInt(Game.WIDTH), -1000, ID.SmartEnemy, handler);
                        handler.addObject(a);
                        SmartEnemy b = new SmartEnemy(r.nextInt(Game.WIDTH), -500, ID.SmartEnemy, handler);
                        handler.addObject(b);






                }}}
}
