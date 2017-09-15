package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by geraldlee on 2017-05-03.
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 350 ;
    public static final int HEIGHT = 750;
    private static final String TITLE = "Run...";
    //public static final int WIDTH = ;
    private Menu menu;
    private End end;
    private Thread thread;
    private boolean running = false;
    private Random r ;
    private Handler handler;
    private HUD hud;
    public static int endscore;
    private Score score;
    private Spawn spawner;
    public enum STATE {
        Menu,
        Game,
        Help,
        End

    }

    public STATE gameState = STATE.Menu;


    public Game () {

        handler = new Handler();
        menu = new Menu(this,handler);
        end = new End(this,handler);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);


        new Window(WIDTH, HEIGHT, TITLE, this);
        hud = new HUD();
        spawner  = new Spawn(handler,hud);
        r = new Random();
        //score = new Score();

        if(gameState==STATE.Game) {
            handler.addObject(new Player(WIDTH / 2, (3 * (HEIGHT / 4)), ID.Player, handler));


            //for (int i x= 0; i < 5; i++) {
            Enemy1 x = new Enemy1(0, 10, ID.Enemy1, handler);
            x.setSpeedY(1);
            handler.addObject(x);
        }

    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void run(){ //copied
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs =  this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
        handler.render(g);


//        score.render(g);
//        g.drawstring()
        if(gameState==STATE.Menu||gameState==STATE.Help){
            menu.render(g);
        }
        if(gameState==STATE.Game){
            hud.render(g);
        }
        if(gameState==STATE.End){
            endscore = hud.getScore();
            end.render(g);


        }
        if(HUD.HEALTH ==0){

            for(int i = 0 ; i<handler.object.size();i++){
                GameObject tempObject = handler.object.get(i);
                handler.removeObject(tempObject);
            }
            gameState=STATE.End;
            this.addMouseListener(end);
        }


        g.dispose();
        bs.show();

    }
    public static float clamp(float var, int min, int max){
        if(var>=max){return var = max;}
        else if (var <=min) {return var = min;}
        else return var;

    }
    private void tick() {

        handler.tick();
        if(gameState==STATE.Menu){
            menu.tick();
        }
        if(gameState==STATE.Game){
            hud.tick();
//        score.tick();
            // handler.addObject(new Enemy1(r.nextInt(), 100, ID.Enemy1));
            spawner.tick();
        }
        if(gameState==STATE.End){
            end.tick();
        }
    }

    public static void main(String args[]){
        new Game();
    }

}
