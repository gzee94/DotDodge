package main;

import java.awt.*;

/**
 * Created by geraldlee on 2017-05-05.
 */
public class Trail extends GameObject{
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private float life;

    public Trail(int x, int y, ID id, Color color,float life, Handler handler) {
        super(x, y, id);
        this.color = color;
    }

    @Override
    public void tick() {

        if (alpha>life) {
            alpha -= (life - 0.0001f);
        }else handler.removeObject(this);
        }




    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillOval((int)x,(int)y,20,30);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
    }
    @Override
    public Rectangle getBounds() {
        return null;
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
