package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    GameObject[] gameObjects;
    Movable[] movableObjects;

    public ActionDetector(GameObject[] gameObjects) {
        
        this.gameObjects = gameObjects;

        for (int i = 0; i < gameObjects.length; i++) {
            if(gameObjects[i] instanceof Movable) {
                movableObjects[i] = (Movable)gameObjects[i];
            }
        }
    }

    public GameObjType checkAction() {

        for (int i = 0; i < gameObjects.length; i++) {

        }
    }

    public GameObjType getObjType(GameObject gameObject) {
        return gameObject.getGameObjType();
    }

    public Movable[] getMovableObjects() {
        return movableObjects;
    }
}
