package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;

import java.util.ArrayList;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    ArrayList<GameObject> gameObjects;
    ArrayList<Movable> movableObjects;

    public ActionDetector(ArrayList<GameObject> gameObjects) {
        
        this.gameObjects = gameObjects;

        for (int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i) instanceof Movable) {
                movableObjects.add((Movable)gameObjects.get(i));
            }
        }
    }

    public GameObjType checkAction() {

        for (int i = 0; i < gameObjects.size(); i++) {

        }
    }

    public GameObjType getObjType(GameObject gameObject) {
        return gameObject.getGameObjType();
    }

    public ArrayList<Movable> getMovableObjects() {
        return movableObjects;
    }

    //TODO: Peter and Vero think that this action detector should choose the action of the respective movable object
    //TODO: And method checkAction should be named chooseAction and be called by each movable object
}
