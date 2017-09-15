package main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by geraldlee on 2017-05-03.
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i<object.size();i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }


}
