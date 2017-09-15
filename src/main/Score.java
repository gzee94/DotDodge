package main;

import java.awt.*;

/**
 * Created by geraldlee on 2017-05-05.
 */
public class Score {
        public static int score = 0;

        public void tick(){
            score++;

        }

        public void render(Graphics g){
            g.drawString(Integer.toString(score),Game.WIDTH-100,Game.HEIGHT-100);
        }
}
