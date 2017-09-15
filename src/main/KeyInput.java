package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import static main.Game.HEIGHT;
import static main.Game.WIDTH;

/**
 * Created by geraldlee on 2017-05-03.
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keyDown = new boolean[2];
    private Game game;



    public KeyInput(Handler handler){

        this.handler = handler;
        keyDown[0]=false;
        keyDown[1]=false;
//        keyDown[2]=false;
//        keyDown[3]=false;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
//        if(game.gameState==Game.STATE.Menu) {
//            if (key == KeyEvent.VK_SPACE) {
//                game.gameState = Game.STATE.Game;
//                Random r = new Random();
//                handler.addObject(new Player(WIDTH / 2, (3 * (HEIGHT / 4)), ID.Player, handler));
//                Enemy1 a = new Enemy1(0, 0, ID.Enemy1, handler);
//                a.setSpeedY(1);
//                Enemy1 b = new Enemy1(0, 100, ID.Enemy1, handler);
//                b.setSpeedY(1);
//                Enemy1 c = new Enemy1(0, 200, ID.Enemy1, handler);
//                c.setSpeedY(1);
//                Enemy1 d = new Enemy1(0, 300, ID.Enemy1, handler);
//                d.setSpeedY(1);
//                Enemy1 z = new Enemy1(0, 400, ID.Enemy1, handler);
//                z.setSpeedY(1);
//                handler.addObject(a);
//                handler.addObject(b);
//                handler.addObject(c);
//                handler.addObject(d);
//                handler.addObject(z);
//            }
//        }
        if(key== KeyEvent.VK_SPACE){
            game.gameState = Game.STATE.Game;
        }

        for(int i = 0; i<handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getid()==ID.Player){
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setSpeedX(-5);
                    keyDown[0]=true;}
                if (key==KeyEvent.VK_RIGHT) {
                    tempObject.setSpeedX(5);
                    keyDown[1]=true;}
                //System.out.println(e);
            }
        }

        if(key==KeyEvent.VK_ESCAPE)System.exit(1);
    }


    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getid() == ID.Player) {
                if (key == KeyEvent.VK_LEFT) keyDown[0]=false;//tempObject.setSpeedX(0);
                if (key == KeyEvent.VK_RIGHT) keyDown[1]=false; //tempObject.setSpeedX(0);
                // System.out.println(e);
                if(!keyDown[0]&&!keyDown[1])tempObject.setSpeedX(0);
            }
        }
    }
}

