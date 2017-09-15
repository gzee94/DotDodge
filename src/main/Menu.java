package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static main.Game.HEIGHT;
import static main.Game.WIDTH;

/**
 * Created by geraldlee on 2017-05-07.
 */
public class Menu extends MouseAdapter {
    Game game;
    Handler handler;
    int WIDTH = Game.WIDTH;
    int HEIGHT = Game.HEIGHT;

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font f = new Font("arial", 1, 50);
            g.setFont(f);
            g.setColor(Color.orange);

            g.setFont(f);

            g.drawString("DOT DODGE", WIDTH/10, HEIGHT/7);
            g.setColor(Color.magenta);
            g.drawRect(WIDTH/3, 250, WIDTH/3, 64);
            g.drawString("Play", WIDTH/3+10, 300);
            g.setColor(Color.WHITE);
            g.drawRect(WIDTH/3, 350, WIDTH/3, 64);
            g.drawString("Help", WIDTH/3+5, 400);

            g.setColor(Color.green);
            g.drawRect(WIDTH/3, 450, WIDTH/3, 64);
            g.drawString("Exit", WIDTH/3+10, 500);
        }
        if (game.gameState == Game.STATE.Help) {
            Font first = new Font("arial", 1, 50);

            g.setFont(first);
            g.setColor(Color.GREEN);
            g.setFont(first);
            g.drawString("HELP", WIDTH/4, 120);


            Font f = new Font("arial", 1, 18);

            g.setFont(f);
            g.setColor(Color.white);
            g.setFont(f);
            g.drawString("Left and Right keys to dodge.", WIDTH/6, 200);
            g.drawString("Avoid the red blocks,", WIDTH/6+20, 230);
            g.drawString("Avoid the pink dudes,", WIDTH/6+20, 260);

            Font ff = new Font("arial", 1, 40);
            g.setFont(ff);
            g.setColor(Color.red);
            g.setFont(f);
            g.drawString("Survive.", WIDTH/4+40, 290);

            g.setColor(Color.green);
            g.drawRect(WIDTH/9, 450, 100, 40);
            g.drawString("Back ", 75, 475);

        }

    }

    public void tick() {
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == Game.STATE.Menu) {
            if (mouseBoundaries(mx, my, WIDTH/3, 250, WIDTH/2, 64)) {
                game.gameState = Game.STATE.Game;
                Random r = new Random();
                handler.addObject(new Player(WIDTH / 2, (3 * (HEIGHT / 4)), ID.Player, handler));
                Enemy1 a = new Enemy1(0, 0, ID.Enemy1, handler);
                a.setSpeedY(1);
                Enemy1 b = new Enemy1(0, 100, ID.Enemy1, handler);
                b.setSpeedY(1);
                Enemy1 c = new Enemy1(0, 200, ID.Enemy1, handler);
                c.setSpeedY(1);
                Enemy1 d = new Enemy1(0, 300, ID.Enemy1, handler);
                d.setSpeedY(1);
                Enemy1 z = new Enemy1(0, 400, ID.Enemy1, handler);
                z.setSpeedY(1);
                handler.addObject(a);
                handler.addObject(b);
                handler.addObject(c);
                handler.addObject(d);
                handler.addObject(z);

            }
            if (mouseBoundaries(mx, my, WIDTH/3, 350, WIDTH/3, 64)) {
                game.gameState = Game.STATE.Help;
            }
            if (mouseBoundaries(mx, my, WIDTH/3, 450, WIDTH/3, 64)) {
                System.exit(1);
            }

        }

        if (game.gameState == Game.STATE.Help) {
            if (mouseBoundaries(mx, my, WIDTH/9, 450, 100, 40)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

    }

    public void mouseReleased(MouseEvent e) {
    }

    private boolean mouseBoundaries(int mx, int my, int x, int y, int w, int h) {
        if (mx > x && mx < x + w) {
            return my > y && my < y + h;
        } else return false;

    }
}

