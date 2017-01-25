package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.AbstractMovable;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;

/**
 * Created by codecadet on 25/01/17.
 */
public class ActionDetector {

    Game game;
    GameObject[] gameObjects;
    Movable[] movableObjects;

    public ActionDetector(Game game) {
        this.game = game;
        this.gameObjects = game.getGameObjects();

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
}
