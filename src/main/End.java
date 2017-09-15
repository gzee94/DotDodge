package main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static main.Game.HEIGHT;
import static main.Game.WIDTH;

/**
 * Created by geraldlee on 2017-05-09.
 */
public class End extends MouseAdapter {
    private Handler handler;
    private Game game;
    private HUD hud;
    //private int endscore;


    public End(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == Game.STATE.Menu) {

            if (game.gameState == Game.STATE.End) {
                if (mouseBoundaries(mx, my, 0,0, WIDTH, HEIGHT)) {
                    game.gameState = Game.STATE.Game;
                }
            }
        }
    }

    private boolean mouseBoundaries(int mx, int my, int x, int y, int w, int h) {
        if (mx > x && mx < x + w) {
            return my > y && my < y + h;
        } else return false;

    }

    public void  render(Graphics g){
        Font f = new Font("arial", WIDTH/3, 30);
        g.setFont(f);
        g.setColor(Color.orange);
        g.drawString("Game Over", WIDTH/4+5, HEIGHT/3);
        g.drawString("Final Score:"+Integer.toString(Game.endscore), WIDTH/5, HEIGHT/3+50);

    }
    public void tick(){}

}
